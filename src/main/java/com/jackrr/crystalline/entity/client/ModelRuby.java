package com.jackrr.crystalline.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.jackrr.crystalline.Crystalline;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class ModelRuby extends EntityModel<LivingEntityRenderState> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(
                    Identifier.fromNamespaceAndPath(Crystalline.MODID, "rubymodel"),
                    "main"
            );

    private final ModelPart head;
    private final ModelPart hair;
    private final ModelPart torso;
    private final ModelPart r_arm;
    private final ModelPart l_arm;
    private final ModelPart l_leg;
    private final ModelPart r_leg;

    public ModelRuby(ModelPart root) {
        super(root);

        this.head = root.getChild("head");
        this.hair = this.head.getChild("hair");
        this.torso = root.getChild("torso");
        this.r_arm = root.getChild("r_arm");
        this.l_arm = root.getChild("l_arm");
        this.l_leg = root.getChild("l_leg");
        this.r_leg = root.getChild("r_leg");
    }

    public static LayerDefinition createBodyLayer() {

        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild(
                "head",
                CubeListBuilder.create()
                        .texOffs(0, 7)
                        .addBox(
                                -2.0F, -12.0F, -2.0F,
                                4.0F, 4.0F, 4.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(0.0F, 24.0F, 0.0F)
        );

        PartDefinition hair = head.addOrReplaceChild(
                "hair",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(
                                -4.0F, -14.0F, -2.0F,
                                8.0F, 2.0F, 5.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(0, 15)
                        .addBox(
                                -4.0F, -12.0F, -2.0F,
                                2.0F, 4.0F, 5.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(14, 15)
                        .addBox(
                                2.0F, -12.0F, -2.0F,
                                2.0F, 4.0F, 5.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(0, 24)
                        .addBox(
                                -2.0F, -12.0F, 2.0F,
                                4.0F, 4.0F, 1.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(0.0F, 0.0F, 0.0F)
        );

        PartDefinition torso = partdefinition.addOrReplaceChild(
                "torso",
                CubeListBuilder.create()
                        .texOffs(16, 7)
                        .addBox(
                                -2.0F, -8.0F, -1.0F,
                                4.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(0.0F, 24.0F, 0.0F)
        );

        // Right arm
        PartDefinition r_arm = partdefinition.addOrReplaceChild(
                "r_arm",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(
                                0.0F, 0.0F, -1.0F,
                                2.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(2.0F, 16.0F, 0.0F)
        );

        // Left arm
        PartDefinition l_arm = partdefinition.addOrReplaceChild(
                "l_arm",
                CubeListBuilder.create()
                        .texOffs(18, 24)
                        .addBox(
                                -2.0F, 0.0F, -1.0F,
                                2.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(-2.0F, 16.0F, 0.0F)
        );

        // Left leg
        PartDefinition l_leg = partdefinition.addOrReplaceChild(
                "l_leg",
                CubeListBuilder.create()
                        .texOffs(26, 0)
                        .addBox(
                                -1.0F, 0.0F, -1.0F,
                                2.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(-1.0F, 20.0F, 0.0F)
        );

        // Right leg
        PartDefinition r_leg = partdefinition.addOrReplaceChild(
                "r_leg",
                CubeListBuilder.create()
                        .texOffs(26, 24)
                        .addBox(
                                -1.0F, 0.0F, -1.0F,
                                2.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(1.0F, 20.0F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);

        float walkPos = state.walkAnimationPos;
        float walkSpeed = state.walkAnimationSpeed;

        this.r_arm.xRot = Mth.cos(walkPos * 0.6662F) * walkSpeed;
        this.l_arm.xRot = Mth.cos(walkPos * 0.6662F + Mth.PI) * walkSpeed;

        this.r_leg.xRot = Mth.cos(walkPos * 0.6662F + Mth.PI) * walkSpeed;
        this.l_leg.xRot = Mth.cos(walkPos * 0.6662F) * walkSpeed;

        this.head.xRot = Mth.cos(walkPos * 0.6662F) * walkSpeed * 0.15F;
        this.head.yRot = Mth.cos(walkPos * 0.3331F) * walkSpeed * 0.1F;
    }
}