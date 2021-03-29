/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Firefly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelFirefly
/*     */   extends ModelBase
/*     */ {
/*  14 */   private float wingspeed = 1.0F;
/*     */   ModelRenderer body;
/*     */   ModelRenderer wing_left;
/*     */   ModelRenderer wing_right;
/*     */   ModelRenderer head;
/*     */   ModelRenderer mouth;
/*     */   ModelRenderer eye_left;
/*     */   ModelRenderer eye_right;
/*     */   ModelRenderer front_leg_left_;
/*     */   ModelRenderer front_leg_right;
/*     */   ModelRenderer back_leg_left;
/*     */   ModelRenderer back_leg_right;
/*     */   ModelRenderer TailLight;
/*     */   
/*     */   public ModelFirefly(float f1) {
/*  29 */     this.textureWidth = 64;
/*  30 */     this.textureHeight = 128;
/*  31 */     this.wingspeed = f1;
/*     */     
/*  33 */     this.body = new ModelRenderer(this, 38, 12);
/*  34 */     this.body.addBox(-3.0F, -3.0F, -3.0F, 5, 5, 5);
/*  35 */     this.body.setRotationPoint(-1.0F, 9.0F, -1.0F);
/*  36 */     this.body.setTextureSize(64, 128);
/*  37 */     this.body.mirror = true;
/*  38 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  39 */     this.wing_left = new ModelRenderer(this, 46, 0);
/*  40 */     this.wing_left.addBox(0.0F, -6.0F, 0.0F, 0, 6, 2);
/*  41 */     this.wing_left.setRotationPoint(1.0F, 6.0F, -2.0F);
/*  42 */     this.wing_left.setTextureSize(64, 128);
/*  43 */     this.wing_left.mirror = true;
/*  44 */     setRotation(this.wing_left, 0.0F, 0.0174533F, 0.6981317F);
/*  45 */     this.wing_right = new ModelRenderer(this, 53, 0);
/*  46 */     this.wing_right.addBox(0.0F, -6.0F, 0.0F, 0, 6, 2);
/*  47 */     this.wing_right.setRotationPoint(-4.0F, 6.0F, -2.0F);
/*  48 */     this.wing_right.setTextureSize(64, 128);
/*  49 */     this.wing_right.mirror = true;
/*  50 */     setRotation(this.wing_right, 0.0F, 0.0F, -0.6981317F);
/*  51 */     this.head = new ModelRenderer(this, 3, 14);
/*  52 */     this.head.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
/*  53 */     this.head.setRotationPoint(-3.0F, 7.0F, -7.0F);
/*  54 */     this.head.setTextureSize(64, 128);
/*  55 */     this.head.mirror = true;
/*  56 */     setRotation(this.head, 0.2230717F, 0.0F, 0.0F);
/*  57 */     this.mouth = new ModelRenderer(this, 26, 15);
/*  58 */     this.mouth.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
/*  59 */     this.mouth.setRotationPoint(-2.0F, 9.0F, -8.0F);
/*  60 */     this.mouth.setTextureSize(64, 128);
/*  61 */     this.mouth.mirror = true;
/*  62 */     setRotation(this.mouth, 0.2117115F, 0.0F, 0.0F);
/*  63 */     this.eye_left = new ModelRenderer(this, 18, 12);
/*  64 */     this.eye_left.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
/*  65 */     this.eye_left.setRotationPoint(-1.0F, 6.5F, -6.0F);
/*  66 */     this.eye_left.setTextureSize(64, 128);
/*  67 */     this.eye_left.mirror = true;
/*  68 */     setRotation(this.eye_left, 0.0174533F, 0.2602503F, -0.2230717F);
/*  69 */     this.eye_right = new ModelRenderer(this, 18, 18);
/*  70 */     this.eye_right.addBox(1.0F, -0.6F, -0.6F, 1, 2, 2);
/*  71 */     this.eye_right.setRotationPoint(-4.0F, 6.5F, -6.0F);
/*  72 */     this.eye_right.setTextureSize(64, 128);
/*  73 */     this.eye_right.mirror = true;
/*  74 */     setRotation(this.eye_right, 0.0F, -0.2602503F, 0.2230717F);
/*  75 */     this.front_leg_left_ = new ModelRenderer(this, 32, 0);
/*  76 */     this.front_leg_left_.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  77 */     this.front_leg_left_.setRotationPoint(-1.0F, 10.0F, -3.0F);
/*  78 */     this.front_leg_left_.setTextureSize(64, 128);
/*  79 */     this.front_leg_left_.mirror = true;
/*  80 */     setRotation(this.front_leg_left_, -0.2792527F, 0.0F, -0.2792527F);
/*  81 */     this.front_leg_right = new ModelRenderer(this, 22, 0);
/*  82 */     this.front_leg_right.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  83 */     this.front_leg_right.setRotationPoint(-3.0F, 10.0F, -3.0F);
/*  84 */     this.front_leg_right.setTextureSize(64, 128);
/*  85 */     this.front_leg_right.mirror = true;
/*  86 */     setRotation(this.front_leg_right, -0.2792527F, 0.0F, 0.2792527F);
/*  87 */     this.back_leg_left = new ModelRenderer(this, 11, 0);
/*  88 */     this.back_leg_left.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  89 */     this.back_leg_left.setRotationPoint(-1.0F, 10.0F, -1.0F);
/*  90 */     this.back_leg_left.setTextureSize(64, 128);
/*  91 */     this.back_leg_left.mirror = true;
/*  92 */     setRotation(this.back_leg_left, 0.2792527F, 0.0F, -0.2792527F);
/*  93 */     this.back_leg_right = new ModelRenderer(this, 2, 0);
/*  94 */     this.back_leg_right.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  95 */     this.back_leg_right.setRotationPoint(-3.0F, 10.0F, -1.0F);
/*  96 */     this.back_leg_right.setTextureSize(64, 128);
/*  97 */     this.back_leg_right.mirror = true;
/*  98 */     setRotation(this.back_leg_right, 0.2792527F, 0.0F, 0.2792527F);
/*  99 */     this.TailLight = new ModelRenderer(this, 10, 27);
/* 100 */     this.TailLight.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4);
/* 101 */     this.TailLight.setRotationPoint(-3.0F, 6.0F, 1.0F);
/* 102 */     this.TailLight.setTextureSize(64, 128);
/* 103 */     this.TailLight.mirror = true;
/* 104 */     setRotation(this.TailLight, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 108 */     Firefly fly = (Firefly)entity;
/* 109 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 110 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 111 */     float onoff = 0.0F;
/*     */     
/* 113 */     this.wing_left.rotateAngleZ = 1.11F + MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.35F;
/* 114 */     this.wing_right.rotateAngleZ = -1.11F - MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.35F;
/*     */     
/* 116 */     this.body.render(f5);
/* 117 */     this.wing_left.render(f5);
/* 118 */     this.wing_right.render(f5);
/* 119 */     this.head.render(f5);
/* 120 */     this.mouth.render(f5);
/* 121 */     this.eye_left.render(f5);
/* 122 */     this.eye_right.render(f5);
/* 123 */     this.front_leg_left_.render(f5);
/* 124 */     this.front_leg_right.render(f5);
/* 125 */     this.back_leg_left.render(f5);
/* 126 */     this.back_leg_right.render(f5);
/* 127 */     onoff = fly.getBlink();
/* 128 */     OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, onoff, 240.0F);
/* 129 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 130 */     this.TailLight.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 135 */     model.rotateAngleX = x;
/* 136 */     model.rotateAngleY = y;
/* 137 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 141 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelFirefly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */