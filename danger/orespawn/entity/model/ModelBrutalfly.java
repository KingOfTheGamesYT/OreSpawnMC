/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelBrutalfly
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
/*     */   ModelRenderer leftwing5;
/*     */   ModelRenderer leftwing6;
/*     */   ModelRenderer rightwing5;
/*     */   ModelRenderer rightwing6;
/*  26 */   private float wingspeed = 1.0F;
/*     */ 
/*     */   
/*     */   public ModelBrutalfly(float f1) {
/*  30 */     this.textureWidth = 64;
/*  31 */     this.textureHeight = 32;
/*  32 */     this.wingspeed = f1;
/*     */     
/*  34 */     this.body = new ModelRenderer(this, 21, 19);
/*  35 */     this.body.addBox(0.0F, 0.0F, -4.0F, 1, 1, 8);
/*  36 */     this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  37 */     this.body.setTextureSize(64, 32);
/*  38 */     this.body.mirror = true;
/*  39 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  40 */     this.leftwing = new ModelRenderer(this, 43, 24);
/*  41 */     this.leftwing.addBox(0.0F, 0.0F, -4.0F, 1, 1, 5);
/*  42 */     this.leftwing.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  43 */     this.leftwing.setTextureSize(64, 32);
/*  44 */     this.leftwing.mirror = true;
/*  45 */     setRotation(this.leftwing, 0.0F, 0.0F, 0.0F);
/*  46 */     this.rightwing = new ModelRenderer(this, 43, 17);
/*  47 */     this.rightwing.addBox(-1.0F, 0.0F, -4.0F, 1, 1, 5);
/*  48 */     this.rightwing.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  49 */     this.rightwing.setTextureSize(64, 32);
/*  50 */     this.rightwing.mirror = true;
/*  51 */     setRotation(this.rightwing, 0.0F, 0.0F, 0.0F);
/*  52 */     this.leftwing2 = new ModelRenderer(this, 0, 0);
/*  53 */     this.leftwing2.addBox(1.0F, 0.0F, -6.0F, 6, 1, 7);
/*  54 */     this.leftwing2.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  55 */     this.leftwing2.setTextureSize(64, 32);
/*  56 */     this.leftwing2.mirror = true;
/*  57 */     setRotation(this.leftwing2, 0.0F, 0.0F, 0.0F);
/*  58 */     this.rightwing2 = new ModelRenderer(this, 29, 0);
/*  59 */     this.rightwing2.addBox(-7.0F, 0.0F, -6.0F, 6, 1, 7);
/*  60 */     this.rightwing2.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  61 */     this.rightwing2.setTextureSize(64, 32);
/*  62 */     this.rightwing2.mirror = true;
/*  63 */     setRotation(this.rightwing2, 0.0F, 0.0F, 0.0F);
/*  64 */     this.leftwing3 = new ModelRenderer(this, 0, 9);
/*  65 */     this.leftwing3.addBox(0.0F, 0.0F, 1.0F, 5, 1, 5);
/*  66 */     this.leftwing3.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  67 */     this.leftwing3.setTextureSize(64, 32);
/*  68 */     this.leftwing3.mirror = true;
/*  69 */     setRotation(this.leftwing3, 0.0F, 0.0F, 0.0F);
/*  70 */     this.rightwing3 = new ModelRenderer(this, 27, 9);
/*  71 */     this.rightwing3.addBox(-5.0F, 0.0F, 1.0F, 5, 1, 5);
/*  72 */     this.rightwing3.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  73 */     this.rightwing3.setTextureSize(64, 32);
/*  74 */     this.rightwing3.mirror = true;
/*  75 */     setRotation(this.rightwing3, 0.0F, 0.0F, 0.0F);
/*  76 */     this.head = new ModelRenderer(this, 21, 11);
/*  77 */     this.head.addBox(0.0F, 0.0F, -6.0F, 1, 1, 1);
/*  78 */     this.head.setRotationPoint(0.0F, 17.0F, 1.0F);
/*  79 */     this.head.setTextureSize(64, 32);
/*  80 */     this.head.mirror = true;
/*  81 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  82 */     this.leftwing4 = new ModelRenderer(this, 2, 24);
/*  83 */     this.leftwing4.addBox(0.0F, 0.0F, 6.0F, 2, 1, 7);
/*  84 */     this.leftwing4.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  85 */     this.leftwing4.setTextureSize(64, 32);
/*  86 */     this.leftwing4.mirror = true;
/*  87 */     setRotation(this.leftwing4, 0.0F, 0.0F, 0.0F);
/*  88 */     this.rightwing4 = new ModelRenderer(this, 2, 16);
/*  89 */     this.rightwing4.addBox(-2.0F, 0.0F, 6.0F, 2, 1, 7);
/*  90 */     this.rightwing4.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  91 */     this.rightwing4.setTextureSize(64, 32);
/*  92 */     this.rightwing4.mirror = true;
/*  93 */     setRotation(this.rightwing4, 0.0F, 0.0F, 0.0F);
/*  94 */     this.leftwing5 = new ModelRenderer(this, 21, 16);
/*  95 */     this.leftwing5.addBox(1.0F, 0.0F, -7.0F, 1, 1, 1);
/*  96 */     this.leftwing5.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  97 */     this.leftwing5.setTextureSize(64, 32);
/*  98 */     this.leftwing5.mirror = true;
/*  99 */     setRotation(this.leftwing5, 0.0F, 0.0F, 0.0F);
/* 100 */     this.leftwing6 = new ModelRenderer(this, 50, 10);
/* 101 */     this.leftwing6.addBox(7.0F, 0.0F, -6.0F, 2, 1, 1);
/* 102 */     this.leftwing6.setRotationPoint(1.0F, 17.0F, 0.0F);
/* 103 */     this.leftwing6.setTextureSize(64, 32);
/* 104 */     this.leftwing6.mirror = true;
/* 105 */     setRotation(this.leftwing6, 0.0F, 0.0F, 0.0F);
/* 106 */     this.rightwing5 = new ModelRenderer(this, 27, 16);
/* 107 */     this.rightwing5.addBox(-2.0F, 0.0F, -7.0F, 1, 1, 1);
/* 108 */     this.rightwing5.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 109 */     this.rightwing5.setTextureSize(64, 32);
/* 110 */     this.rightwing5.mirror = true;
/* 111 */     setRotation(this.rightwing5, 0.0F, 0.0F, 0.0F);
/* 112 */     this.rightwing6 = new ModelRenderer(this, 50, 13);
/* 113 */     this.rightwing6.addBox(-9.0F, 0.0F, -6.0F, 2, 1, 1);
/* 114 */     this.rightwing6.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 115 */     this.rightwing6.setTextureSize(64, 32);
/* 116 */     this.rightwing6.mirror = true;
/* 117 */     setRotation(this.rightwing6, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 122 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 123 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 125 */     GL11.glTranslatef(0.0F, -12.0F, 0.0F);
/* 126 */     GL11.glScalef(12.0F, 12.0F, 12.0F);
/* 127 */     this.head.render(f5);
/* 128 */     this.body.render(f5);
/*     */     
/* 130 */     this.rightwing.rotateAngleZ = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/* 131 */     this.rightwing2.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 132 */     this.rightwing3.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 133 */     this.rightwing4.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 134 */     this.rightwing5.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 135 */     this.rightwing6.rotateAngleZ = this.rightwing.rotateAngleZ;
/*     */     
/* 137 */     this.leftwing.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 138 */     this.leftwing2.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 139 */     this.leftwing3.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 140 */     this.leftwing4.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 141 */     this.leftwing5.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 142 */     this.leftwing6.rotateAngleZ = -this.rightwing.rotateAngleZ;
/*     */     
/* 144 */     this.leftwing.render(f5);
/* 145 */     this.rightwing.render(f5);
/* 146 */     this.leftwing2.render(f5);
/* 147 */     this.rightwing2.render(f5);
/* 148 */     this.leftwing3.render(f5);
/* 149 */     this.rightwing3.render(f5);
/* 150 */     this.leftwing4.render(f5);
/* 151 */     this.rightwing4.render(f5);
/* 152 */     this.leftwing5.render(f5);
/* 153 */     this.rightwing5.render(f5);
/* 154 */     this.leftwing6.render(f5);
/* 155 */     this.rightwing6.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 161 */     model.rotateAngleX = x;
/* 162 */     model.rotateAngleY = y;
/* 163 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 168 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelBrutalfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */