/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelButterfly
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer body;
/*     */   ModelRenderer leftwing;
/*     */   ModelRenderer rightwing;
/*     */   ModelRenderer leftwing2;
/*     */   ModelRenderer rightwing2;
/*     */   ModelRenderer leftwing3;
/*     */   ModelRenderer rightwing3;
/*     */   ModelRenderer head;
/*     */   ModelRenderer leftwing4;
/*     */   ModelRenderer rightwing4;
/*  22 */   private float wingspeed = 1.0F;
/*     */   private float scale;
/*     */   
/*     */   public ModelButterfly(float f1, float scale) {
/*  26 */     this.scale = scale;
/*  27 */     this.textureWidth = 64;
/*  28 */     this.textureHeight = 32;
/*  29 */     this.wingspeed = f1;
/*     */     
/*  31 */     this.body = new ModelRenderer(this, 21, 19);
/*  32 */     this.body.addBox(0.0F, 0.0F, -4.0F, 1, 1, 8);
/*  33 */     this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  34 */     this.body.setTextureSize(64, 32);
/*  35 */     this.body.mirror = true;
/*  36 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  37 */     this.leftwing = new ModelRenderer(this, 43, 24);
/*  38 */     this.leftwing.addBox(0.0F, 0.0F, -4.0F, 5, 1, 5);
/*  39 */     this.leftwing.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  40 */     this.leftwing.setTextureSize(64, 32);
/*  41 */     this.leftwing.mirror = true;
/*  42 */     setRotation(this.leftwing, 0.0F, 0.0F, 0.0F);
/*  43 */     this.rightwing = new ModelRenderer(this, 43, 17);
/*  44 */     this.rightwing.addBox(-5.0F, 0.0F, -4.0F, 5, 1, 5);
/*  45 */     this.rightwing.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  46 */     this.rightwing.setTextureSize(64, 32);
/*  47 */     this.rightwing.mirror = true;
/*  48 */     setRotation(this.rightwing, 0.0F, 0.0F, 0.0F);
/*  49 */     this.leftwing2 = new ModelRenderer(this, 0, 0);
/*  50 */     this.leftwing2.addBox(1.0F, 0.0F, -6.0F, 6, 1, 7);
/*  51 */     this.leftwing2.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  52 */     this.leftwing2.setTextureSize(64, 32);
/*  53 */     this.leftwing2.mirror = true;
/*  54 */     setRotation(this.leftwing2, 0.0F, 0.0F, 0.0F);
/*  55 */     this.rightwing2 = new ModelRenderer(this, 29, 0);
/*  56 */     this.rightwing2.addBox(-7.0F, 0.0F, -6.0F, 6, 1, 7);
/*  57 */     this.rightwing2.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  58 */     this.rightwing2.setTextureSize(64, 32);
/*  59 */     this.rightwing2.mirror = true;
/*  60 */     setRotation(this.rightwing2, 0.0F, 0.0F, 0.0F);
/*  61 */     this.leftwing3 = new ModelRenderer(this, 0, 9);
/*  62 */     this.leftwing3.addBox(0.0F, 0.0F, 1.0F, 5, 1, 5);
/*  63 */     this.leftwing3.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  64 */     this.leftwing3.setTextureSize(64, 32);
/*  65 */     this.leftwing3.mirror = true;
/*  66 */     setRotation(this.leftwing3, 0.0F, 0.0F, 0.0F);
/*  67 */     this.rightwing3 = new ModelRenderer(this, 27, 9);
/*  68 */     this.rightwing3.addBox(-5.0F, 0.0F, 1.0F, 5, 1, 5);
/*  69 */     this.rightwing3.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  70 */     this.rightwing3.setTextureSize(64, 32);
/*  71 */     this.rightwing3.mirror = true;
/*  72 */     setRotation(this.rightwing3, 0.0F, 0.0F, 0.0F);
/*  73 */     this.head = new ModelRenderer(this, 21, 11);
/*  74 */     this.head.addBox(0.0F, 0.0F, -6.0F, 1, 1, 1);
/*  75 */     this.head.setRotationPoint(0.0F, 17.0F, 1.0F);
/*  76 */     this.head.setTextureSize(64, 32);
/*  77 */     this.head.mirror = true;
/*  78 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  79 */     this.leftwing4 = new ModelRenderer(this, 2, 24);
/*  80 */     this.leftwing4.addBox(0.0F, 0.0F, 6.0F, 1, 1, 7);
/*  81 */     this.leftwing4.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  82 */     this.leftwing4.setTextureSize(64, 32);
/*  83 */     this.leftwing4.mirror = true;
/*  84 */     setRotation(this.leftwing4, 0.0F, 0.0F, 0.0F);
/*  85 */     this.rightwing4 = new ModelRenderer(this, 2, 16);
/*  86 */     this.rightwing4.addBox(-1.0F, 0.0F, 6.0F, 1, 1, 7);
/*  87 */     this.rightwing4.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  88 */     this.rightwing4.setTextureSize(64, 32);
/*  89 */     this.rightwing4.mirror = true;
/*  90 */     setRotation(this.rightwing4, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  94 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  95 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  98 */     if (this.scale > 1.0F) GL11.glTranslatef(0.0F, -this.scale, 0.0F); 
/*  99 */     GL11.glScalef(this.scale, this.scale, this.scale);
/* 100 */     this.head.render(f5);
/* 101 */     this.body.render(f5);
/*     */ 
/*     */     
/* 104 */     this.rightwing.rotateAngleZ = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/* 105 */     this.rightwing2.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 106 */     this.rightwing3.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 107 */     this.rightwing4.rotateAngleZ = this.rightwing.rotateAngleZ;
/*     */     
/* 109 */     this.leftwing.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 110 */     this.leftwing2.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 111 */     this.leftwing3.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 112 */     this.leftwing4.rotateAngleZ = -this.rightwing.rotateAngleZ;
/*     */ 
/*     */     
/* 115 */     this.leftwing.render(f5);
/* 116 */     this.rightwing.render(f5);
/* 117 */     this.leftwing2.render(f5);
/* 118 */     this.rightwing2.render(f5);
/* 119 */     this.leftwing3.render(f5);
/* 120 */     this.rightwing3.render(f5);
/* 121 */     this.leftwing4.render(f5);
/* 122 */     this.rightwing4.render(f5);
/* 123 */     GL11.glScalef(1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 127 */     model.rotateAngleX = x;
/* 128 */     model.rotateAngleY = y;
/* 129 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 133 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelButterfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */