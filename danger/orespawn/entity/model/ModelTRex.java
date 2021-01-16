/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.TRex;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelTRex
/*     */   extends ModelBase {
/*  11 */   private float wingspeed = 1.0F;
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
/*     */   ModelRenderer TailExtension;
/*     */   ModelRenderer Spine1;
/*     */   ModelRenderer Spine2;
/*     */   ModelRenderer Spine3;
/*     */   ModelRenderer Spine4;
/*     */   ModelRenderer Spine5;
/*     */   
/*     */   public ModelTRex(float f1) {
/*  43 */     this.textureWidth = 128;
/*  44 */     this.textureHeight = 128;
/*  45 */     this.wingspeed = f1;
/*     */     
/*  47 */     this.Shape18 = new ModelRenderer(this, 91, 114);
/*  48 */     this.Shape18.addBox(0.0F, 0.0F, 0.0F, 2, 4, 5);
/*  49 */     this.Shape18.setRotationPoint(3.3F, -25.0F, -23.0F);
/*  50 */     this.Shape18.setTextureSize(128, 128);
/*  51 */     this.Shape18.mirror = true;
/*  52 */     setRotation(this.Shape18, 0.5759587F, 0.0F, 0.5585054F);
/*  53 */     this.Shape19 = new ModelRenderer(this, 71, 114);
/*  54 */     this.Shape19.addBox(0.0F, 0.0F, 0.0F, 2, 4, 5);
/*  55 */     this.Shape19.setRotationPoint(-4.0F, -24.0F, -23.0F);
/*  56 */     this.Shape19.setTextureSize(128, 128);
/*  57 */     this.Shape19.mirror = true;
/*  58 */     setRotation(this.Shape19, 0.5759587F, 0.0F, -0.5585054F);
/*  59 */     this.Shape20 = new ModelRenderer(this, 91, 30);
/*  60 */     this.Shape20.addBox(0.0F, 0.0F, 0.0F, 2, 7, 5);
/*  61 */     this.Shape20.setRotationPoint(5.0F, -8.0F, -6.0F);
/*  62 */     this.Shape20.setTextureSize(128, 128);
/*  63 */     this.Shape20.mirror = true;
/*  64 */     setRotation(this.Shape20, 0.3839724F, 0.0F, 0.0F);
/*  65 */     this.Shape21 = new ModelRenderer(this, 93, 46);
/*  66 */     this.Shape21.addBox(-2.0F, 0.0F, 0.0F, 2, 7, 5);
/*  67 */     this.Shape21.setRotationPoint(-4.0F, -8.0F, -6.0F);
/*  68 */     this.Shape21.setTextureSize(128, 128);
/*  69 */     this.Shape21.mirror = true;
/*  70 */     setRotation(this.Shape21, 0.3839724F, 0.0F, 0.0F);
/*  71 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  72 */     this.Shape1.addBox(-7.0F, 0.0F, 0.0F, 10, 18, 31);
/*  73 */     this.Shape1.setRotationPoint(2.5F, -19.0F, -8.0F);
/*  74 */     this.Shape1.setTextureSize(128, 128);
/*  75 */     this.Shape1.mirror = true;
/*  76 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  77 */     this.Shape2 = new ModelRenderer(this, 62, 0);
/*  78 */     this.Shape2.addBox(-5.0F, 0.0F, 0.0F, 10, 11, 11);
/*  79 */     this.Shape2.setRotationPoint(0.5F, -19.0F, 23.0F);
/*  80 */     this.Shape2.setTextureSize(128, 128);
/*  81 */     this.Shape2.mirror = true;
/*  82 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*  83 */     this.Shape3 = new ModelRenderer(this, 10, 54);
/*  84 */     this.Shape3.addBox(-3.0F, 0.0F, 0.0F, 7, 7, 25);
/*  85 */     this.Shape3.setRotationPoint(0.0F, -19.0F, 34.0F);
/*  86 */     this.Shape3.setTextureSize(128, 128);
/*  87 */     this.Shape3.mirror = true;
/*  88 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*  89 */     this.Shape4 = new ModelRenderer(this, 68, 88);
/*  90 */     this.Shape4.addBox(-5.0F, 0.0F, 0.0F, 8, 9, 16);
/*  91 */     this.Shape4.setRotationPoint(1.5F, -25.0F, -16.0F);
/*  92 */     this.Shape4.setTextureSize(128, 128);
/*  93 */     this.Shape4.mirror = true;
/*  94 */     setRotation(this.Shape4, -0.4014257F, 0.0F, 0.0F);
/*  95 */     this.Shape5 = new ModelRenderer(this, 75, 65);
/*  96 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 9, 9, 12);
/*  97 */     this.Shape5.setRotationPoint(-4.0F, -25.0F, -27.0F);
/*  98 */     this.Shape5.setTextureSize(128, 128);
/*  99 */     this.Shape5.mirror = true;
/* 100 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/* 101 */     this.Shape6 = new ModelRenderer(this, 0, 50);
/* 102 */     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 7, 9, 9);
/* 103 */     this.Shape6.setRotationPoint(-3.0F, -25.0F, -36.0F);
/* 104 */     this.Shape6.setTextureSize(128, 128);
/* 105 */     this.Shape6.mirror = true;
/* 106 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/* 107 */     this.jaw = new ModelRenderer(this, 0, 86);
/* 108 */     this.jaw.addBox(-5.0F, 0.0F, -10.0F, 7, 1, 13);
/* 109 */     this.jaw.setRotationPoint(2.0F, -15.0F, -24.0F);
/* 110 */     this.jaw.setTextureSize(128, 128);
/* 111 */     this.jaw.mirror = true;
/* 112 */     setRotation(this.jaw, 0.5201081F, 0.0F, 0.0F);
/* 113 */     this.leftleg = new ModelRenderer(this, 0, 0);
/* 114 */     this.leftleg.addBox(-1.0F, 0.0F, 0.0F, 3, 16, 10);
/* 115 */     this.leftleg.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 116 */     this.leftleg.setTextureSize(128, 128);
/* 117 */     this.leftleg.mirror = true;
/* 118 */     setRotation(this.leftleg, -0.1745329F, 0.0F, 0.0F);
/* 119 */     this.leftleg2 = new ModelRenderer(this, 0, 106);
/* 120 */     this.leftleg2.addBox(-1.0F, 12.0F, -8.0F, 3, 15, 5);
/* 121 */     this.leftleg2.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 122 */     this.leftleg2.setTextureSize(128, 128);
/* 123 */     this.leftleg2.mirror = true;
/* 124 */     setRotation(this.leftleg2, 0.5061455F, 0.0F, 0.0F);
/* 125 */     this.leftleg3 = new ModelRenderer(this, 112, 89);
/* 126 */     this.leftleg3.addBox(-1.0F, 19.0F, 16.0F, 3, 9, 3);
/* 127 */     this.leftleg3.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 128 */     this.leftleg3.setTextureSize(128, 128);
/* 129 */     this.leftleg3.mirror = true;
/* 130 */     setRotation(this.leftleg3, -0.4014257F, 0.0F, 0.0F);
/* 131 */     this.Shape11 = new ModelRenderer(this, 0, 72);
/* 132 */     this.Shape11.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2);
/* 133 */     this.Shape11.setRotationPoint(5.0F, -5.0F, -3.0F);
/* 134 */     this.Shape11.setTextureSize(128, 128);
/* 135 */     this.Shape11.mirror = true;
/* 136 */     setRotation(this.Shape11, -0.5235988F, 0.0F, 0.0F);
/* 137 */     this.rightleg = new ModelRenderer(this, 54, 51);
/* 138 */     this.rightleg.addBox(0.0F, 0.0F, 0.0F, 3, 16, 10);
/* 139 */     this.rightleg.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 140 */     this.rightleg.setTextureSize(128, 128);
/* 141 */     this.rightleg.mirror = true;
/* 142 */     setRotation(this.rightleg, -0.1745329F, 0.0F, 0.0F);
/* 143 */     this.rightleg2 = new ModelRenderer(this, 23, 106);
/* 144 */     this.rightleg2.addBox(0.0F, 12.0F, -8.0F, 3, 15, 5);
/* 145 */     this.rightleg2.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 146 */     this.rightleg2.setTextureSize(128, 128);
/* 147 */     this.rightleg2.mirror = true;
/* 148 */     setRotation(this.rightleg2, 0.5061455F, 0.0F, 0.0F);
/* 149 */     this.rightleg3 = new ModelRenderer(this, 70, 90);
/* 150 */     this.rightleg3.addBox(0.0F, 19.0F, 16.0F, 3, 9, 3);
/* 151 */     this.rightleg3.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 152 */     this.rightleg3.setTextureSize(128, 128);
/* 153 */     this.rightleg3.mirror = true;
/* 154 */     setRotation(this.rightleg3, -0.4014257F, 0.0F, 0.0F);
/* 155 */     this.leftleg4 = new ModelRenderer(this, 42, 113);
/* 156 */     this.leftleg4.addBox(-1.0F, 31.0F, -1.0F, 3, 3, 8);
/* 157 */     this.leftleg4.setRotationPoint(6.0F, -10.0F, 11.0F);
/* 158 */     this.leftleg4.setTextureSize(128, 128);
/* 159 */     this.leftleg4.mirror = true;
/* 160 */     setRotation(this.leftleg4, 0.0F, 0.0F, 0.0F);
/* 161 */     this.rightleg4 = new ModelRenderer(this, 44, 93);
/* 162 */     this.rightleg4.addBox(0.0F, 31.0F, -1.0F, 3, 3, 8);
/* 163 */     this.rightleg4.setRotationPoint(-7.0F, -10.0F, 11.0F);
/* 164 */     this.rightleg4.setTextureSize(128, 128);
/* 165 */     this.rightleg4.mirror = true;
/* 166 */     setRotation(this.rightleg4, 0.0F, 0.0F, 0.0F);
/* 167 */     this.Shape17 = new ModelRenderer(this, 112, 60);
/* 168 */     this.Shape17.addBox(-2.0F, 0.0F, 0.0F, 2, 10, 2);
/* 169 */     this.Shape17.setRotationPoint(-4.0F, -3.533333F, -3.0F);
/* 170 */     this.Shape17.setTextureSize(128, 128);
/* 171 */     this.Shape17.mirror = true;
/* 172 */     setRotation(this.Shape17, -0.5235988F, 0.0F, 0.0F);
/* 173 */     this.TailExtension = new ModelRenderer(this, 0, 10);
/* 174 */     this.TailExtension.addBox(0.0F, 0.0F, 0.0F, 3, 3, 10);
/* 175 */     this.TailExtension.setRotationPoint(-1.0F, -19.0F, 59.0F);
/* 176 */     this.TailExtension.setTextureSize(128, 128);
/* 177 */     this.TailExtension.mirror = true;
/* 178 */     setRotation(this.TailExtension, 0.0F, 0.0F, 0.0F);
/* 179 */     this.Spine1 = new ModelRenderer(this, 73, 0);
/* 180 */     this.Spine1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 181 */     this.Spine1.setRotationPoint(-1.0F, -21.0F, 0.0F);
/* 182 */     this.Spine1.setTextureSize(128, 128);
/* 183 */     this.Spine1.mirror = true;
/* 184 */     setRotation(this.Spine1, 0.0F, 0.0F, 0.0F);
/* 185 */     this.Spine2 = new ModelRenderer(this, 73, 0);
/* 186 */     this.Spine2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 187 */     this.Spine2.setRotationPoint(-0.5F, -21.0F, 6.0F);
/* 188 */     this.Spine2.setTextureSize(128, 128);
/* 189 */     this.Spine2.mirror = true;
/* 190 */     setRotation(this.Spine2, 0.0F, 0.0F, 0.0F);
/* 191 */     this.Spine3 = new ModelRenderer(this, 73, 0);
/* 192 */     this.Spine3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 193 */     this.Spine3.setRotationPoint(-0.5F, -21.0F, 12.0F);
/* 194 */     this.Spine3.setTextureSize(128, 128);
/* 195 */     this.Spine3.mirror = true;
/* 196 */     setRotation(this.Spine3, 0.0F, 0.0F, 0.0F);
/* 197 */     this.Spine4 = new ModelRenderer(this, 73, 0);
/* 198 */     this.Spine4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 199 */     this.Spine4.setRotationPoint(-0.5F, -24.0F, -9.0F);
/* 200 */     this.Spine4.setTextureSize(128, 128);
/* 201 */     this.Spine4.mirror = true;
/* 202 */     setRotation(this.Spine4, -0.4014257F, 0.0F, 0.0F);
/* 203 */     this.Spine5 = new ModelRenderer(this, 73, 0);
/* 204 */     this.Spine5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
/* 205 */     this.Spine5.setRotationPoint(-0.5F, -26.0F, -14.0F);
/* 206 */     this.Spine5.setTextureSize(128, 128);
/* 207 */     this.Spine5.mirror = true;
/* 208 */     setRotation(this.Spine5, -0.4014257F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 214 */     TRex e = (TRex)entity;
/* 215 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 216 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 217 */     float newangle = 0.0F;
/*     */     
/* 219 */     if (f1 > 0.1D) {
/* 220 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 222 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 225 */     this.rightleg.rotateAngleX = -0.174F + newangle;
/* 226 */     this.rightleg2.rotateAngleX = 0.506F + newangle;
/* 227 */     this.rightleg3.rotateAngleX = -0.401F + newangle;
/* 228 */     this.rightleg4.rotateAngleX = newangle;
/*     */     
/* 230 */     this.leftleg.rotateAngleX = -0.174F - newangle;
/* 231 */     this.leftleg2.rotateAngleX = 0.506F - newangle;
/* 232 */     this.leftleg3.rotateAngleX = -0.401F - newangle;
/* 233 */     this.leftleg4.rotateAngleX = -newangle;
/*     */     
/* 235 */     if (e.getAttacking() != 0) {
/* 236 */       this.jaw.rotateAngleX = 0.52F + MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.18F;
/*     */     } else {
/* 238 */       this.jaw.rotateAngleX = 0.1F;
/*     */     } 
/*     */     
/* 241 */     this.Shape17.rotateAngleX = -0.523F + MathHelper.cos(f2 * 0.1F) * 3.1415927F * 0.05F;
/* 242 */     this.Shape11.rotateAngleX = -0.523F + MathHelper.cos(f2 * 0.1F) * 3.1415927F * 0.05F;
/*     */     
/* 244 */     this.Shape18.render(f5);
/* 245 */     this.Shape19.render(f5);
/* 246 */     this.Shape20.render(f5);
/* 247 */     this.Shape21.render(f5);
/* 248 */     this.Shape1.render(f5);
/* 249 */     this.Shape2.render(f5);
/* 250 */     this.Shape3.render(f5);
/* 251 */     this.Shape4.render(f5);
/* 252 */     this.Shape5.render(f5);
/* 253 */     this.Shape6.render(f5);
/* 254 */     this.jaw.render(f5);
/* 255 */     this.leftleg.render(f5);
/* 256 */     this.leftleg2.render(f5);
/* 257 */     this.leftleg3.render(f5);
/* 258 */     this.Shape11.render(f5);
/* 259 */     this.rightleg.render(f5);
/* 260 */     this.rightleg2.render(f5);
/* 261 */     this.rightleg3.render(f5);
/* 262 */     this.leftleg4.render(f5);
/* 263 */     this.rightleg4.render(f5);
/* 264 */     this.Shape17.render(f5);
/* 265 */     this.TailExtension.render(f5);
/* 266 */     this.Spine1.render(f5);
/* 267 */     this.Spine2.render(f5);
/* 268 */     this.Spine3.render(f5);
/* 269 */     this.Spine4.render(f5);
/* 270 */     this.Spine5.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 276 */     model.rotateAngleX = x;
/* 277 */     model.rotateAngleY = y;
/* 278 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 283 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\entity\model\ModelTRex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */