package com.jackrr.crystalline.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.level.Level;
import java.util.UUID;

public class EntityRuby extends PathfinderMob {
    private UUID gemUUID;

    public void setGemUUID(UUID gemUUID) {
        this.gemUUID = gemUUID;
    }

    public EntityRuby(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.5));
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    public UUID getGemUUID() {
        return gemUUID;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.ATTACK_DAMAGE, 20)
                .add(Attributes.FOLLOW_RANGE, 50);
    }
}
