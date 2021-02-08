/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.TRex;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelTRex extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
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
/*     */   ModelRenderer TailExtension;
/*     */   ModelRenderer Spine1;
/*     */   ModelRenderer Spine2;
/*     */   ModelRenderer Spine3;
/*     */   ModelRenderer Spine4;
/*     */   ModelRenderer Spine5;
/*     */   
/*     */   public ModelTRex(float f1) {
/*  41 */     this.textureWidth = 128;
/*  42 */     this.textureHeight = 128;
/*  43 */     this.wingspeed = f1;
/*     */     
/*  45 */     this.Shape18 = new ModelRenderer(this, 91, 114);
/*  46 */     this.Shape18.addBox(0.0F, 0.0F, 0.0F, 2, 4, 5);
/*  47 */     this.Shape18.setRotationPoint(3.3F, -25.0F, -23.0F);
/*  48 */     this.Shape18.setTextureSize(128, 128);
/*  49 */     this.Shape18.mirror = true;
/*  50 */     setRotation(this.Shape18, 0.5759587F, 0.0F, 0.5585054F);
/*  51 */     this.Shape19 = new ModelRenderer(this, 71, 114);
/*  52 */     this.Shape19.addBox(0.0F, 0.0F, 0.0F, 2, 4, 5);
/*  53 */     this.Shape19.setRotationPoint(-4.0F, -24.0F, -23.0F);
/*  54 */     this.Shape19.setTextureSize(128, 128);
/*  55 */     this.Shape19.mirror = true;
/*  56 */     setRotation(this.Shape19, 0.5759587F, 0.0F, -0.5585054F);
/*  57 */     this.Shape20 = new ModelRenderer(this, 91, 30);
/*  58 */     this.Shape20.addBox(0.0F, 0.0F, 0.0F, 2, 7, 5);
/*  59 */     this.Shape20.setRotationPoint(5.0F, -8.0F, -6.0F);
/*  60 */     this.Shape20.setTextureSize(128, 128);
/*  61 */     this.Shape20.mirror = true;
/*  62 */     setRotation(this.Shape20, 0.3839724F, 0.0F, 0.0F);
/*  63 */     this.Shape21 = new ModelRenderer(this, 93, 46);
/*  64 */     this.Shape21.addBox(-2.0F, 0.0F, 0.0F, 2, 7, 5);
/*  65 */     this.Shape21.setRotationPoint(-4.0F, -8.0F, -6.0F);
/*  66 */     this.Shape21.setTextureSize(128, 128);
/*  67 */     this.Shape21.mirror = true;
/*  68 */     setRotation(this.Shape21, 0.3839724F, 0.0F, 0.0F);
/*  69 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  70 */     this.Shape1.addBox(-7.0F, 0.0F, 0.0F, 10, 18, 31);
/*  71 */     this.Shape1.setRotationPoint(2.5F, -19.0F, -8.0F);
/*  72 */     this.Shape1.setTextureSize(128, 128);
/*  73 */     this.Shape1.mirror = true;
/*  74 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  75 */     this.Shape2 = new ModelRenderer(this, 62, 0);
/*  76 */     this.Shape2.addBox(-5.0F, 0.0F, 0.0F, 10, 11, 11);
/*  77 */     this.Shape2.setRotationPoint(0.5F, -19.0F, 23.0F);
/*  78 */     this.Shape2.setTextureSize(128, 128);
/*  79 */     this.Shape2.mirror = true;
/*  80 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*  81 */     this.Shape3 = new ModelRenderer(this, 10, 54);
/*  82 */     this.Shape3.addBox(-3.0F, 0.0F, 0.0F, 7, 7, 25);
/*  83 */     this.Shape3.setRotationPoint(0.0F, -19.0F, 34.0F);
/*  84 */     this.Shape3.setTextureSize(128, 128);
/*  85 */     this.Shape3.mirror = true;
/*  86 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*  87 */     this.Shape4 = new ModelRenderer(this, 68, 88);
/*  88 */     this.Shape4.addBox(-5.0F, 0.0F, 0.0F, 8, 9, 16);
/*  89 */     this.Shape4.setRotationPoint(1.5F, -25.0F, -16.0F);
/*  90 */     this.Shape4.setTextureSize(128, 128);
/*  91 */     this.Shape4.mirror = true;
/*  92 */     setRotation(this.Shape4, -0.4014257F, 0.0F, 0.0F);
/*  93 */     this.Shape5 = new ModelRenderer(this, 75, 65);
/*  94 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 9, 9, 12);
/*  95 */     this.Shape5.setRotationPoint(-4.0F, -25.0F, -27.0F);
/*  96 */     this.Shape5.setTextureSize(128, 128);
/*  97 */     this.Shape5.mirror = true;
/*  98 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/*  99 */     this.Shape6 = new ModelRenderer(this, 0, 50);
/* 100 */     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 7, 9, 9);
/* 101 */     this.Shape6.setRotationPoint(-3.0F, -25.0F, -36.0F);
/* 102 */     this.Shape6.setTextureSize(128, 128);
/* 103 */     this.Shape6.mirror = true;
/* 104 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/* 105 */     this.jaw = new ModelRenderer(this, 0, 86);
/* 106 */     this.jaw.addBox(-5.0F, 0.0F, -10.0F, 7, 1, 13);
/* 107 */     this.jaw.setRotationPoint(2.0F, -15.0F, -24.0F);
/* 108 */     this.jaw.setTextureSize(128, 128);
/* 109 */     this.jaw.mirror = true;
/* 110 */     setRotation(this.jaw, 0.5201081F, 0.0F, 0.0F);
/* 111 */     this.leftleg = new ModelRenderer(this, 0, 0);
/* 112 */     this.leftleg.addBox(-1.0F, 0.0F, 0.0F, 3, 16, 10);
/* 113 */     this.leftleg.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 114 */     this.leftleg.setTextureSize(128, 128);
/* 115 */     this.leftleg.mirror = true;
/* 116 */     setRotation(this.leftleg, -0.1745329F, 0.0F, 0.0F);
/* 117 */     this.leftleg2 = new ModelRenderer(this, 0, 106);
/* 118 */     this.leftleg2.addBox(-1.0F, 12.0F, -8.0F, 3, 15, 5);
/* 119 */     this.leftleg2.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 120 */     this.leftleg2.setTextureSize(128, 128);
/* 121 */     this.leftleg2.mirror = true;
/* 122 */     setRotation(this.leftleg2, 0.5061455F, 0.0F, 0.0F);
/* 123 */     this.leftleg3 = new ModelRenderer(this, 112, 89);
/* 124 */     this.leftleg3.addBox(-1.0F, 19.0F, 16.0F, 3, 9, 3);
/* 125 */     this.leftleg3.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 126 */     this.leftleg3.setTextureSize(128, 128);
/* 127 */     this.leftleg3.mirror = true;
/* 128 */     setRotation(this.leftleg3, -0.4014257F, 0.0F, 0.0F);
/* 129 */     this.Shape11 = new ModelRenderer(this, 0, 72);
/* 130 */     this.Shape11.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2);
/* 131 */     this.Shape11.setRotationPoint(5.0F, -5.0F, -3.0F);
/* 132 */     this.Shape11.setTextureSize(128, 128);
/* 133 */     this.Shape11.mirror = true;
/* 134 */     setRotation(this.Shape11, -0.5235988F, 0.0F, 0.0F);
/* 135 */     this.rightleg = new ModelRenderer(this, 54, 51);
/* 136 */     this.rightleg.addBox(0.0F, 0.0F, 0.0F, 3, 16, 10);
/* 137 */     this.rightleg.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 138 */     this.rightleg.setTextureSize(128, 128);
/* 139 */     this.rightleg.mirror = true;
/* 140 */     setRotation(this.rightleg, -0.1745329F, 0.0F, 0.0F);
/* 141 */     this.rightleg2 = new ModelRenderer(this, 23, 106);
/* 142 */     this.rightleg2.addBox(0.0F, 12.0F, -8.0F, 3, 15, 5);
/* 143 */     this.rightleg2.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 144 */     this.rightleg2.setTextureSize(128, 128);
/* 145 */     this.rightleg2.mirror = true;
/* 146 */     setRotation(this.rightleg2, 0.5061455F, 0.0F, 0.0F);
/* 147 */     this.rightleg3 = new ModelRenderer(this, 70, 90);
/* 148 */     this.rightleg3.addBox(0.0F, 19.0F, 16.0F, 3, 9, 3);
/* 149 */     this.rightleg3.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 150 */     this.rightleg3.setTextureSize(128, 128);
/* 151 */     this.rightleg3.mirror = true;
/* 152 */     setRotation(this.rightleg3, -0.4014257F, 0.0F, 0.0F);
/* 153 */     this.leftleg4 = new ModelRenderer(this, 42, 113);
/* 154 */     this.leftleg4.addBox(-1.0F, 31.0F, -1.0F, 3, 3, 8);
/* 155 */     this.leftleg4.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 156 */     this.leftleg4.setTextureSize(128, 128);
/* 157 */     this.leftleg4.mirror = true;
/* 158 */     setRotation(this.leftleg4, 0.0F, 0.0F, 0.0F);
/* 159 */     this.rightleg4 = new ModelRenderer(this, 44, 93);
/* 160 */     this.rightleg4.addBox(0.0F, 31.0F, -1.0F, 3, 3, 8);
/* 161 */     this.rightleg4.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 162 */     this.rightleg4.setTextureSize(128, 128);
/* 163 */     this.rightleg4.mirror = true;
/* 164 */     setRotation(this.rightleg4, 0.0F, 0.0F, 0.0F);
/* 165 */     this.Shape17 = new ModelRenderer(this, 112, 60);
/* 166 */     this.Shape17.addBox(-2.0F, 0.0F, 0.0F, 2, 10, 2);
/* 167 */     this.Shape17.setRotationPoint(-4.0F, -3.533333F, -3.0F);
/* 168 */     this.Shape17.setTextureSize(128, 128);
/* 169 */     this.Shape17.mirror = true;
/* 170 */     setRotation(this.Shape17, -0.5235988F, 0.0F, 0.0F);
/* 171 */     this.TailExtension = new ModelRenderer(this, 0, 10);
/* 172 */     this.TailExtension.addBox(0.0F, 0.0F, 0.0F, 3, 3, 10);
/* 173 */     this.TailExtension.setRotationPoint(-1.0F, -19.0F, 59.0F);
/* 174 */     this.TailExtension.setTextureSize(128, 128);
/* 175 */     this.TailExtension.mirror = true;
/* 176 */     setRotation(this.TailExtension, 0.0F, 0.0F, 0.0F);
/* 177 */     this.Spine1 = new ModelRenderer(this, 73, 0);
/* 178 */     this.Spine1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 179 */     this.Spine1.setRotationPoint(-1.0F, -21.0F, 0.0F);
/* 180 */     this.Spine1.setTextureSize(128, 128);
/* 181 */     this.Spine1.mirror = true;
/* 182 */     setRotation(this.Spine1, 0.0F, 0.0F, 0.0F);
/* 183 */     this.Spine2 = new ModelRenderer(this, 73, 0);
/* 184 */     this.Spine2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 185 */     this.Spine2.setRotationPoint(-0.5F, -21.0F, 6.0F);
/* 186 */     this.Spine2.setTextureSize(128, 128);
/* 187 */     this.Spine2.mirror = true;
/* 188 */     setRotation(this.Spine2, 0.0F, 0.0F, 0.0F);
/* 189 */     this.Spine3 = new ModelRenderer(this, 73, 0);
/* 190 */     this.Spine3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 191 */     this.Spine3.setRotationPoint(-0.5F, -21.0F, 12.0F);
/* 192 */     this.Spine3.setTextureSize(128, 128);
/* 193 */     this.Spine3.mirror = true;
/* 194 */     setRotation(this.Spine3, 0.0F, 0.0F, 0.0F);
/* 195 */     this.Spine4 = new ModelRenderer(this, 73, 0);
/* 196 */     this.Spine4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 197 */     this.Spine4.setRotationPoint(-0.5F, -24.0F, -9.0F);
/* 198 */     this.Spine4.setTextureSize(128, 128);
/* 199 */     this.Spine4.mirror = true;
/* 200 */     setRotation(this.Spine4, -0.4014257F, 0.0F, 0.0F);
/* 201 */     this.Spine5 = new ModelRenderer(this, 73, 0);
/* 202 */     this.Spine5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 203 */     this.Spine5.setRotationPoint(-0.5F, -26.0F, -14.0F);
/* 204 */     this.Spine5.setTextureSize(128, 128);
/* 205 */     this.Spine5.mirror = true;
/* 206 */     setRotation(this.Spine5, -0.4014257F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 211 */     TRex e = (TRex)entity;
/* 212 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 213 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 214 */     float newangle = 0.0F;
/*     */     
/* 216 */     if (f1 > 0.1D) {
/* 217 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 219 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 222 */     this.rightleg.rotateAngleX = -0.174F + newangle;
/* 223 */     this.rightleg2.rotateAngleX = 0.506F + newangle;
/* 224 */     this.rightleg3.rotateAngleX = -0.401F + newangle;
/* 225 */     this.rightleg4.rotateAngleX = newangle;
/*     */     
/* 227 */     this.leftleg.rotateAngleX = -0.174F - newangle;
/* 228 */     this.leftleg2.rotateAngleX = 0.506F - newangle;
/* 229 */     this.leftleg3.rotateAngleX = -0.401F - newangle;
/* 230 */     this.leftleg4.rotateAngleX = -newangle;
/*     */     
/* 232 */     if (e.getAttacking() != 0) {
/* 233 */       this.jaw.rotateAngleX = 0.52F + MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.18F;
/*     */     } else {
/* 235 */       this.jaw.rotateAngleX = 0.1F;
/*     */     } 
/*     */     
/* 238 */     this.Shape17.rotateAngleX = -0.523F + MathHelper.cos(f2 * 0.1F) * 3.1415927F * 0.05F;
/* 239 */     this.Shape11.rotateAngleX = -0.523F + MathHelper.cos(f2 * 0.1F) * 3.1415927F * 0.05F;
/*     */     
/* 241 */     this.Shape18.render(f5);
/* 242 */     this.Shape19.render(f5);
/* 243 */     this.Shape20.render(f5);
/* 244 */     this.Shape21.render(f5);
/* 245 */     this.Shape1.render(f5);
/* 246 */     this.Shape2.render(f5);
/* 247 */     this.Shape3.render(f5);
/* 248 */     this.Shape4.render(f5);
/* 249 */     this.Shape5.render(f5);
/* 250 */     this.Shape6.render(f5);
/* 251 */     this.jaw.render(f5);
/* 252 */     this.leftleg.render(f5);
/* 253 */     this.leftleg2.render(f5);
/* 254 */     this.leftleg3.render(f5);
/* 255 */     this.Shape11.render(f5);
/* 256 */     this.rightleg.render(f5);
/* 257 */     this.rightleg2.render(f5);
/* 258 */     this.rightleg3.render(f5);
/* 259 */     this.leftleg4.render(f5);
/* 260 */     this.rightleg4.render(f5);
/* 261 */     this.Shape17.render(f5);
/* 262 */     this.TailExtension.render(f5);
/* 263 */     this.Spine1.render(f5);
/* 264 */     this.Spine2.render(f5);
/* 265 */     this.Spine3.render(f5);
/* 266 */     this.Spine4.render(f5);
/* 267 */     this.Spine5.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 272 */     model.rotateAngleX = x;
/* 273 */     model.rotateAngleY = y;
/* 274 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 278 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\model\ModelTRex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */