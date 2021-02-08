/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Alosaurus;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelAlosaurus
/*     */   extends ModelBase {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Shape18;
/*     */   ModelRenderer Shape19;
/*     */   ModelRenderer Shape20;
/*     */   ModelRenderer Shape21;
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer jaw;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer leftleg2;
/*     */   ModelRenderer leftleg3;
/*     */   ModelRenderer Shape11;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer rightleg2;
/*     */   ModelRenderer rightleg3;
/*     */   ModelRenderer leftleg4;
/*     */   ModelRenderer rightleg4;
/*     */   ModelRenderer Shape17;
/*     */   
/*     */   public ModelAlosaurus(float f1) {
/*  36 */     this.textureWidth = 128;
/*  37 */     this.textureHeight = 128;
/*  38 */     this.wingspeed = f1;
/*     */     
/*  40 */     this.Shape18 = new ModelRenderer(this, 91, 114);
/*  41 */     this.Shape18.addBox(0.0F, 0.0F, 0.0F, 2, 4, 5);
/*  42 */     this.Shape18.setRotationPoint(3.3F, -25.0F, -27.0F);
/*  43 */     this.Shape18.setTextureSize(128, 128);
/*  44 */     this.Shape18.mirror = true;
/*  45 */     setRotation(this.Shape18, 0.5759587F, 0.0F, 0.5585054F);
/*  46 */     this.Shape19 = new ModelRenderer(this, 71, 114);
/*  47 */     this.Shape19.addBox(0.0F, 0.0F, 0.0F, 2, 4, 5);
/*  48 */     this.Shape19.setRotationPoint(-4.0F, -24.0F, -28.0F);
/*  49 */     this.Shape19.setTextureSize(128, 128);
/*  50 */     this.Shape19.mirror = true;
/*  51 */     setRotation(this.Shape19, 0.5759587F, 0.0F, -0.5585054F);
/*  52 */     this.Shape20 = new ModelRenderer(this, 91, 30);
/*  53 */     this.Shape20.addBox(0.0F, 0.0F, 0.0F, 2, 7, 5);
/*  54 */     this.Shape20.setRotationPoint(5.0F, -8.0F, -6.0F);
/*  55 */     this.Shape20.setTextureSize(128, 128);
/*  56 */     this.Shape20.mirror = true;
/*  57 */     setRotation(this.Shape20, 0.3839724F, 0.0F, 0.0F);
/*  58 */     this.Shape21 = new ModelRenderer(this, 93, 46);
/*  59 */     this.Shape21.addBox(-2.0F, 0.0F, 0.0F, 2, 7, 5);
/*  60 */     this.Shape21.setRotationPoint(-4.0F, -8.0F, -6.0F);
/*  61 */     this.Shape21.setTextureSize(128, 128);
/*  62 */     this.Shape21.mirror = true;
/*  63 */     setRotation(this.Shape21, 0.3839724F, 0.0F, 0.0F);
/*  64 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  65 */     this.Shape1.addBox(-7.0F, 0.0F, 0.0F, 10, 18, 31);
/*  66 */     this.Shape1.setRotationPoint(2.5F, -19.0F, -8.0F);
/*  67 */     this.Shape1.setTextureSize(128, 128);
/*  68 */     this.Shape1.mirror = true;
/*  69 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  70 */     this.Shape2 = new ModelRenderer(this, 62, 0);
/*  71 */     this.Shape2.addBox(-5.0F, 0.0F, 0.0F, 10, 11, 11);
/*  72 */     this.Shape2.setRotationPoint(0.5F, -19.0F, 23.0F);
/*  73 */     this.Shape2.setTextureSize(128, 128);
/*  74 */     this.Shape2.mirror = true;
/*  75 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*  76 */     this.Shape3 = new ModelRenderer(this, 10, 54);
/*  77 */     this.Shape3.addBox(-3.0F, 0.0F, 0.0F, 7, 7, 25);
/*  78 */     this.Shape3.setRotationPoint(0.0F, -19.0F, 34.0F);
/*  79 */     this.Shape3.setTextureSize(128, 128);
/*  80 */     this.Shape3.mirror = true;
/*  81 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*  82 */     this.Shape4 = new ModelRenderer(this, 68, 88);
/*  83 */     this.Shape4.addBox(-5.0F, 0.0F, 0.0F, 8, 9, 16);
/*  84 */     this.Shape4.setRotationPoint(1.5F, -25.0F, -16.0F);
/*  85 */     this.Shape4.setTextureSize(128, 128);
/*  86 */     this.Shape4.mirror = true;
/*  87 */     setRotation(this.Shape4, -0.4014257F, 0.0F, 0.0F);
/*  88 */     this.Shape5 = new ModelRenderer(this, 75, 65);
/*  89 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 9, 9, 12);
/*  90 */     this.Shape5.setRotationPoint(-4.0F, -25.0F, -27.0F);
/*  91 */     this.Shape5.setTextureSize(128, 128);
/*  92 */     this.Shape5.mirror = true;
/*  93 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/*  94 */     this.Shape6 = new ModelRenderer(this, 0, 50);
/*  95 */     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 7, 9, 9);
/*  96 */     this.Shape6.setRotationPoint(-3.0F, -25.0F, -36.0F);
/*  97 */     this.Shape6.setTextureSize(128, 128);
/*  98 */     this.Shape6.mirror = true;
/*  99 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/* 100 */     this.jaw = new ModelRenderer(this, 0, 86);
/* 101 */     this.jaw.addBox(-5.0F, 0.0F, -10.0F, 7, 1, 13);
/* 102 */     this.jaw.setRotationPoint(2.0F, -15.0F, -24.0F);
/* 103 */     this.jaw.setTextureSize(128, 128);
/* 104 */     this.jaw.mirror = true;
/* 105 */     setRotation(this.jaw, 0.5201081F, 0.0F, 0.0F);
/* 106 */     this.leftleg = new ModelRenderer(this, 0, 0);
/* 107 */     this.leftleg.addBox(-1.0F, 0.0F, 0.0F, 3, 16, 10);
/* 108 */     this.leftleg.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 109 */     this.leftleg.setTextureSize(128, 128);
/* 110 */     this.leftleg.mirror = true;
/* 111 */     setRotation(this.leftleg, -0.1745329F, 0.0F, 0.0F);
/* 112 */     this.leftleg2 = new ModelRenderer(this, 0, 106);
/* 113 */     this.leftleg2.addBox(-1.0F, 12.0F, -8.0F, 3, 15, 5);
/* 114 */     this.leftleg2.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 115 */     this.leftleg2.setTextureSize(128, 128);
/* 116 */     this.leftleg2.mirror = true;
/* 117 */     setRotation(this.leftleg2, 0.5061455F, 0.0F, 0.0F);
/* 118 */     this.leftleg3 = new ModelRenderer(this, 112, 89);
/* 119 */     this.leftleg3.addBox(-1.0F, 19.0F, 16.0F, 3, 9, 3);
/* 120 */     this.leftleg3.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 121 */     this.leftleg3.setTextureSize(128, 128);
/* 122 */     this.leftleg3.mirror = true;
/* 123 */     setRotation(this.leftleg3, -0.4014257F, 0.0F, 0.0F);
/* 124 */     this.Shape11 = new ModelRenderer(this, 0, 72);
/* 125 */     this.Shape11.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2);
/* 126 */     this.Shape11.setRotationPoint(5.0F, -5.0F, -3.0F);
/* 127 */     this.Shape11.setTextureSize(128, 128);
/* 128 */     this.Shape11.mirror = true;
/* 129 */     setRotation(this.Shape11, -0.5235988F, 0.0F, 0.0F);
/* 130 */     this.rightleg = new ModelRenderer(this, 54, 51);
/* 131 */     this.rightleg.addBox(0.0F, 0.0F, 0.0F, 3, 16, 10);
/* 132 */     this.rightleg.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 133 */     this.rightleg.setTextureSize(128, 128);
/* 134 */     this.rightleg.mirror = true;
/* 135 */     setRotation(this.rightleg, -0.1745329F, 0.0F, 0.0F);
/* 136 */     this.rightleg2 = new ModelRenderer(this, 23, 106);
/* 137 */     this.rightleg2.addBox(0.0F, 12.0F, -8.0F, 3, 15, 5);
/* 138 */     this.rightleg2.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 139 */     this.rightleg2.setTextureSize(128, 128);
/* 140 */     this.rightleg2.mirror = true;
/* 141 */     setRotation(this.rightleg2, 0.5061455F, 0.0F, 0.0F);
/* 142 */     this.rightleg3 = new ModelRenderer(this, 70, 90);
/* 143 */     this.rightleg3.addBox(0.0F, 19.0F, 16.0F, 3, 9, 3);
/* 144 */     this.rightleg3.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 145 */     this.rightleg3.setTextureSize(128, 128);
/* 146 */     this.rightleg3.mirror = true;
/* 147 */     setRotation(this.rightleg3, -0.4014257F, 0.0F, 0.0F);
/* 148 */     this.leftleg4 = new ModelRenderer(this, 42, 113);
/* 149 */     this.leftleg4.addBox(-1.0F, 31.0F, -1.0F, 3, 3, 8);
/* 150 */     this.leftleg4.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 151 */     this.leftleg4.setTextureSize(128, 128);
/* 152 */     this.leftleg4.mirror = true;
/* 153 */     setRotation(this.leftleg4, 0.0F, 0.0F, 0.0F);
/* 154 */     this.rightleg4 = new ModelRenderer(this, 44, 93);
/* 155 */     this.rightleg4.addBox(0.0F, 31.0F, -1.0F, 3, 3, 8);
/* 156 */     this.rightleg4.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 157 */     this.rightleg4.setTextureSize(128, 128);
/* 158 */     this.rightleg4.mirror = true;
/* 159 */     setRotation(this.rightleg4, 0.0F, 0.0F, 0.0F);
/* 160 */     this.Shape17 = new ModelRenderer(this, 112, 60);
/* 161 */     this.Shape17.addBox(-2.0F, 0.0F, 0.0F, 2, 10, 2);
/* 162 */     this.Shape17.setRotationPoint(-4.0F, -3.533333F, -3.0F);
/* 163 */     this.Shape17.setTextureSize(128, 128);
/* 164 */     this.Shape17.mirror = true;
/* 165 */     setRotation(this.Shape17, -0.5235988F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 170 */     Alosaurus e = (Alosaurus)entity;
/* 171 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 172 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 173 */     float newangle = 0.0F;
/*     */     
/* 175 */     if (f1 > 0.1D) {
/* 176 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 178 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 181 */     this.rightleg.rotateAngleX = -0.174F + newangle;
/* 182 */     this.rightleg2.rotateAngleX = 0.506F + newangle;
/* 183 */     this.rightleg3.rotateAngleX = -0.401F + newangle;
/* 184 */     this.rightleg4.rotateAngleX = newangle;
/*     */     
/* 186 */     this.leftleg.rotateAngleX = -0.174F - newangle;
/* 187 */     this.leftleg2.rotateAngleX = 0.506F - newangle;
/* 188 */     this.leftleg3.rotateAngleX = -0.401F - newangle;
/* 189 */     this.leftleg4.rotateAngleX = -newangle;
/*     */     
/* 191 */     if (e.getAttacking() != 0) {
/* 192 */       this.jaw.rotateAngleX = 0.52F + MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.18F;
/*     */     } else {
/* 194 */       this.jaw.rotateAngleX = 0.1F;
/*     */     } 
/*     */     
/* 197 */     this.Shape17.rotateAngleX = -0.523F + MathHelper.cos(f2 * 0.1F) * 3.1415927F * 0.05F;
/* 198 */     this.Shape11.rotateAngleX = -0.523F + MathHelper.cos(f2 * 0.1F) * 3.1415927F * 0.05F;
/*     */     
/* 200 */     this.Shape18.render(f5);
/* 201 */     this.Shape19.render(f5);
/* 202 */     this.Shape20.render(f5);
/* 203 */     this.Shape21.render(f5);
/* 204 */     this.Shape1.render(f5);
/* 205 */     this.Shape2.render(f5);
/* 206 */     this.Shape3.render(f5);
/* 207 */     this.Shape4.render(f5);
/* 208 */     this.Shape5.render(f5);
/* 209 */     this.Shape6.render(f5);
/* 210 */     this.jaw.render(f5);
/* 211 */     this.leftleg.render(f5);
/* 212 */     this.leftleg2.render(f5);
/* 213 */     this.leftleg3.render(f5);
/* 214 */     this.Shape11.render(f5);
/* 215 */     this.rightleg.render(f5);
/* 216 */     this.rightleg2.render(f5);
/* 217 */     this.rightleg3.render(f5);
/* 218 */     this.leftleg4.render(f5);
/* 219 */     this.rightleg4.render(f5);
/* 220 */     this.Shape17.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 225 */     model.rotateAngleX = x;
/* 226 */     model.rotateAngleY = y;
/* 227 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 231 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\model\ModelAlosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */