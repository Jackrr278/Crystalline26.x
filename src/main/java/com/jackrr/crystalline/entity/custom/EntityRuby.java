package com.jackrr.crystalline.entity.custom;

import net.minecraft.core.UUIDUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.UUID;

public class EntityRuby extends PathfinderMob {
    private UUID gemUUID;

    public void setGemUUID(UUID gemUUID) {
        this.gemUUID = gemUUID;
    }

    public EntityRuby(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.gemUUID = UUID.randomUUID();
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

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);

        output.store("GemUUID", UUIDUtil.CODEC, gemUUID);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);

        this.gemUUID = input.read("GemUUID", UUIDUtil.CODEC).orElse(UUID.randomUUID());
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.ATTACK_DAMAGE, 20)
                .add(Attributes.FOLLOW_RANGE, 50);
    }
}
