/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelFirefly
/*     */   extends ModelBase
/*     */ {
/*  15 */   private float wingspeed = 1.0F;
/*     */   
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
/*  31 */     this.textureWidth = 64;
/*  32 */     this.textureHeight = 128;
/*  33 */     this.wingspeed = f1;
/*     */     
/*  35 */     this.body = new ModelRenderer(this, 38, 12);
/*  36 */     this.body.addBox(-3.0F, -3.0F, -3.0F, 5, 5, 5);
/*  37 */     this.body.setRotationPoint(-1.0F, 9.0F, -1.0F);
/*  38 */     this.body.setTextureSize(64, 128);
/*  39 */     this.body.mirror = true;
/*  40 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  41 */     this.wing_left = new ModelRenderer(this, 46, 0);
/*  42 */     this.wing_left.addBox(0.0F, -6.0F, 0.0F, 0, 6, 2);
/*  43 */     this.wing_left.setRotationPoint(1.0F, 6.0F, -2.0F);
/*  44 */     this.wing_left.setTextureSize(64, 128);
/*  45 */     this.wing_left.mirror = true;
/*  46 */     setRotation(this.wing_left, 0.0F, 0.0174533F, 0.6981317F);
/*  47 */     this.wing_right = new ModelRenderer(this, 53, 0);
/*  48 */     this.wing_right.addBox(0.0F, -6.0F, 0.0F, 0, 6, 2);
/*  49 */     this.wing_right.setRotationPoint(-4.0F, 6.0F, -2.0F);
/*  50 */     this.wing_right.setTextureSize(64, 128);
/*  51 */     this.wing_right.mirror = true;
/*  52 */     setRotation(this.wing_right, 0.0F, 0.0F, -0.6981317F);
/*  53 */     this.head = new ModelRenderer(this, 3, 14);
/*  54 */     this.head.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
/*  55 */     this.head.setRotationPoint(-3.0F, 7.0F, -7.0F);
/*  56 */     this.head.setTextureSize(64, 128);
/*  57 */     this.head.mirror = true;
/*  58 */     setRotation(this.head, 0.2230717F, 0.0F, 0.0F);
/*  59 */     this.mouth = new ModelRenderer(this, 26, 15);
/*  60 */     this.mouth.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
/*  61 */     this.mouth.setRotationPoint(-2.0F, 9.0F, -8.0F);
/*  62 */     this.mouth.setTextureSize(64, 128);
/*  63 */     this.mouth.mirror = true;
/*  64 */     setRotation(this.mouth, 0.2117115F, 0.0F, 0.0F);
/*  65 */     this.eye_left = new ModelRenderer(this, 18, 12);
/*  66 */     this.eye_left.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
/*  67 */     this.eye_left.setRotationPoint(-1.0F, 6.5F, -6.0F);
/*  68 */     this.eye_left.setTextureSize(64, 128);
/*  69 */     this.eye_left.mirror = true;
/*  70 */     setRotation(this.eye_left, 0.0174533F, 0.2602503F, -0.2230717F);
/*  71 */     this.eye_right = new ModelRenderer(this, 18, 18);
/*  72 */     this.eye_right.addBox(1.0F, -0.6F, -0.6F, 1, 2, 2);
/*  73 */     this.eye_right.setRotationPoint(-4.0F, 6.5F, -6.0F);
/*  74 */     this.eye_right.setTextureSize(64, 128);
/*  75 */     this.eye_right.mirror = true;
/*  76 */     setRotation(this.eye_right, 0.0F, -0.2602503F, 0.2230717F);
/*  77 */     this.front_leg_left_ = new ModelRenderer(this, 32, 0);
/*  78 */     this.front_leg_left_.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  79 */     this.front_leg_left_.setRotationPoint(-1.0F, 10.0F, -3.0F);
/*  80 */     this.front_leg_left_.setTextureSize(64, 128);
/*  81 */     this.front_leg_left_.mirror = true;
/*  82 */     setRotation(this.front_leg_left_, -0.2792527F, 0.0F, -0.2792527F);
/*  83 */     this.front_leg_right = new ModelRenderer(this, 22, 0);
/*  84 */     this.front_leg_right.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  85 */     this.front_leg_right.setRotationPoint(-3.0F, 10.0F, -3.0F);
/*  86 */     this.front_leg_right.setTextureSize(64, 128);
/*  87 */     this.front_leg_right.mirror = true;
/*  88 */     setRotation(this.front_leg_right, -0.2792527F, 0.0F, 0.2792527F);
/*  89 */     this.back_leg_left = new ModelRenderer(this, 11, 0);
/*  90 */     this.back_leg_left.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  91 */     this.back_leg_left.setRotationPoint(-1.0F, 10.0F, -1.0F);
/*  92 */     this.back_leg_left.setTextureSize(64, 128);
/*  93 */     this.back_leg_left.mirror = true;
/*  94 */     setRotation(this.back_leg_left, 0.2792527F, 0.0F, -0.2792527F);
/*  95 */     this.back_leg_right = new ModelRenderer(this, 2, 0);
/*  96 */     this.back_leg_right.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  97 */     this.back_leg_right.setRotationPoint(-3.0F, 10.0F, -1.0F);
/*  98 */     this.back_leg_right.setTextureSize(64, 128);
/*  99 */     this.back_leg_right.mirror = true;
/* 100 */     setRotation(this.back_leg_right, 0.2792527F, 0.0F, 0.2792527F);
/* 101 */     this.TailLight = new ModelRenderer(this, 10, 27);
/* 102 */     this.TailLight.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4);
/* 103 */     this.TailLight.setRotationPoint(-3.0F, 6.0F, 1.0F);
/* 104 */     this.TailLight.setTextureSize(64, 128);
/* 105 */     this.TailLight.mirror = true;
/* 106 */     setRotation(this.TailLight, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 111 */     Firefly fly = (Firefly)entity;
/* 112 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 113 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 114 */     float onoff = 0.0F;
/*     */     
/* 116 */     this.wing_left.rotateAngleZ = 1.11F + MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.35F;
/* 117 */     this.wing_right.rotateAngleZ = -1.11F - MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.35F;
/*     */     
/* 119 */     this.body.render(f5);
/* 120 */     this.wing_left.render(f5);
/* 121 */     this.wing_right.render(f5);
/* 122 */     this.head.render(f5);
/* 123 */     this.mouth.render(f5);
/* 124 */     this.eye_left.render(f5);
/* 125 */     this.eye_right.render(f5);
/* 126 */     this.front_leg_left_.render(f5);
/* 127 */     this.front_leg_right.render(f5);
/* 128 */     this.back_leg_left.render(f5);
/* 129 */     this.back_leg_right.render(f5);
/* 130 */     onoff = fly.getBlink();
/* 131 */     OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, onoff, 240.0F);
/* 132 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 133 */     this.TailLight.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 139 */     model.rotateAngleX = x;
/* 140 */     model.rotateAngleY = y;
/* 141 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 146 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelFirefly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */