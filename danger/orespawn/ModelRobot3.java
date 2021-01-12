/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelRobot3
/*     */   extends ModelBase
/*     */ {
/*  12 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer rleg1;
/*     */   
/*     */   ModelRenderer lleg1;
/*     */   ModelRenderer rleg2;
/*     */   ModelRenderer lleg2;
/*     */   ModelRenderer hips;
/*     */   ModelRenderer waist1;
/*     */   ModelRenderer waist2;
/*     */   ModelRenderer body3;
/*     */   ModelRenderer lazer;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer body1;
/*     */   ModelRenderer body4;
/*     */   ModelRenderer waist3;
/*     */   ModelRenderer larm3;
/*     */   ModelRenderer rarm3;
/*     */   ModelRenderer larm2;
/*     */   ModelRenderer rarm2;
/*     */   ModelRenderer larm1;
/*     */   ModelRenderer rarm1;
/*     */   
/*     */   public ModelRobot3(float f1) {
/*  36 */     this.wingspeed = f1;
/*     */     
/*  38 */     this.textureWidth = 512;
/*  39 */     this.textureHeight = 512;
/*     */     
/*  41 */     this.rleg1 = new ModelRenderer(this, 20, 100);
/*  42 */     this.rleg1.addBox(-23.0F, 26.0F, -8.0F, 16, 29, 16);
/*  43 */     this.rleg1.setRotationPoint(-9.0F, -31.0F, 0.0F);
/*  44 */     this.rleg1.setTextureSize(512, 512);
/*  45 */     this.rleg1.mirror = true;
/*  46 */     setRotation(this.rleg1, 0.0F, 0.0F, 0.0F);
/*  47 */     this.lleg1 = new ModelRenderer(this, 20, 159);
/*  48 */     this.lleg1.addBox(7.0F, 25.0F, -8.0F, 16, 29, 16);
/*  49 */     this.lleg1.setRotationPoint(9.0F, -30.0F, 0.0F);
/*  50 */     this.lleg1.setTextureSize(512, 512);
/*  51 */     this.lleg1.mirror = true;
/*  52 */     setRotation(this.lleg1, 0.0F, 0.0F, 0.0F);
/*  53 */     this.rleg2 = new ModelRenderer(this, 20, 212);
/*  54 */     this.rleg2.addBox(-14.0F, 0.0F, -7.0F, 14, 29, 14);
/*  55 */     this.rleg2.setRotationPoint(-9.0F, -31.0F, 0.0F);
/*  56 */     this.rleg2.setTextureSize(512, 512);
/*  57 */     this.rleg2.mirror = true;
/*  58 */     setRotation(this.rleg2, 0.0F, 0.0F, 0.2792527F);
/*  59 */     this.lleg2 = new ModelRenderer(this, 20, 265);
/*  60 */     this.lleg2.addBox(0.0F, 0.0F, -7.0F, 13, 29, 14);
/*  61 */     this.lleg2.setRotationPoint(9.0F, -31.0F, 0.0F);
/*  62 */     this.lleg2.setTextureSize(512, 512);
/*  63 */     this.lleg2.mirror = true;
/*  64 */     setRotation(this.lleg2, 0.0F, 0.0F, -0.2792527F);
/*  65 */     this.hips = new ModelRenderer(this, 20, 316);
/*  66 */     this.hips.addBox(0.0F, 0.0F, 0.0F, 18, 16, 16);
/*  67 */     this.hips.setRotationPoint(-9.0F, -43.0F, -8.0F);
/*  68 */     this.hips.setTextureSize(512, 512);
/*  69 */     this.hips.mirror = true;
/*  70 */     setRotation(this.hips, 0.0F, 0.0F, 0.0F);
/*  71 */     this.waist1 = new ModelRenderer(this, 20, 359);
/*  72 */     this.waist1.addBox(0.0F, 0.0F, 0.0F, 12, 12, 12);
/*  73 */     this.waist1.setRotationPoint(-6.0F, -55.0F, -4.0F);
/*  74 */     this.waist1.setTextureSize(512, 512);
/*  75 */     this.waist1.mirror = true;
/*  76 */     setRotation(this.waist1, -0.1F, 0.0F, 0.0F);
/*  77 */     this.waist2 = new ModelRenderer(this, 20, 391);
/*  78 */     this.waist2.addBox(0.0F, 0.0F, 0.0F, 12, 12, 12);
/*  79 */     this.waist2.setRotationPoint(-6.0F, -67.0F, -4.0F);
/*  80 */     this.waist2.setTextureSize(512, 512);
/*  81 */     this.waist2.mirror = true;
/*  82 */     setRotation(this.waist2, 0.0F, 0.0F, 0.0F);
/*  83 */     this.body3 = new ModelRenderer(this, 20, 426);
/*  84 */     this.body3.addBox(-23.0F, -25.0F, 10.0F, 47, 47, 25);
/*  85 */     this.body3.setRotationPoint(0.0F, -88.0F, -10.0F);
/*  86 */     this.body3.setTextureSize(512, 512);
/*  87 */     this.body3.mirror = true;
/*  88 */     setRotation(this.body3, 0.2F, 0.0F, 0.0F);
/*  89 */     this.lazer = new ModelRenderer(this, 20, 50);
/*  90 */     this.lazer.addBox(-8.0F, -8.0F, -22.0F, 17, 16, 22);
/*  91 */     this.lazer.setRotationPoint(0.0F, -88.0F, -11.0F);
/*  92 */     this.lazer.setTextureSize(512, 512);
/*  93 */     this.lazer.mirror = true;
/*  94 */     setRotation(this.lazer, 0.4F, 0.0F, 0.0F);
/*  95 */     this.body2 = new ModelRenderer(this, 101, 103);
/*  96 */     this.body2.addBox(9.0F, -24.0F, -12.0F, 15, 47, 47);
/*  97 */     this.body2.setRotationPoint(0.0F, -88.0F, -11.0F);
/*  98 */     this.body2.setTextureSize(512, 512);
/*  99 */     this.body2.mirror = true;
/* 100 */     setRotation(this.body2, 0.2F, 0.0F, 0.0F);
/* 101 */     this.body1 = new ModelRenderer(this, 101, 210);
/* 102 */     this.body1.addBox(-23.0F, -24.0F, -12.0F, 15, 47, 47);
/* 103 */     this.body1.setRotationPoint(0.0F, -88.0F, -11.0F);
/* 104 */     this.body1.setTextureSize(512, 512);
/* 105 */     this.body1.mirror = true;
/* 106 */     setRotation(this.body1, 0.2F, 0.0F, 0.0F);
/* 107 */     this.body4 = new ModelRenderer(this, 101, 321);
/* 108 */     this.body4.addBox(-8.0F, -24.0F, -12.0F, 18, 16, 22);
/* 109 */     this.body4.setRotationPoint(0.0F, -88.0F, -11.0F);
/* 110 */     this.body4.setTextureSize(512, 512);
/* 111 */     this.body4.mirror = true;
/* 112 */     setRotation(this.body4, 0.2F, 0.0F, 0.0F);
/* 113 */     this.waist3 = new ModelRenderer(this, 99, 375);
/* 114 */     this.waist3.addBox(0.0F, 0.0F, -1.0F, 12, 17, 12);
/* 115 */     this.waist3.setRotationPoint(-6.0F, -83.0F, -6.0F);
/* 116 */     this.waist3.setTextureSize(512, 512);
/* 117 */     this.waist3.mirror = true;
/* 118 */     setRotation(this.waist3, 0.2F, 0.0F, 0.0F);
/* 119 */     this.larm3 = new ModelRenderer(this, 121, 54);
/* 120 */     this.larm3.addBox(0.0F, -10.0F, -9.0F, 20, 18, 18);
/* 121 */     this.larm3.setRotationPoint(24.0F, -92.0F, 2.0F);
/* 122 */     this.larm3.setTextureSize(512, 512);
/* 123 */     this.larm3.mirror = true;
/* 124 */     setRotation(this.larm3, 1.0F, 0.0F, 0.0F);
/* 125 */     this.rarm3 = new ModelRenderer(this, 26, 8);
/* 126 */     this.rarm3.addBox(-20.0F, -9.0F, -9.0F, 20, 18, 18);
/* 127 */     this.rarm3.setRotationPoint(-23.0F, -92.0F, 2.0F);
/* 128 */     this.rarm3.setTextureSize(512, 512);
/* 129 */     this.rarm3.mirror = true;
/* 130 */     setRotation(this.rarm3, 1.0F, 0.0F, 0.0F);
/* 131 */     this.larm2 = new ModelRenderer(this, 207, 47);
/* 132 */     this.larm2.addBox(3.0F, 8.0F, -7.0F, 14, 29, 14);
/* 133 */     this.larm2.setRotationPoint(24.0F, -92.0F, 2.0F);
/* 134 */     this.larm2.setTextureSize(512, 512);
/* 135 */     this.larm2.mirror = true;
/* 136 */     setRotation(this.larm2, 1.0F, 0.0F, 0.0F);
/* 137 */     this.rarm2 = new ModelRenderer(this, 161, 372);
/* 138 */     this.rarm2.addBox(-17.0F, 9.0F, -7.0F, 14, 29, 14);
/* 139 */     this.rarm2.setRotationPoint(-23.0F, -92.0F, 2.0F);
/* 140 */     this.rarm2.setTextureSize(512, 512);
/* 141 */     this.rarm2.mirror = true;
/* 142 */     setRotation(this.rarm2, 1.0F, 0.0F, 0.0F);
/* 143 */     this.larm1 = new ModelRenderer(this, 185, 433);
/* 144 */     this.larm1.addBox(0.0F, -12.0F, 30.0F, 14, 37, 14);
/* 145 */     this.larm1.setRotationPoint(27.0F, -92.0F, 2.0F);
/* 146 */     this.larm1.setTextureSize(512, 512);
/* 147 */     this.larm1.mirror = true;
/* 148 */     setRotation(this.larm1, -1.0F, 0.0F, 0.0F);
/* 149 */     this.rarm1 = new ModelRenderer(this, 239, 105);
/* 150 */     this.rarm1.addBox(-17.0F, -12.0F, 30.0F, 14, 37, 14);
/* 151 */     this.rarm1.setRotationPoint(-23.0F, -92.0F, 2.0F);
/* 152 */     this.rarm1.setTextureSize(512, 512);
/* 153 */     this.rarm1.mirror = true;
/* 154 */     setRotation(this.rarm1, -1.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 161 */     Robot3 e = (Robot3)entity;
/* 162 */     RenderInfo r = null;
/* 163 */     float newangle = 0.0F;
/* 164 */     float nextangle = 0.0F;
/* 165 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 166 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 169 */     if (f1 > 0.1D) {
/* 170 */       newangle = MathHelper.cos(f2 * 0.55F * this.wingspeed) * 3.1415927F * 0.12F * f1;
/*     */     } else {
/* 172 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 175 */     this.lleg1.rotateAngleX = newangle;
/* 176 */     this.lleg2.rotateAngleX = newangle;
/* 177 */     this.rleg1.rotateAngleX = -newangle;
/* 178 */     this.rleg2.rotateAngleX = -newangle;
/*     */     
/* 180 */     this.lazer.rotateAngleY = (float)Math.toRadians(f3 / 2.0D);
/*     */ 
/*     */     
/* 183 */     r = e.getRenderInfo();
/*     */ 
/*     */ 
/*     */     
/* 187 */     newangle = MathHelper.cos(f2 * 1.0F * this.wingspeed) * 3.1415927F * 0.15F;
/* 188 */     nextangle = MathHelper.cos((f2 + 0.3F) * 1.0F * this.wingspeed) * 3.1415927F * 0.15F;
/*     */ 
/*     */     
/* 191 */     if (nextangle > 0.0F && newangle < 0.0F) {
/*     */       
/* 193 */       r.ri1 = 0;
/* 194 */       if (e.getAttacking() != 0) {
/* 195 */         r.ri1 = 1;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 200 */     if (r.ri1 == 0) {
/* 201 */       newangle = 0.0F;
/*     */     }
/* 203 */     this.rarm1.rotateAngleX = newangle - 1.0F;
/* 204 */     this.rarm2.rotateAngleX = newangle + 1.0F;
/* 205 */     this.rarm3.rotateAngleX = newangle + 1.0F;
/* 206 */     this.larm1.rotateAngleX = newangle - 1.0F;
/* 207 */     this.larm2.rotateAngleX = newangle + 1.0F;
/* 208 */     this.larm3.rotateAngleX = newangle + 1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 217 */     e.setRenderInfo(r);
/*     */ 
/*     */     
/* 220 */     this.rleg1.render(f5);
/* 221 */     this.lleg1.render(f5);
/* 222 */     this.rleg2.render(f5);
/* 223 */     this.lleg2.render(f5);
/* 224 */     this.hips.render(f5);
/* 225 */     this.waist1.render(f5);
/* 226 */     this.waist2.render(f5);
/* 227 */     this.body3.render(f5);
/* 228 */     this.lazer.render(f5);
/* 229 */     this.body2.render(f5);
/* 230 */     this.body1.render(f5);
/* 231 */     this.body4.render(f5);
/* 232 */     this.waist3.render(f5);
/* 233 */     this.larm3.render(f5);
/* 234 */     this.rarm3.render(f5);
/* 235 */     this.larm2.render(f5);
/* 236 */     this.rarm2.render(f5);
/* 237 */     this.larm1.render(f5);
/* 238 */     this.rarm1.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 245 */     model.rotateAngleX = x;
/* 246 */     model.rotateAngleY = y;
/* 247 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 252 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelRobot3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */