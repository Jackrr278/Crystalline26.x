package com.jackrr.crystalline.entity.client.render;

import com.jackrr.crystalline.entity.client.ModelRuby;
import com.jackrr.crystalline.entity.custom.EntityRuby;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RendererRuby extends MobRenderer<EntityRuby, LivingEntityRenderState, ModelRuby> {

    public RendererRuby(EntityRendererProvider.Context context) {
        super(
                context,
                new ModelRuby(context.bakeLayer(ModelRuby.LAYER_LOCATION)),
                0.5f
        );
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return Identifier.fromNamespaceAndPath(
                "crystalline",
                "textures/entity/ruby/ruby_1.png"
        );
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    protected void scale(LivingEntityRenderState state, PoseStack poseStack) {
        poseStack.scale(2.0F, 2.0F, 2.0F);
    }
}