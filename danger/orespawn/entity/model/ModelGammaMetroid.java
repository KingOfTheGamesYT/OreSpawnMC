/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.GammaMetroid;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelGammaMetroid
/*     */   extends ModelBase
/*     */ {
/*     */   private float wingspeed;
/*     */   ModelRenderer Shell3;
/*     */   ModelRenderer Shell4;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer BeakUpper;
/*     */   ModelRenderer BeakLower;
/*     */   ModelRenderer LeftTusk;
/*     */   ModelRenderer MiddleTusk;
/*     */   ModelRenderer RightTusk;
/*     */   ModelRenderer LeftFrontUpperLeg;
/*     */   ModelRenderer LeftFrontLowerLeg;
/*     */   ModelRenderer LeftRearUpperLeg;
/*     */   ModelRenderer LeftRearLowerLeg;
/*     */   ModelRenderer RightFrontUpperLeg;
/*     */   ModelRenderer RightFrontLowerLeg;
/*     */   ModelRenderer RightRearUpperLeg;
/*     */   ModelRenderer RightRearLowerLeg;
/*     */   ModelRenderer Core;
/*     */   ModelRenderer Bellyinside;
/*     */   ModelRenderer Bellyoutside;
/*     */   ModelRenderer Shell1;
/*     */   ModelRenderer Shell2;
/*     */   
/*     */   public ModelGammaMetroid(float f1) {
/*  37 */     this.wingspeed = f1;
/*     */     
/*  39 */     this.textureWidth = 256;
/*  40 */     this.textureHeight = 64;
/*     */     
/*  42 */     this.Shell3 = new ModelRenderer(this, 128, 0);
/*  43 */     this.Shell3.addBox(-6.0F, -6.0F, 0.0F, 12, 12, 7);
/*  44 */     this.Shell3.setRotationPoint(0.0F, 7.0F, 10.0F);
/*  45 */     this.Shell3.setTextureSize(256, 64);
/*  46 */     this.Shell3.mirror = true;
/*  47 */     setRotation(this.Shell3, -0.9599311F, 0.6283185F, 0.5235988F);
/*  48 */     this.Shell4 = new ModelRenderer(this, 48, 34);
/*  49 */     this.Shell4.addBox(0.0F, 0.0F, 0.0F, 6, 6, 8);
/*  50 */     this.Shell4.setRotationPoint(-3.0F, 9.0F, 13.0F);
/*  51 */     this.Shell4.setTextureSize(256, 64);
/*  52 */     this.Shell4.mirror = true;
/*  53 */     setRotation(this.Shell4, -0.2792527F, 0.0F, 0.0F);
/*  54 */     this.Head = new ModelRenderer(this, 48, 48);
/*  55 */     this.Head.addBox(0.0F, 0.0F, 0.0F, 16, 8, 6);
/*  56 */     this.Head.setRotationPoint(-8.0F, -1.0F, -11.0F);
/*  57 */     this.Head.setTextureSize(256, 64);
/*  58 */     this.Head.mirror = true;
/*  59 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/*  60 */     this.BeakUpper = new ModelRenderer(this, 114, 44);
/*  61 */     this.BeakUpper.addBox(-3.0F, 0.0F, -3.0F, 6, 4, 6);
/*  62 */     this.BeakUpper.setRotationPoint(0.0F, 5.0F, -11.0F);
/*  63 */     this.BeakUpper.setTextureSize(256, 64);
/*  64 */     this.BeakUpper.mirror = true;
/*  65 */     setRotation(this.BeakUpper, 0.1047198F, 0.7853982F, 0.1047198F);
/*  66 */     this.BeakLower = new ModelRenderer(this, 120, 54);
/*  67 */     this.BeakLower.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3);
/*  68 */     this.BeakLower.setRotationPoint(0.0F, 9.0F, -12.0F);
/*  69 */     this.BeakLower.setTextureSize(256, 64);
/*  70 */     this.BeakLower.mirror = true;
/*  71 */     setRotation(this.BeakLower, 0.1396263F, 0.7853982F, 0.1396263F);
/*  72 */     this.LeftTusk = new ModelRenderer(this, 76, 50);
/*  73 */     this.LeftTusk.addBox(0.0F, 0.0F, -12.0F, 2, 2, 12);
/*  74 */     this.LeftTusk.setRotationPoint(5.0F, 6.0F, -10.0F);
/*  75 */     this.LeftTusk.setTextureSize(256, 64);
/*  76 */     this.LeftTusk.mirror = true;
/*  77 */     setRotation(this.LeftTusk, 0.1047198F, 0.0872665F, 0.0F);
/*  78 */     this.MiddleTusk = new ModelRenderer(this, 76, 50);
/*  79 */     this.MiddleTusk.addBox(-1.0F, 0.0F, -12.0F, 2, 2, 12);
/*  80 */     this.MiddleTusk.setRotationPoint(0.0F, -2.0F, -10.0F);
/*  81 */     this.MiddleTusk.setTextureSize(256, 64);
/*  82 */     this.MiddleTusk.mirror = true;
/*  83 */     setRotation(this.MiddleTusk, 0.122173F, 0.0F, 0.0F);
/*  84 */     this.RightTusk = new ModelRenderer(this, 76, 50);
/*  85 */     this.RightTusk.addBox(-2.0F, 0.0F, -12.0F, 2, 2, 12);
/*  86 */     this.RightTusk.setRotationPoint(-5.0F, 6.0F, -10.0F);
/*  87 */     this.RightTusk.setTextureSize(256, 64);
/*  88 */     this.RightTusk.mirror = true;
/*  89 */     setRotation(this.RightTusk, 0.1047198F, -0.0872665F, 0.0F);
/*  90 */     this.LeftFrontUpperLeg = new ModelRenderer(this, 64, 0);
/*  91 */     this.LeftFrontUpperLeg.addBox(0.0F, 0.0F, -1.5F, 3, 8, 3);
/*  92 */     this.LeftFrontUpperLeg.setRotationPoint(8.0F, 8.0F, -2.0F);
/*  93 */     this.LeftFrontUpperLeg.setTextureSize(256, 64);
/*  94 */     this.LeftFrontUpperLeg.mirror = true;
/*  95 */     setRotation(this.LeftFrontUpperLeg, -0.1745329F, 0.0F, -0.6632251F);
/*  96 */     this.LeftFrontLowerLeg = new ModelRenderer(this, 48, 0);
/*  97 */     this.LeftFrontLowerLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 11, 2);
/*  98 */     this.LeftFrontLowerLeg.setRotationPoint(14.0F, 13.0F, -3.5F);
/*  99 */     this.LeftFrontLowerLeg.setTextureSize(256, 64);
/* 100 */     this.LeftFrontLowerLeg.mirror = true;
/* 101 */     setRotation(this.LeftFrontLowerLeg, -0.2617994F, 0.1396263F, 0.0F);
/* 102 */     this.LeftRearUpperLeg = new ModelRenderer(this, 64, 0);
/* 103 */     this.LeftRearUpperLeg.addBox(-1.0F, 0.0F, -1.5F, 3, 8, 3);
/* 104 */     this.LeftRearUpperLeg.setRotationPoint(8.0F, 9.0F, 7.0F);
/* 105 */     this.LeftRearUpperLeg.setTextureSize(256, 64);
/* 106 */     this.LeftRearUpperLeg.mirror = true;
/* 107 */     setRotation(this.LeftRearUpperLeg, 0.1745329F, 0.0F, -0.8203047F);
/* 108 */     this.LeftRearLowerLeg = new ModelRenderer(this, 48, 0);
/* 109 */     this.LeftRearLowerLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 11, 2);
/* 110 */     this.LeftRearLowerLeg.setRotationPoint(14.0F, 14.0F, 8.5F);
/* 111 */     this.LeftRearLowerLeg.setTextureSize(256, 64);
/* 112 */     this.LeftRearLowerLeg.mirror = true;
/* 113 */     setRotation(this.LeftRearLowerLeg, 0.3141593F, -0.1570796F, -0.2792527F);
/* 114 */     this.RightFrontUpperLeg = new ModelRenderer(this, 64, 0);
/* 115 */     this.RightFrontUpperLeg.addBox(-3.0F, 0.0F, -1.5F, 3, 8, 3);
/* 116 */     this.RightFrontUpperLeg.setRotationPoint(-8.0F, 8.0F, -2.0F);
/* 117 */     this.RightFrontUpperLeg.setTextureSize(256, 64);
/* 118 */     this.RightFrontUpperLeg.mirror = true;
/* 119 */     setRotation(this.RightFrontUpperLeg, -0.1745329F, 0.0F, 0.6632251F);
/* 120 */     this.RightFrontLowerLeg = new ModelRenderer(this, 48, 0);
/* 121 */     this.RightFrontLowerLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 11, 2);
/* 122 */     this.RightFrontLowerLeg.setRotationPoint(-14.0F, 13.0F, -3.5F);
/* 123 */     this.RightFrontLowerLeg.setTextureSize(256, 64);
/* 124 */     this.RightFrontLowerLeg.mirror = true;
/* 125 */     setRotation(this.RightFrontLowerLeg, -0.2617994F, -0.1396263F, 0.0F);
/* 126 */     this.RightRearUpperLeg = new ModelRenderer(this, 64, 0);
/* 127 */     this.RightRearUpperLeg.addBox(-2.0F, 0.0F, -1.5F, 3, 8, 3);
/* 128 */     this.RightRearUpperLeg.setRotationPoint(-8.0F, 9.0F, 7.0F);
/* 129 */     this.RightRearUpperLeg.setTextureSize(256, 64);
/* 130 */     this.RightRearUpperLeg.mirror = true;
/* 131 */     setRotation(this.RightRearUpperLeg, 0.1745329F, 0.0F, 0.8203047F);
/* 132 */     this.RightRearLowerLeg = new ModelRenderer(this, 48, 0);
/* 133 */     this.RightRearLowerLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 11, 2);
/* 134 */     this.RightRearLowerLeg.setRotationPoint(-14.0F, 14.0F, 8.5F);
/* 135 */     this.RightRearLowerLeg.setTextureSize(256, 64);
/* 136 */     this.RightRearLowerLeg.mirror = true;
/* 137 */     setRotation(this.RightRearLowerLeg, 0.3141593F, 0.1570796F, 0.2792527F);
/* 138 */     this.Core = new ModelRenderer(this, 82, 33);
/* 139 */     this.Core.addBox(-3.0F, 0.0F, -3.0F, 6, 6, 6);
/* 140 */     this.Core.setRotationPoint(0.0F, 8.0F, 3.0F);
/* 141 */     this.Core.setTextureSize(256, 64);
/* 142 */     this.Core.mirror = true;
/* 143 */     setRotation(this.Core, -0.122173F, 0.0F, 0.0F);
/* 144 */     this.Bellyinside = new ModelRenderer(this, 150, 3);
/* 145 */     this.Bellyinside.addBox(-8.0F, -1.0F, -8.0F, 16, 1, 16);
/* 146 */     this.Bellyinside.setRotationPoint(0.0F, 8.0F, 2.0F);
/* 147 */     this.Bellyinside.setTextureSize(256, 64);
/* 148 */     this.Bellyinside.mirror = true;
/* 149 */     setRotation(this.Bellyinside, -0.122173F, 0.0F, 0.0F);
/* 150 */     this.Bellyoutside = new ModelRenderer(this, 0, 0);
/* 151 */     this.Bellyoutside.addBox(-8.0F, -6.0F, -8.0F, 16, 14, 16);
/* 152 */     this.Bellyoutside.setRotationPoint(0.0F, 8.0F, 2.0F);
/* 153 */     this.Bellyoutside.setTextureSize(256, 64);
/* 154 */     this.Bellyoutside.mirror = true;
/* 155 */     setRotation(this.Bellyoutside, -0.122173F, 0.0F, 0.0F);
/* 156 */     this.Shell1 = new ModelRenderer(this, 64, 0);
/* 157 */     this.Shell1.addBox(-10.0F, -10.0F, 2.0F, 19, 19, 12);
/* 158 */     this.Shell1.setRotationPoint(0.0F, 4.0F, -7.0F);
/* 159 */     this.Shell1.setTextureSize(256, 64);
/* 160 */     this.Shell1.mirror = true;
/* 161 */     setRotation(this.Shell1, 0.0F, 0.0F, 0.7853982F);
/* 162 */     this.Shell2 = new ModelRenderer(this, 0, 30);
/* 163 */     this.Shell2.addBox(-9.0F, -9.0F, 0.0F, 16, 16, 8);
/* 164 */     this.Shell2.setRotationPoint(0.0F, 4.5F, 5.0F);
/* 165 */     this.Shell2.setTextureSize(256, 64);
/* 166 */     this.Shell2.mirror = true;
/* 167 */     setRotation(this.Shell2, -0.5235988F, 0.3665191F, 0.715585F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 173 */     GammaMetroid e = (GammaMetroid)entity;
/* 174 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 175 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 176 */     float newangle = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     newangle = MathHelper.cos(f2 * 0.81F * this.wingspeed) * 3.1415927F * 0.08F;
/* 195 */     this.LeftTusk.rotateAngleX = newangle;
/* 196 */     newangle = MathHelper.cos(f2 * 0.87F * this.wingspeed) * 3.1415927F * 0.08F;
/* 197 */     this.RightTusk.rotateAngleX = newangle;
/* 198 */     newangle = MathHelper.cos(f2 * 0.99F * this.wingspeed) * 3.1415927F * 0.08F;
/* 199 */     this.MiddleTusk.rotateAngleX = newangle;
/* 200 */     newangle = MathHelper.cos(f2 * 1.11F * this.wingspeed) * 3.1415927F * 0.08F;
/* 201 */     this.LeftTusk.rotateAngleY = newangle;
/* 202 */     newangle = MathHelper.cos(f2 * 1.17F * this.wingspeed) * 3.1415927F * 0.08F;
/* 203 */     this.RightTusk.rotateAngleY = newangle;
/* 204 */     newangle = MathHelper.cos(f2 * 1.25F * this.wingspeed) * 3.1415927F * 0.08F;
/* 205 */     this.MiddleTusk.rotateAngleY = newangle;
/*     */ 
/*     */     
/* 208 */     float nextangle = 0.0F;
/* 209 */     float upangle = 0.0F;
/* 210 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.12F * f1;
/* 211 */     nextangle = MathHelper.cos((f2 + 0.1F) * 2.0F * this.wingspeed) * 3.1415927F * 0.12F * f1;
/* 212 */     upangle = 0.0F;
/* 213 */     if (nextangle > newangle) {
/* 214 */       upangle = 0.47F * f1 - Math.abs(newangle);
/*     */     }
/* 216 */     doLeftFLeg(this.LeftFrontUpperLeg, this.LeftFrontLowerLeg, newangle, upangle);
/* 217 */     doRightFLeg(this.RightFrontUpperLeg, this.RightFrontLowerLeg, -newangle, upangle);
/* 218 */     doLeftRLeg(this.LeftRearUpperLeg, this.LeftRearLowerLeg, -newangle, upangle);
/* 219 */     doRightRLeg(this.RightRearUpperLeg, this.RightRearLowerLeg, newangle, upangle);
/*     */ 
/*     */     
/* 222 */     newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.05F;
/* 223 */     if (e.isSitting()) newangle = 0.0F; 
/* 224 */     this.Shell1.rotateAngleX = newangle / 4.0F;
/* 225 */     this.Shell1.rotateAngleY = -(newangle / 4.0F);
/* 226 */     this.Shell2.rotateAngleX = newangle - 0.49F;
/* 227 */     this.Shell2.rotateAngleY = -newangle + 0.33F;
/* 228 */     this.Shell3.rotateAngleX = newangle - 0.96F;
/* 229 */     this.Shell3.rotateAngleY = -newangle + 0.63F;
/* 230 */     this.Shell4.rotateAngleX = newangle - 0.28F;
/*     */ 
/*     */     
/* 233 */     newangle = MathHelper.cos(f2 * 0.75F * this.wingspeed) * 3.1415927F * 0.1F;
/* 234 */     newangle = Math.abs(newangle);
/* 235 */     this.BeakLower.rotateAngleX = newangle + 0.14F;
/* 236 */     this.BeakLower.rotateAngleZ = newangle + 0.14F;
/*     */ 
/*     */ 
/*     */     
/* 240 */     GL11.glEnable(2977);
/* 241 */     GL11.glEnable(3042);
/* 242 */     GL11.glBlendFunc(770, 771);
/*     */     
/* 244 */     this.Core.render(f5);
/* 245 */     this.Shell3.render(f5);
/* 246 */     this.Shell4.render(f5);
/* 247 */     this.Head.render(f5);
/* 248 */     this.BeakUpper.render(f5);
/* 249 */     this.BeakLower.render(f5);
/* 250 */     this.LeftTusk.render(f5);
/* 251 */     this.MiddleTusk.render(f5);
/* 252 */     this.RightTusk.render(f5);
/* 253 */     this.LeftFrontUpperLeg.render(f5);
/* 254 */     this.LeftFrontLowerLeg.render(f5);
/* 255 */     this.LeftRearUpperLeg.render(f5);
/* 256 */     this.LeftRearLowerLeg.render(f5);
/* 257 */     this.RightFrontUpperLeg.render(f5);
/* 258 */     this.RightFrontLowerLeg.render(f5);
/* 259 */     this.RightRearUpperLeg.render(f5);
/* 260 */     this.RightRearLowerLeg.render(f5);
/* 261 */     this.Bellyinside.render(f5);
/* 262 */     this.Shell1.render(f5);
/* 263 */     this.Shell2.render(f5);
/*     */ 
/*     */     
/* 266 */     this.Bellyoutside.render(f5);
/*     */ 
/*     */     
/* 269 */     GL11.glDisable(3042);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 274 */     model.rotateAngleX = x;
/* 275 */     model.rotateAngleY = y;
/* 276 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 280 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doLeftFLeg(ModelRenderer seg2, ModelRenderer seg3, float angle, float upangle) {
/* 288 */     seg2.rotateAngleX = angle - 0.17F;
/* 289 */     seg3.rotateAngleX = angle - 0.26F;
/*     */     
/* 291 */     seg3.rotationPointZ = (float)(seg2.rotationPointZ + Math.sin(seg2.rotateAngleX) * 7.0D) - 0.5F;
/*     */ 
/*     */     
/* 294 */     seg2.rotateAngleZ = -upangle - 0.66F;
/* 295 */     seg3.rotateAngleZ = -upangle;
/* 296 */     seg2.rotationPointY += (float)(5.0D * Math.cos(seg2.rotateAngleX));
/* 297 */     seg3.rotationPointX = (float)(seg2.rotationPointX + Math.abs(Math.sin(seg2.rotateAngleZ) * 7.0D) + 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doLeftRLeg(ModelRenderer seg2, ModelRenderer seg3, float angle, float upangle) {
/* 303 */     seg2.rotateAngleX = angle + 0.17F;
/* 304 */     seg3.rotateAngleX = angle + 0.31F;
/*     */     
/* 306 */     seg3.rotationPointZ = (float)(seg2.rotationPointZ + Math.sin(seg2.rotateAngleX) * 7.0D) - 0.5F;
/*     */ 
/*     */     
/* 309 */     seg2.rotateAngleZ = -upangle - 0.82F;
/* 310 */     seg3.rotateAngleZ = -upangle;
/* 311 */     seg2.rotationPointY += (float)(5.0D * Math.cos(seg2.rotateAngleX));
/* 312 */     seg3.rotationPointX = (float)(seg2.rotationPointX + Math.abs(Math.sin(seg2.rotateAngleZ) * 7.0D) + 1.5D);
/*     */   }
/*     */ 
/*     */   
/*     */   private void doRightFLeg(ModelRenderer seg2, ModelRenderer seg3, float angle, float upangle) {
/* 317 */     seg2.rotateAngleX = angle - 0.17F;
/* 318 */     seg3.rotateAngleX = angle - 0.26F;
/*     */     
/* 320 */     seg3.rotationPointZ = (float)(seg2.rotationPointZ + Math.sin(seg2.rotateAngleX) * 7.0D) - 0.5F;
/*     */ 
/*     */     
/* 323 */     seg2.rotateAngleZ = -upangle + 0.34F;
/* 324 */     seg3.rotateAngleZ = -upangle;
/* 325 */     seg2.rotationPointY += (float)(5.0D * Math.cos(seg2.rotateAngleX));
/* 326 */     seg3.rotationPointX = (float)(seg2.rotationPointX - Math.abs(Math.sin(seg2.rotateAngleZ) * 7.0D) - 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doRightRLeg(ModelRenderer seg2, ModelRenderer seg3, float angle, float upangle) {
/* 332 */     seg2.rotateAngleX = angle + 0.17F;
/* 333 */     seg3.rotateAngleX = angle + 0.31F;
/*     */     
/* 335 */     seg3.rotationPointZ = (float)(seg2.rotationPointZ + Math.sin(seg2.rotateAngleX) * 7.0D) - 0.5F;
/*     */ 
/*     */     
/* 338 */     seg2.rotateAngleZ = -upangle + 0.82F;
/* 339 */     seg3.rotateAngleZ = -upangle;
/* 340 */     seg2.rotationPointY += (float)(5.0D * Math.cos(seg2.rotateAngleX));
/* 341 */     seg3.rotationPointX = (float)(seg2.rotationPointX - Math.abs(Math.sin(seg2.rotateAngleZ) * 7.0D) - 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\model\ModelGammaMetroid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */