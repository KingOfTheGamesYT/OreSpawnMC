/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelCreepingHorror
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer body;
/*     */   ModelRenderer leg1;
/*     */   ModelRenderer leg1part2;
/*     */   ModelRenderer leg2;
/*     */   ModelRenderer leg2part2;
/*     */   ModelRenderer leg3;
/*     */   ModelRenderer leg3part2;
/*     */   ModelRenderer leg4;
/*     */   ModelRenderer leg4part2;
/*     */   ModelRenderer tailseg1;
/*     */   ModelRenderer tailseg2;
/*     */   ModelRenderer tailseg3;
/*     */   ModelRenderer pincer1;
/*     */   ModelRenderer pincer1part2;
/*     */   ModelRenderer pincer2;
/*     */   ModelRenderer pincer2part2;
/*     */   ModelRenderer spike1;
/*     */   ModelRenderer spike2;
/*     */   ModelRenderer spike3;
/*     */   ModelRenderer spike4;
/*     */   ModelRenderer spike5;
/*     */   ModelRenderer insides1;
/*     */   ModelRenderer insides2;
/*     */   ModelRenderer insides3;
/*     */   ModelRenderer insides4;
/*     */   ModelRenderer insides5;
/*     */   
/*     */   public ModelCreepingHorror() {
/*  40 */     this.textureWidth = 128;
/*  41 */     this.textureHeight = 128;
/*     */     
/*  43 */     this.body = new ModelRenderer(this, 0, 30);
/*  44 */     this.body.addBox(-4.0F, -5.0F, -4.0F, 8, 8, 8);
/*  45 */     this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
/*  46 */     this.body.setTextureSize(128, 128);
/*  47 */     this.body.mirror = true;
/*  48 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  49 */     this.leg1 = new ModelRenderer(this, 65, 0);
/*  50 */     this.leg1.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2);
/*  51 */     this.leg1.setRotationPoint(4.0F, 18.0F, -2.0F);
/*  52 */     this.leg1.setTextureSize(128, 128);
/*  53 */     this.leg1.mirror = true;
/*  54 */     setRotation(this.leg1, 0.0F, 0.5759587F, 0.1919862F);
/*  55 */     this.leg1part2 = new ModelRenderer(this, 37, 5);
/*  56 */     this.leg1part2.addBox(13.01F, -1.01F, -1.0F, 2, 5, 2);
/*  57 */     this.leg1part2.setRotationPoint(4.0F, 18.0F, -2.0F);
/*  58 */     this.leg1part2.setTextureSize(128, 128);
/*  59 */     this.leg1part2.mirror = true;
/*  60 */     setRotation(this.leg1part2, 0.0F, 0.5759587F, 0.1919862F);
/*  61 */     this.leg2 = new ModelRenderer(this, 65, 0);
/*  62 */     this.leg2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2);
/*  63 */     this.leg2.setRotationPoint(4.0F, 18.0F, 2.0F);
/*  64 */     this.leg2.setTextureSize(128, 128);
/*  65 */     this.leg2.mirror = true;
/*  66 */     setRotation(this.leg2, 0.0F, -0.5759587F, 0.1919862F);
/*  67 */     this.leg2part2 = new ModelRenderer(this, 37, 5);
/*  68 */     this.leg2part2.addBox(13.01F, -1.01F, -1.0F, 2, 5, 2);
/*  69 */     this.leg2part2.setRotationPoint(4.0F, 18.0F, 2.0F);
/*  70 */     this.leg2part2.setTextureSize(128, 128);
/*  71 */     this.leg2part2.mirror = true;
/*  72 */     setRotation(this.leg2part2, 0.0F, -0.5759587F, 0.1919862F);
/*  73 */     this.leg3 = new ModelRenderer(this, 28, 0);
/*  74 */     this.leg3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2);
/*  75 */     this.leg3.setRotationPoint(-4.0F, 18.0F, -2.0F);
/*  76 */     this.leg3.setTextureSize(128, 128);
/*  77 */     this.leg3.mirror = true;
/*  78 */     setRotation(this.leg3, 0.0F, -0.5759587F, -0.1919862F);
/*  79 */     this.leg3part2 = new ModelRenderer(this, 28, 5);
/*  80 */     this.leg3part2.addBox(-15.01F, -1.01F, -1.0F, 2, 5, 2);
/*  81 */     this.leg3part2.setRotationPoint(-4.0F, 18.0F, -2.0F);
/*  82 */     this.leg3part2.setTextureSize(128, 128);
/*  83 */     this.leg3part2.mirror = true;
/*  84 */     setRotation(this.leg3part2, 0.0F, -0.5759587F, -0.1919862F);
/*  85 */     this.leg4 = new ModelRenderer(this, 28, 0);
/*  86 */     this.leg4.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2);
/*  87 */     this.leg4.setRotationPoint(-4.0F, 18.0F, 2.0F);
/*  88 */     this.leg4.setTextureSize(128, 128);
/*  89 */     this.leg4.mirror = true;
/*  90 */     setRotation(this.leg4, 0.0F, 0.5759587F, -0.1919862F);
/*  91 */     this.leg4part2 = new ModelRenderer(this, 28, 5);
/*  92 */     this.leg4part2.addBox(-15.01F, -1.01F, -1.0F, 2, 5, 2);
/*  93 */     this.leg4part2.setRotationPoint(-4.0F, 18.0F, 2.0F);
/*  94 */     this.leg4part2.setTextureSize(128, 128);
/*  95 */     this.leg4part2.mirror = true;
/*  96 */     setRotation(this.leg4part2, 0.0F, 0.5759587F, -0.1919862F);
/*  97 */     this.tailseg1 = new ModelRenderer(this, 0, 13);
/*  98 */     this.tailseg1.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 7);
/*  99 */     this.tailseg1.setRotationPoint(0.0F, 17.0F, 3.0F);
/* 100 */     this.tailseg1.setTextureSize(128, 128);
/* 101 */     this.tailseg1.mirror = true;
/* 102 */     setRotation(this.tailseg1, -0.5576792F, 0.0F, 0.0F);
/* 103 */     this.tailseg2 = new ModelRenderer(this, 0, 0);
/* 104 */     this.tailseg2.addBox(-1.0F, 3.0F, 7.0F, 2, 1, 11);
/* 105 */     this.tailseg2.setRotationPoint(0.0F, 17.0F, 3.0F);
/* 106 */     this.tailseg2.setTextureSize(128, 128);
/* 107 */     this.tailseg2.mirror = true;
/* 108 */     setRotation(this.tailseg2, -0.0349066F, 0.0F, 0.0F);
/* 109 */     this.tailseg3 = new ModelRenderer(this, 0, 24);
/* 110 */     this.tailseg3.addBox(-1.5F, 1.0F, 6.0F, 3, 2, 2);
/* 111 */     this.tailseg3.setRotationPoint(0.0F, 17.0F, 3.0F);
/* 112 */     this.tailseg3.setTextureSize(128, 128);
/* 113 */     this.tailseg3.mirror = true;
/* 114 */     setRotation(this.tailseg3, -0.2230717F, 0.0F, 0.0F);
/* 115 */     this.pincer1 = new ModelRenderer(this, 26, 30);
/* 116 */     this.pincer1.addBox(-0.5F, -0.5F, -5.0F, 1, 1, 5);
/* 117 */     this.pincer1.setRotationPoint(-3.0F, 19.0F, -3.0F);
/* 118 */     this.pincer1.setTextureSize(128, 128);
/* 119 */     this.pincer1.mirror = true;
/* 120 */     setRotation(this.pincer1, 0.0F, -0.2230717F, 0.0F);
/* 121 */     this.pincer1part2 = new ModelRenderer(this, 26, 30);
/* 122 */     this.pincer1part2.addBox(-0.5F, -0.5F, -5.01F, 2, 1, 0);
/* 123 */     this.pincer1part2.setRotationPoint(-3.0F, 19.0F, -3.0F);
/* 124 */     this.pincer1part2.setTextureSize(128, 128);
/* 125 */     this.pincer1part2.mirror = true;
/* 126 */     setRotation(this.pincer1part2, 0.0F, -0.2230717F, 0.0F);
/* 127 */     this.pincer2 = new ModelRenderer(this, 26, 30);
/* 128 */     this.pincer2.addBox(-0.5F, -0.5F, -5.0F, 1, 1, 5);
/* 129 */     this.pincer2.setRotationPoint(3.0F, 19.0F, -3.0F);
/* 130 */     this.pincer2.setTextureSize(128, 128);
/* 131 */     this.pincer2.mirror = true;
/* 132 */     setRotation(this.pincer2, 0.0F, 0.2230705F, 0.0F);
/* 133 */     this.pincer2part2 = new ModelRenderer(this, 26, 28);
/* 134 */     this.pincer2part2.addBox(-1.5F, -0.5F, -5.01F, 2, 1, 0);
/* 135 */     this.pincer2part2.setRotationPoint(3.0F, 19.0F, -3.0F);
/* 136 */     this.pincer2part2.setTextureSize(128, 128);
/* 137 */     this.pincer2part2.mirror = true;
/* 138 */     setRotation(this.pincer2part2, 0.0F, 0.2230705F, 0.0F);
/* 139 */     this.spike1 = new ModelRenderer(this, 26, 13);
/* 140 */     this.spike1.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 6);
/* 141 */     this.spike1.setRotationPoint(-3.0F, 16.0F, -2.0F);
/* 142 */     this.spike1.setTextureSize(128, 128);
/* 143 */     this.spike1.mirror = true;
/* 144 */     setRotation(this.spike1, 0.7063936F, -0.2602503F, 0.0F);
/* 145 */     this.spike2 = new ModelRenderer(this, 26, 13);
/* 146 */     this.spike2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 6);
/* 147 */     this.spike2.setRotationPoint(-1.0F, 16.0F, 1.0F);
/* 148 */     this.spike2.setTextureSize(128, 128);
/* 149 */     this.spike2.mirror = true;
/* 150 */     setRotation(this.spike2, 0.7063936F, -0.111544F, 0.0F);
/* 151 */     this.spike3 = new ModelRenderer(this, 26, 13);
/* 152 */     this.spike3.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 6);
/* 153 */     this.spike3.setRotationPoint(1.0F, 16.0F, 1.0F);
/* 154 */     this.spike3.setTextureSize(128, 128);
/* 155 */     this.spike3.mirror = true;
/* 156 */     setRotation(this.spike3, 0.7063936F, 0.1115358F, 0.0F);
/* 157 */     this.spike4 = new ModelRenderer(this, 26, 13);
/* 158 */     this.spike4.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 6);
/* 159 */     this.spike4.setRotationPoint(3.0F, 16.0F, -2.0F);
/* 160 */     this.spike4.setTextureSize(128, 128);
/* 161 */     this.spike4.mirror = true;
/* 162 */     setRotation(this.spike4, 0.7063936F, 0.260246F, 0.0F);
/* 163 */     this.spike5 = new ModelRenderer(this, 26, 13);
/* 164 */     this.spike5.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 6);
/* 165 */     this.spike5.setRotationPoint(0.0F, 16.0F, -3.0F);
/* 166 */     this.spike5.setTextureSize(128, 128);
/* 167 */     this.spike5.mirror = true;
/* 168 */     setRotation(this.spike5, 0.7063936F, 0.0F, 0.0F);
/* 169 */     this.insides1 = new ModelRenderer(this, 0, 30);
/* 170 */     this.insides1.addBox(-2.0F, -3.0F, -3.0F, 4, 4, 0);
/* 171 */     this.insides1.setRotationPoint(0.0F, 20.0F, 0.0F);
/* 172 */     this.insides1.setTextureSize(128, 128);
/* 173 */     this.insides1.mirror = true;
/* 174 */     setRotation(this.insides1, 0.0F, 0.0F, 0.0F);
/* 175 */     this.insides2 = new ModelRenderer(this, -1, 29);
/* 176 */     this.insides2.addBox(-2.0F, -3.0F, -4.0F, 4, 0, 1);
/* 177 */     this.insides2.setRotationPoint(0.0F, 20.0F, 0.0F);
/* 178 */     this.insides2.setTextureSize(128, 128);
/* 179 */     this.insides2.mirror = true;
/* 180 */     setRotation(this.insides2, 0.0F, 0.0F, 0.0F);
/* 181 */     this.insides3 = new ModelRenderer(this, -1, 29);
/* 182 */     this.insides3.addBox(-2.0F, 1.0F, -4.0F, 4, 0, 1);
/* 183 */     this.insides3.setRotationPoint(0.0F, 20.0F, 0.0F);
/* 184 */     this.insides3.setTextureSize(128, 128);
/* 185 */     this.insides3.mirror = true;
/* 186 */     setRotation(this.insides3, 0.0F, 0.0F, 0.0F);
/* 187 */     this.insides4 = new ModelRenderer(this, 0, 29);
/* 188 */     this.insides4.addBox(-2.0F, -3.0F, -4.0F, 0, 4, 1);
/* 189 */     this.insides4.setRotationPoint(0.0F, 20.0F, 0.0F);
/* 190 */     this.insides4.setTextureSize(128, 128);
/* 191 */     this.insides4.mirror = true;
/* 192 */     setRotation(this.insides4, 0.0F, 0.0F, 0.0F);
/* 193 */     this.insides5 = new ModelRenderer(this, 0, 29);
/* 194 */     this.insides5.addBox(2.0F, -3.0F, -4.0F, 0, 4, 1);
/* 195 */     this.insides5.setRotationPoint(0.0F, 20.0F, 0.0F);
/* 196 */     this.insides5.setTextureSize(128, 128);
/* 197 */     this.insides5.mirror = true;
/* 198 */     setRotation(this.insides5, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 204 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 205 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     float newangle = MathHelper.cos(f2 * 1.25F) * 3.1415927F * 0.35F * f1;
/* 212 */     this.leg1.rotateAngleY = 0.576F + newangle;
/* 213 */     this.leg1part2.rotateAngleY = this.leg1.rotateAngleY;
/* 214 */     this.leg2.rotateAngleY = -0.576F - newangle;
/* 215 */     this.leg2part2.rotateAngleY = this.leg2.rotateAngleY;
/* 216 */     this.leg3.rotateAngleY = -0.576F - newangle;
/* 217 */     this.leg3part2.rotateAngleY = this.leg3.rotateAngleY;
/* 218 */     this.leg4.rotateAngleY = 0.576F + newangle;
/* 219 */     this.leg4part2.rotateAngleY = this.leg4.rotateAngleY;
/*     */     
/* 221 */     newangle = MathHelper.cos(f2 * 0.48F) * 3.1415927F * 0.15F;
/* 222 */     this.pincer1.rotateAngleY = newangle;
/* 223 */     this.pincer1part2.rotateAngleY = newangle;
/* 224 */     this.pincer2.rotateAngleY = -newangle;
/* 225 */     this.pincer2part2.rotateAngleY = -newangle;
/*     */     
/* 227 */     newangle = MathHelper.cos(f2 * 0.11F) * 3.1415927F * 0.25F;
/* 228 */     newangle = Math.abs(newangle);
/* 229 */     this.tailseg1.rotateAngleX = -0.55F + newangle;
/* 230 */     this.tailseg3.rotateAngleX = -0.22F + newangle;
/* 231 */     this.tailseg2.rotateAngleX = newangle;
/*     */     
/* 233 */     newangle = MathHelper.cos(f2 * 0.81F) * 3.1415927F * 0.08F;
/* 234 */     this.spike1.rotateAngleX = 0.7F + newangle;
/* 235 */     newangle = MathHelper.cos(f2 * 0.87F) * 3.1415927F * 0.08F;
/* 236 */     this.spike2.rotateAngleX = 0.7F + newangle;
/* 237 */     newangle = MathHelper.cos(f2 * 0.99F) * 3.1415927F * 0.08F;
/* 238 */     this.spike3.rotateAngleX = 0.7F + newangle;
/* 239 */     newangle = MathHelper.cos(f2 * 0.103F) * 3.1415927F * 0.08F;
/* 240 */     this.spike4.rotateAngleX = 0.7F + newangle;
/* 241 */     newangle = MathHelper.cos(f2 * 0.107F) * 3.1415927F * 0.08F;
/* 242 */     this.spike5.rotateAngleX = 0.7F + newangle;
/*     */     
/* 244 */     newangle = MathHelper.cos(f2 * 1.11F) * 3.1415927F * 0.08F;
/* 245 */     this.spike1.rotateAngleY = newangle;
/* 246 */     newangle = MathHelper.cos(f2 * 1.17F) * 3.1415927F * 0.08F;
/* 247 */     this.spike2.rotateAngleY = newangle;
/* 248 */     newangle = MathHelper.cos(f2 * 1.25F) * 3.1415927F * 0.08F;
/* 249 */     this.spike3.rotateAngleY = newangle;
/* 250 */     newangle = MathHelper.cos(f2 * 1.28F) * 3.1415927F * 0.08F;
/* 251 */     this.spike4.rotateAngleY = newangle;
/* 252 */     newangle = MathHelper.cos(f2 * 1.31F) * 3.1415927F * 0.08F;
/* 253 */     this.spike5.rotateAngleY = newangle;
/*     */     
/* 255 */     newangle = MathHelper.cos(f2 * 1.41F) * 3.1415927F * 0.08F;
/* 256 */     this.spike1.rotateAngleZ = newangle;
/* 257 */     newangle = MathHelper.cos(f2 * 1.47F) * 3.1415927F * 0.08F;
/* 258 */     this.spike2.rotateAngleZ = newangle;
/* 259 */     newangle = MathHelper.cos(f2 * 1.55F) * 3.1415927F * 0.08F;
/* 260 */     this.spike3.rotateAngleZ = newangle;
/* 261 */     newangle = MathHelper.cos(f2 * 1.58F) * 3.1415927F * 0.08F;
/* 262 */     this.spike4.rotateAngleZ = newangle;
/* 263 */     newangle = MathHelper.cos(f2 * 1.61F) * 3.1415927F * 0.08F;
/* 264 */     this.spike5.rotateAngleZ = newangle;
/*     */ 
/*     */     
/* 267 */     this.body.render(f5);
/* 268 */     this.leg1.render(f5);
/* 269 */     this.leg1part2.render(f5);
/* 270 */     this.leg2.render(f5);
/* 271 */     this.leg2part2.render(f5);
/* 272 */     this.leg3.render(f5);
/* 273 */     this.leg3part2.render(f5);
/* 274 */     this.leg4.render(f5);
/* 275 */     this.leg4part2.render(f5);
/* 276 */     this.tailseg1.render(f5);
/* 277 */     this.tailseg2.render(f5);
/* 278 */     this.tailseg3.render(f5);
/* 279 */     this.pincer1.render(f5);
/* 280 */     this.pincer1part2.render(f5);
/* 281 */     this.pincer2.render(f5);
/* 282 */     this.pincer2part2.render(f5);
/* 283 */     this.spike1.render(f5);
/* 284 */     this.spike2.render(f5);
/* 285 */     this.spike3.render(f5);
/* 286 */     this.spike4.render(f5);
/* 287 */     this.spike5.render(f5);
/* 288 */     this.insides1.render(f5);
/* 289 */     this.insides2.render(f5);
/* 290 */     this.insides3.render(f5);
/* 291 */     this.insides4.render(f5);
/* 292 */     this.insides5.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 297 */     model.rotateAngleX = x;
/* 298 */     model.rotateAngleY = y;
/* 299 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 304 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelCreepingHorror.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */