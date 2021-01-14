/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Alosaurus;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelAlosaurus
/*     */   extends ModelBase
/*     */ {
/*  12 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Shape18;
/*     */   
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
/*  38 */     this.textureWidth = 128;
/*  39 */     this.textureHeight = 128;
/*  40 */     this.wingspeed = f1;
/*     */     
/*  42 */     this.Shape18 = new ModelRenderer(this, 91, 114);
/*  43 */     this.Shape18.addBox(0.0F, 0.0F, 0.0F, 2, 4, 5);
/*  44 */     this.Shape18.setRotationPoint(3.3F, -25.0F, -27.0F);
/*  45 */     this.Shape18.setTextureSize(128, 128);
/*  46 */     this.Shape18.mirror = true;
/*  47 */     setRotation(this.Shape18, 0.5759587F, 0.0F, 0.5585054F);
/*  48 */     this.Shape19 = new ModelRenderer(this, 71, 114);
/*  49 */     this.Shape19.addBox(0.0F, 0.0F, 0.0F, 2, 4, 5);
/*  50 */     this.Shape19.setRotationPoint(-4.0F, -24.0F, -28.0F);
/*  51 */     this.Shape19.setTextureSize(128, 128);
/*  52 */     this.Shape19.mirror = true;
/*  53 */     setRotation(this.Shape19, 0.5759587F, 0.0F, -0.5585054F);
/*  54 */     this.Shape20 = new ModelRenderer(this, 91, 30);
/*  55 */     this.Shape20.addBox(0.0F, 0.0F, 0.0F, 2, 7, 5);
/*  56 */     this.Shape20.setRotationPoint(5.0F, -8.0F, -6.0F);
/*  57 */     this.Shape20.setTextureSize(128, 128);
/*  58 */     this.Shape20.mirror = true;
/*  59 */     setRotation(this.Shape20, 0.3839724F, 0.0F, 0.0F);
/*  60 */     this.Shape21 = new ModelRenderer(this, 93, 46);
/*  61 */     this.Shape21.addBox(-2.0F, 0.0F, 0.0F, 2, 7, 5);
/*  62 */     this.Shape21.setRotationPoint(-4.0F, -8.0F, -6.0F);
/*  63 */     this.Shape21.setTextureSize(128, 128);
/*  64 */     this.Shape21.mirror = true;
/*  65 */     setRotation(this.Shape21, 0.3839724F, 0.0F, 0.0F);
/*  66 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  67 */     this.Shape1.addBox(-7.0F, 0.0F, 0.0F, 10, 18, 31);
/*  68 */     this.Shape1.setRotationPoint(2.5F, -19.0F, -8.0F);
/*  69 */     this.Shape1.setTextureSize(128, 128);
/*  70 */     this.Shape1.mirror = true;
/*  71 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  72 */     this.Shape2 = new ModelRenderer(this, 62, 0);
/*  73 */     this.Shape2.addBox(-5.0F, 0.0F, 0.0F, 10, 11, 11);
/*  74 */     this.Shape2.setRotationPoint(0.5F, -19.0F, 23.0F);
/*  75 */     this.Shape2.setTextureSize(128, 128);
/*  76 */     this.Shape2.mirror = true;
/*  77 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*  78 */     this.Shape3 = new ModelRenderer(this, 10, 54);
/*  79 */     this.Shape3.addBox(-3.0F, 0.0F, 0.0F, 7, 7, 25);
/*  80 */     this.Shape3.setRotationPoint(0.0F, -19.0F, 34.0F);
/*  81 */     this.Shape3.setTextureSize(128, 128);
/*  82 */     this.Shape3.mirror = true;
/*  83 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*  84 */     this.Shape4 = new ModelRenderer(this, 68, 88);
/*  85 */     this.Shape4.addBox(-5.0F, 0.0F, 0.0F, 8, 9, 16);
/*  86 */     this.Shape4.setRotationPoint(1.5F, -25.0F, -16.0F);
/*  87 */     this.Shape4.setTextureSize(128, 128);
/*  88 */     this.Shape4.mirror = true;
/*  89 */     setRotation(this.Shape4, -0.4014257F, 0.0F, 0.0F);
/*  90 */     this.Shape5 = new ModelRenderer(this, 75, 65);
/*  91 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 9, 9, 12);
/*  92 */     this.Shape5.setRotationPoint(-4.0F, -25.0F, -27.0F);
/*  93 */     this.Shape5.setTextureSize(128, 128);
/*  94 */     this.Shape5.mirror = true;
/*  95 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/*  96 */     this.Shape6 = new ModelRenderer(this, 0, 50);
/*  97 */     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 7, 9, 9);
/*  98 */     this.Shape6.setRotationPoint(-3.0F, -25.0F, -36.0F);
/*  99 */     this.Shape6.setTextureSize(128, 128);
/* 100 */     this.Shape6.mirror = true;
/* 101 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/* 102 */     this.jaw = new ModelRenderer(this, 0, 86);
/* 103 */     this.jaw.addBox(-5.0F, 0.0F, -10.0F, 7, 1, 13);
/* 104 */     this.jaw.setRotationPoint(2.0F, -15.0F, -24.0F);
/* 105 */     this.jaw.setTextureSize(128, 128);
/* 106 */     this.jaw.mirror = true;
/* 107 */     setRotation(this.jaw, 0.5201081F, 0.0F, 0.0F);
/* 108 */     this.leftleg = new ModelRenderer(this, 0, 0);
/* 109 */     this.leftleg.addBox(-1.0F, 0.0F, 0.0F, 3, 16, 10);
/* 110 */     this.leftleg.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 111 */     this.leftleg.setTextureSize(128, 128);
/* 112 */     this.leftleg.mirror = true;
/* 113 */     setRotation(this.leftleg, -0.1745329F, 0.0F, 0.0F);
/* 114 */     this.leftleg2 = new ModelRenderer(this, 0, 106);
/* 115 */     this.leftleg2.addBox(-1.0F, 12.0F, -8.0F, 3, 15, 5);
/* 116 */     this.leftleg2.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 117 */     this.leftleg2.setTextureSize(128, 128);
/* 118 */     this.leftleg2.mirror = true;
/* 119 */     setRotation(this.leftleg2, 0.5061455F, 0.0F, 0.0F);
/* 120 */     this.leftleg3 = new ModelRenderer(this, 112, 89);
/* 121 */     this.leftleg3.addBox(-1.0F, 19.0F, 16.0F, 3, 9, 3);
/* 122 */     this.leftleg3.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 123 */     this.leftleg3.setTextureSize(128, 128);
/* 124 */     this.leftleg3.mirror = true;
/* 125 */     setRotation(this.leftleg3, -0.4014257F, 0.0F, 0.0F);
/* 126 */     this.Shape11 = new ModelRenderer(this, 0, 72);
/* 127 */     this.Shape11.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2);
/* 128 */     this.Shape11.setRotationPoint(5.0F, -5.0F, -3.0F);
/* 129 */     this.Shape11.setTextureSize(128, 128);
/* 130 */     this.Shape11.mirror = true;
/* 131 */     setRotation(this.Shape11, -0.5235988F, 0.0F, 0.0F);
/* 132 */     this.rightleg = new ModelRenderer(this, 54, 51);
/* 133 */     this.rightleg.addBox(0.0F, 0.0F, 0.0F, 3, 16, 10);
/* 134 */     this.rightleg.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 135 */     this.rightleg.setTextureSize(128, 128);
/* 136 */     this.rightleg.mirror = true;
/* 137 */     setRotation(this.rightleg, -0.1745329F, 0.0F, 0.0F);
/* 138 */     this.rightleg2 = new ModelRenderer(this, 23, 106);
/* 139 */     this.rightleg2.addBox(0.0F, 12.0F, -8.0F, 3, 15, 5);
/* 140 */     this.rightleg2.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 141 */     this.rightleg2.setTextureSize(128, 128);
/* 142 */     this.rightleg2.mirror = true;
/* 143 */     setRotation(this.rightleg2, 0.5061455F, 0.0F, 0.0F);
/* 144 */     this.rightleg3 = new ModelRenderer(this, 70, 90);
/* 145 */     this.rightleg3.addBox(0.0F, 19.0F, 16.0F, 3, 9, 3);
/* 146 */     this.rightleg3.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 147 */     this.rightleg3.setTextureSize(128, 128);
/* 148 */     this.rightleg3.mirror = true;
/* 149 */     setRotation(this.rightleg3, -0.4014257F, 0.0F, 0.0F);
/* 150 */     this.leftleg4 = new ModelRenderer(this, 42, 113);
/* 151 */     this.leftleg4.addBox(-1.0F, 31.0F, -1.0F, 3, 3, 8);
/* 152 */     this.leftleg4.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 153 */     this.leftleg4.setTextureSize(128, 128);
/* 154 */     this.leftleg4.mirror = true;
/* 155 */     setRotation(this.leftleg4, 0.0F, 0.0F, 0.0F);
/* 156 */     this.rightleg4 = new ModelRenderer(this, 44, 93);
/* 157 */     this.rightleg4.addBox(0.0F, 31.0F, -1.0F, 3, 3, 8);
/* 158 */     this.rightleg4.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 159 */     this.rightleg4.setTextureSize(128, 128);
/* 160 */     this.rightleg4.mirror = true;
/* 161 */     setRotation(this.rightleg4, 0.0F, 0.0F, 0.0F);
/* 162 */     this.Shape17 = new ModelRenderer(this, 112, 60);
/* 163 */     this.Shape17.addBox(-2.0F, 0.0F, 0.0F, 2, 10, 2);
/* 164 */     this.Shape17.setRotationPoint(-4.0F, -3.533333F, -3.0F);
/* 165 */     this.Shape17.setTextureSize(128, 128);
/* 166 */     this.Shape17.mirror = true;
/* 167 */     setRotation(this.Shape17, -0.5235988F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 173 */     Alosaurus e = (Alosaurus)entity;
/* 174 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 175 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 176 */     float newangle = 0.0F;
/*     */     
/* 178 */     if (f1 > 0.1D) {
/* 179 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 181 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 184 */     this.rightleg.rotateAngleX = -0.174F + newangle;
/* 185 */     this.rightleg2.rotateAngleX = 0.506F + newangle;
/* 186 */     this.rightleg3.rotateAngleX = -0.401F + newangle;
/* 187 */     this.rightleg4.rotateAngleX = newangle;
/*     */     
/* 189 */     this.leftleg.rotateAngleX = -0.174F - newangle;
/* 190 */     this.leftleg2.rotateAngleX = 0.506F - newangle;
/* 191 */     this.leftleg3.rotateAngleX = -0.401F - newangle;
/* 192 */     this.leftleg4.rotateAngleX = -newangle;
/*     */     
/* 194 */     if (e.getAttacking() != 0) {
/* 195 */       this.jaw.rotateAngleX = 0.52F + MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.18F;
/*     */     } else {
/* 197 */       this.jaw.rotateAngleX = 0.1F;
/*     */     } 
/*     */     
/* 200 */     this.Shape17.rotateAngleX = -0.523F + MathHelper.cos(f2 * 0.1F) * 3.1415927F * 0.05F;
/* 201 */     this.Shape11.rotateAngleX = -0.523F + MathHelper.cos(f2 * 0.1F) * 3.1415927F * 0.05F;
/*     */     
/* 203 */     this.Shape18.render(f5);
/* 204 */     this.Shape19.render(f5);
/* 205 */     this.Shape20.render(f5);
/* 206 */     this.Shape21.render(f5);
/* 207 */     this.Shape1.render(f5);
/* 208 */     this.Shape2.render(f5);
/* 209 */     this.Shape3.render(f5);
/* 210 */     this.Shape4.render(f5);
/* 211 */     this.Shape5.render(f5);
/* 212 */     this.Shape6.render(f5);
/* 213 */     this.jaw.render(f5);
/* 214 */     this.leftleg.render(f5);
/* 215 */     this.leftleg2.render(f5);
/* 216 */     this.leftleg3.render(f5);
/* 217 */     this.Shape11.render(f5);
/* 218 */     this.rightleg.render(f5);
/* 219 */     this.rightleg2.render(f5);
/* 220 */     this.rightleg3.render(f5);
/* 221 */     this.leftleg4.render(f5);
/* 222 */     this.rightleg4.render(f5);
/* 223 */     this.Shape17.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 229 */     model.rotateAngleX = x;
/* 230 */     model.rotateAngleY = y;
/* 231 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 236 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\entity\model\ModelAlosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */