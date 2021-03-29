/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelWormLarge
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer head1;
/*     */   ModelRenderer head2;
/*     */   ModelRenderer head3;
/*     */   ModelRenderer head4;
/*     */   ModelRenderer head5;
/*     */   ModelRenderer neck1;
/*     */   ModelRenderer neck4;
/*     */   ModelRenderer neck5;
/*     */   ModelRenderer neck2;
/*     */   ModelRenderer neck3;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tailtip;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer tail3;
/*     */   ModelRenderer tail4;
/*     */   ModelRenderer tooth1;
/*     */   ModelRenderer tooth2;
/*     */   ModelRenderer tooth3;
/*     */   ModelRenderer tooth4;
/*     */   ModelRenderer tooth5;
/*     */   ModelRenderer tooth6;
/*     */   ModelRenderer tooth7;
/*     */   ModelRenderer tooth8;
/*     */   
/*     */   public ModelWormLarge() {
/*  40 */     this.textureWidth = 256;
/*  41 */     this.textureHeight = 256;
/*     */     
/*  43 */     this.head1 = new ModelRenderer(this, 0, 0);
/*  44 */     this.head1.addBox(-8.0F, -8.0F, -20.0F, 16, 16, 20);
/*  45 */     this.head1.setRotationPoint(0.0F, 0.0F, 10.0F);
/*  46 */     this.head1.setTextureSize(256, 256);
/*  47 */     this.head1.mirror = true;
/*  48 */     setRotation(this.head1, 0.0F, 0.0F, 0.0F);
/*  49 */     this.head2 = new ModelRenderer(this, 83, 27);
/*  50 */     this.head2.addBox(8.0F, -3.0F, -20.0F, 3, 6, 19);
/*  51 */     this.head2.setRotationPoint(0.0F, 0.0F, 10.0F);
/*  52 */     this.head2.setTextureSize(256, 256);
/*  53 */     this.head2.mirror = true;
/*  54 */     setRotation(this.head2, 0.0F, 0.0F, 0.0F);
/*  55 */     this.head3 = new ModelRenderer(this, 9, 65);
/*  56 */     this.head3.addBox(-11.0F, -3.0F, -20.0F, 3, 6, 19);
/*  57 */     this.head3.setRotationPoint(0.0F, 0.0F, 10.0F);
/*  58 */     this.head3.setTextureSize(256, 256);
/*  59 */     this.head3.mirror = true;
/*  60 */     setRotation(this.head3, 0.0F, 0.0F, 0.0F);
/*  61 */     this.head4 = new ModelRenderer(this, 77, 0);
/*  62 */     this.head4.addBox(-3.0F, -11.0F, -20.0F, 6, 3, 20);
/*  63 */     this.head4.setRotationPoint(0.0F, 0.0F, 10.0F);
/*  64 */     this.head4.setTextureSize(256, 256);
/*  65 */     this.head4.mirror = true;
/*  66 */     setRotation(this.head4, 0.0F, 0.0F, 0.0F);
/*  67 */     this.head5 = new ModelRenderer(this, 10, 39);
/*  68 */     this.head5.addBox(-3.0F, 8.0F, -20.0F, 6, 3, 20);
/*  69 */     this.head5.setRotationPoint(0.0F, 0.0F, 10.0F);
/*  70 */     this.head5.setTextureSize(256, 256);
/*  71 */     this.head5.mirror = true;
/*  72 */     setRotation(this.head5, 0.0F, 0.0F, 0.0F);
/*  73 */     this.neck1 = new ModelRenderer(this, 25, 94);
/*  74 */     this.neck1.addBox(-6.0F, -6.0F, -36.0F, 12, 12, 36);
/*  75 */     this.neck1.setRotationPoint(0.0F, 20.0F, 33.0F);
/*  76 */     this.neck1.setTextureSize(256, 256);
/*  77 */     this.neck1.mirror = true;
/*  78 */     setRotation(this.neck1, -0.6981317F, 0.0F, 0.0F);
/*  79 */     this.neck4 = new ModelRenderer(this, 25, 146);
/*  80 */     this.neck4.addBox(-2.0F, -8.0F, -38.0F, 4, 2, 38);
/*  81 */     this.neck4.setRotationPoint(0.0F, 20.0F, 33.0F);
/*  82 */     this.neck4.setTextureSize(256, 256);
/*  83 */     this.neck4.mirror = true;
/*  84 */     setRotation(this.neck4, -0.6981317F, 0.0F, 0.0F);
/*  85 */     this.neck5 = new ModelRenderer(this, 125, 189);
/*  86 */     this.neck5.addBox(-2.0F, 6.0F, -31.0F, 4, 2, 31);
/*  87 */     this.neck5.setRotationPoint(0.0F, 20.0F, 33.0F);
/*  88 */     this.neck5.setTextureSize(256, 256);
/*  89 */     this.neck5.mirror = true;
/*  90 */     setRotation(this.neck5, -0.6981317F, 0.0F, 0.0F);
/*  91 */     this.neck2 = new ModelRenderer(this, 25, 189);
/*  92 */     this.neck2.addBox(6.0F, -2.0F, -34.0F, 2, 4, 34);
/*  93 */     this.neck2.setRotationPoint(0.0F, 20.0F, 33.0F);
/*  94 */     this.neck2.setTextureSize(256, 256);
/*  95 */     this.neck2.mirror = true;
/*  96 */     setRotation(this.neck2, -0.6981317F, 0.0F, 0.0F);
/*  97 */     this.neck3 = new ModelRenderer(this, 125, 147);
/*  98 */     this.neck3.addBox(-8.0F, -2.0F, -34.0F, 2, 4, 34);
/*  99 */     this.neck3.setRotationPoint(0.0F, 20.0F, 33.0F);
/* 100 */     this.neck3.setTextureSize(256, 256);
/* 101 */     this.neck3.mirror = true;
/* 102 */     setRotation(this.neck3, -0.6981317F, 0.0F, 0.0F);
/* 103 */     this.tail1 = new ModelRenderer(this, 145, 21);
/* 104 */     this.tail1.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 24);
/* 105 */     this.tail1.setRotationPoint(0.0F, 20.0F, 29.0F);
/* 106 */     this.tail1.setTextureSize(256, 256);
/* 107 */     this.tail1.mirror = true;
/* 108 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/* 109 */     this.tailtip = new ModelRenderer(this, 180, 0);
/* 110 */     this.tailtip.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 12);
/* 111 */     this.tailtip.setRotationPoint(0.0F, 19.5F, 52.0F);
/* 112 */     this.tailtip.setTextureSize(256, 256);
/* 113 */     this.tailtip.mirror = true;
/* 114 */     setRotation(this.tailtip, 0.3490659F, 0.0F, 0.0F);
/* 115 */     this.tail2 = new ModelRenderer(this, 145, 56);
/* 116 */     this.tail2.addBox(4.0F, -1.0F, 2.0F, 1, 2, 14);
/* 117 */     this.tail2.setRotationPoint(0.0F, 20.0F, 29.0F);
/* 118 */     this.tail2.setTextureSize(256, 256);
/* 119 */     this.tail2.mirror = true;
/* 120 */     setRotation(this.tail2, 0.0F, 0.0F, 0.0F);
/* 121 */     this.tail3 = new ModelRenderer(this, 145, 90);
/* 122 */     this.tail3.addBox(-5.0F, -1.0F, 2.0F, 1, 2, 14);
/* 123 */     this.tail3.setRotationPoint(0.0F, 20.0F, 29.0F);
/* 124 */     this.tail3.setTextureSize(256, 256);
/* 125 */     this.tail3.mirror = true;
/* 126 */     setRotation(this.tail3, 0.0F, 0.0F, 0.0F);
/* 127 */     this.tail4 = new ModelRenderer(this, 145, 76);
/* 128 */     this.tail4.addBox(-1.0F, -5.0F, 7.0F, 2, 1, 9);
/* 129 */     this.tail4.setRotationPoint(0.0F, 20.0F, 29.0F);
/* 130 */     this.tail4.setTextureSize(256, 256);
/* 131 */     this.tail4.mirror = true;
/* 132 */     setRotation(this.tail4, 0.0F, 0.0F, 0.0F);
/* 133 */     this.tooth1 = new ModelRenderer(this, 0, 220);
/* 134 */     this.tooth1.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/* 135 */     this.tooth1.setRotationPoint(0.0F, 9.0F, -10.0F);
/* 136 */     this.tooth1.setTextureSize(256, 256);
/* 137 */     this.tooth1.mirror = true;
/* 138 */     setRotation(this.tooth1, 0.0F, 0.0F, 0.0F);
/* 139 */     this.tooth2 = new ModelRenderer(this, 0, 210);
/* 140 */     this.tooth2.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/* 141 */     this.tooth2.setRotationPoint(0.0F, -9.0F, -10.0F);
/* 142 */     this.tooth2.setTextureSize(256, 256);
/* 143 */     this.tooth2.mirror = true;
/* 144 */     setRotation(this.tooth2, 0.0F, 0.0F, 0.0F);
/* 145 */     this.tooth3 = new ModelRenderer(this, 0, 200);
/* 146 */     this.tooth3.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/* 147 */     this.tooth3.setRotationPoint(9.0F, 0.0F, -10.0F);
/* 148 */     this.tooth3.setTextureSize(256, 256);
/* 149 */     this.tooth3.mirror = true;
/* 150 */     setRotation(this.tooth3, 0.0F, 0.0F, 0.0F);
/* 151 */     this.tooth4 = new ModelRenderer(this, 0, 190);
/* 152 */     this.tooth4.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/* 153 */     this.tooth4.setRotationPoint(-9.0F, 0.0F, -10.0F);
/* 154 */     this.tooth4.setTextureSize(256, 256);
/* 155 */     this.tooth4.mirror = true;
/* 156 */     setRotation(this.tooth4, 0.0F, 0.0F, 0.0F);
/* 157 */     this.tooth5 = new ModelRenderer(this, 0, 180);
/* 158 */     this.tooth5.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/* 159 */     this.tooth5.setRotationPoint(-6.0F, -6.0F, -10.0F);
/* 160 */     this.tooth5.setTextureSize(256, 256);
/* 161 */     this.tooth5.mirror = true;
/* 162 */     setRotation(this.tooth5, 0.0F, 0.0F, 0.0F);
/* 163 */     this.tooth6 = new ModelRenderer(this, 0, 170);
/* 164 */     this.tooth6.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/* 165 */     this.tooth6.setRotationPoint(6.0F, 6.0F, -10.0F);
/* 166 */     this.tooth6.setTextureSize(256, 256);
/* 167 */     this.tooth6.mirror = true;
/* 168 */     setRotation(this.tooth6, 0.0F, 0.0F, 0.0F);
/* 169 */     this.tooth7 = new ModelRenderer(this, 0, 160);
/* 170 */     this.tooth7.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/* 171 */     this.tooth7.setRotationPoint(6.0F, -6.0F, -10.0F);
/* 172 */     this.tooth7.setTextureSize(256, 256);
/* 173 */     this.tooth7.mirror = true;
/* 174 */     setRotation(this.tooth7, 0.0F, 0.0F, 0.0F);
/* 175 */     this.tooth8 = new ModelRenderer(this, 0, 150);
/* 176 */     this.tooth8.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/* 177 */     this.tooth8.setRotationPoint(-6.0F, 6.0F, -10.0F);
/* 178 */     this.tooth8.setTextureSize(256, 256);
/* 179 */     this.tooth8.mirror = true;
/* 180 */     setRotation(this.tooth8, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 187 */     double dist = 32.0D;
/* 188 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 189 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 191 */     float newangle = MathHelper.cos(f2 * 0.25F) * 3.1415927F * 0.08F;
/* 192 */     newangle -= 0.698F;
/* 193 */     this.neck1.rotateAngleX = newangle;
/* 194 */     float newangle2 = MathHelper.cos(f2 * 0.15F) * 3.1415927F * 0.07F;
/* 195 */     this.neck1.rotateAngleY = newangle2;
/* 196 */     this.neck5.rotateAngleX = this.neck1.rotateAngleX;
/* 197 */     this.neck5.rotateAngleY = this.neck1.rotateAngleY;
/*     */     
/* 199 */     double d1 = (float)(Math.cos(newangle) * dist);
/* 200 */     double d2 = (float)(Math.sin(newangle) * dist);
/* 201 */     this.head1.rotationPointZ = (float)(this.neck1.rotationPointZ - d1);
/* 202 */     double d3 = (float)(Math.sin(newangle2) * d1);
/* 203 */     double d4 = (float)(Math.cos(newangle2) * d1);
/* 204 */     this.head1.rotationPointX = (float)(this.neck1.rotationPointX - d3);
/* 205 */     this.head1.rotationPointY = (float)(this.neck1.rotationPointY + d2);
/* 206 */     this.head1.rotateAngleX = newangle = MathHelper.cos(f2 * 0.35F) * 3.1415927F * 0.15F;
/* 207 */     this.head1.rotateAngleY = newangle2 = MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.05F;
/*     */     
/* 209 */     this.head5.rotationPointX = this.head1.rotationPointX;
/* 210 */     this.head5.rotationPointY = this.head1.rotationPointY;
/* 211 */     this.head5.rotationPointZ = this.head1.rotationPointZ;
/* 212 */     this.head5.rotateAngleX = this.head1.rotateAngleX;
/* 213 */     this.head5.rotateAngleY = this.head1.rotateAngleY;
/*     */ 
/*     */ 
/*     */     
/* 217 */     dist = 19.0D;
/* 218 */     d1 = (float)(Math.cos(newangle) * dist);
/* 219 */     d2 = (float)(Math.sin(newangle) * dist);
/* 220 */     this.tooth1.rotationPointZ = (float)(this.head1.rotationPointZ - d1);
/* 221 */     d3 = (float)(Math.sin(newangle2) * d1);
/* 222 */     d4 = (float)(Math.cos(newangle2) * d1);
/* 223 */     this.tooth1.rotationPointX = (float)(this.head1.rotationPointX - d3);
/* 224 */     this.tooth1.rotationPointY = (float)(this.head1.rotationPointY + d2 - 9.0D);
/*     */     
/* 226 */     this.tooth2.rotationPointZ = this.tooth1.rotationPointZ;
/* 227 */     this.tooth2.rotationPointX = this.tooth1.rotationPointX;
/* 228 */     this.tooth1.rotationPointY += 18.0F;
/*     */     
/* 230 */     this.tooth3.rotationPointZ = this.tooth1.rotationPointZ;
/* 231 */     this.tooth1.rotationPointX += 9.0F;
/* 232 */     this.tooth1.rotationPointY += 9.0F;
/*     */     
/* 234 */     this.tooth4.rotationPointZ = this.tooth1.rotationPointZ;
/* 235 */     this.tooth1.rotationPointX -= 9.0F;
/* 236 */     this.tooth1.rotationPointY += 9.0F;
/*     */     
/* 238 */     this.tooth5.rotationPointZ = this.tooth1.rotationPointZ;
/* 239 */     this.tooth1.rotationPointX -= 6.0F;
/* 240 */     this.tooth5.rotationPointY = this.tooth1.rotationPointY + 9.0F - 6.0F;
/*     */     
/* 242 */     this.tooth6.rotationPointZ = this.tooth1.rotationPointZ;
/* 243 */     this.tooth1.rotationPointX += 6.0F;
/* 244 */     this.tooth6.rotationPointY = this.tooth1.rotationPointY + 9.0F + 6.0F;
/*     */     
/* 246 */     this.tooth7.rotationPointZ = this.tooth1.rotationPointZ;
/* 247 */     this.tooth1.rotationPointX += 6.0F;
/* 248 */     this.tooth7.rotationPointY = this.tooth1.rotationPointY + 9.0F - 6.0F;
/*     */     
/* 250 */     this.tooth8.rotationPointZ = this.tooth1.rotationPointZ;
/* 251 */     this.tooth1.rotationPointX -= 6.0F;
/* 252 */     this.tooth8.rotationPointY = this.tooth1.rotationPointY + 9.0F + 6.0F;
/*     */     
/* 254 */     this.tooth1.rotationPointZ = (float)(this.tooth1.rotationPointZ - Math.sin(this.head1.rotateAngleX) * 9.0D);
/* 255 */     this.tooth2.rotationPointZ = (float)(this.tooth2.rotationPointZ + Math.sin(this.head1.rotateAngleX) * 9.0D);
/*     */     
/* 257 */     this.tooth3.rotationPointZ = (float)(this.tooth3.rotationPointZ - Math.sin(this.head1.rotateAngleY) * 9.0D);
/* 258 */     this.tooth4.rotationPointZ = (float)(this.tooth4.rotationPointZ + Math.sin(this.head1.rotateAngleY) * 9.0D);
/*     */     
/* 260 */     this.tooth7.rotationPointZ = (float)(this.tooth7.rotationPointZ - Math.sin(this.head1.rotateAngleX) * 6.0D);
/* 261 */     this.tooth7.rotationPointZ = (float)(this.tooth7.rotationPointZ - Math.sin(this.head1.rotateAngleY) * 6.0D);
/*     */     
/* 263 */     this.tooth6.rotationPointZ = (float)(this.tooth6.rotationPointZ + Math.sin(this.head1.rotateAngleX) * 6.0D);
/* 264 */     this.tooth6.rotationPointZ = (float)(this.tooth6.rotationPointZ - Math.sin(this.head1.rotateAngleY) * 6.0D);
/*     */     
/* 266 */     this.tooth5.rotationPointZ = (float)(this.tooth5.rotationPointZ - Math.sin(this.head1.rotateAngleX) * 6.0D);
/* 267 */     this.tooth5.rotationPointZ = (float)(this.tooth5.rotationPointZ + Math.sin(this.head1.rotateAngleY) * 6.0D);
/*     */     
/* 269 */     this.tooth8.rotationPointZ = (float)(this.tooth8.rotationPointZ + Math.sin(this.head1.rotateAngleX) * 6.0D);
/* 270 */     this.tooth8.rotationPointZ = (float)(this.tooth8.rotationPointZ + Math.sin(this.head1.rotateAngleY) * 6.0D);
/*     */     
/* 272 */     newangle = MathHelper.cos(f2 * 0.57F) * 3.1415927F * 0.35F;
/*     */     
/* 274 */     this.head1.rotateAngleX += newangle;
/* 275 */     this.head1.rotateAngleX -= newangle;
/* 276 */     this.head1.rotateAngleY += newangle;
/* 277 */     this.head1.rotateAngleY -= newangle;
/*     */     
/* 279 */     this.head1.rotateAngleX += newangle;
/* 280 */     this.head1.rotateAngleX += newangle;
/* 281 */     this.head1.rotateAngleX -= newangle;
/* 282 */     this.head1.rotateAngleX -= newangle;
/*     */     
/* 284 */     this.head1.rotateAngleY += newangle;
/* 285 */     this.head1.rotateAngleY += newangle;
/* 286 */     this.head1.rotateAngleY -= newangle;
/* 287 */     this.head1.rotateAngleY -= newangle;
/*     */     
/* 289 */     newangle = MathHelper.cos(f2 * 0.63F) * 3.1415927F * 0.15F;
/* 290 */     this.tailtip.rotateAngleX = newangle + 0.35F;
/* 291 */     newangle = MathHelper.cos((float)((f2 * 0.63F) + 1.57075D)) * 3.1415927F * 0.15F;
/* 292 */     this.tailtip.rotateAngleY = newangle;
/*     */     
/* 294 */     this.head1.render(f5);
/* 295 */     this.head2.render(f5);
/* 296 */     this.head3.render(f5);
/* 297 */     this.head4.render(f5);
/* 298 */     this.head5.render(f5);
/* 299 */     this.neck1.render(f5);
/* 300 */     this.neck4.render(f5);
/* 301 */     this.neck5.render(f5);
/* 302 */     this.neck2.render(f5);
/* 303 */     this.neck3.render(f5);
/* 304 */     this.tail1.render(f5);
/* 305 */     this.tailtip.render(f5);
/* 306 */     this.tail2.render(f5);
/* 307 */     this.tail3.render(f5);
/* 308 */     this.tail4.render(f5);
/* 309 */     this.tooth1.render(f5);
/* 310 */     this.tooth2.render(f5);
/* 311 */     this.tooth3.render(f5);
/* 312 */     this.tooth4.render(f5);
/* 313 */     this.tooth5.render(f5);
/* 314 */     this.tooth6.render(f5);
/* 315 */     this.tooth7.render(f5);
/* 316 */     this.tooth8.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 322 */     model.rotateAngleX = x;
/* 323 */     model.rotateAngleY = y;
/* 324 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 329 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelWormLarge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */