/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Mantis;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelMantis
/*     */   extends ModelBase {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer lfleg1;
/*     */   
/*     */   ModelRenderer lfleg2;
/*     */   
/*     */   ModelRenderer lfleg3;
/*     */   ModelRenderer lfleg4;
/*     */   ModelRenderer lrleg1;
/*     */   ModelRenderer lrleg2;
/*     */   ModelRenderer lrleg3;
/*     */   ModelRenderer lrleg4;
/*     */   ModelRenderer abdomen;
/*     */   ModelRenderer thorax;
/*     */   ModelRenderer neck1;
/*     */   ModelRenderer neck2;
/*     */   ModelRenderer head1;
/*     */   ModelRenderer head2;
/*     */   ModelRenderer leye;
/*     */   ModelRenderer reye;
/*     */   ModelRenderer lantenna;
/*     */   ModelRenderer rantenna;
/*     */   ModelRenderer larm1;
/*     */   ModelRenderer larm2;
/*     */   ModelRenderer larm3;
/*     */   ModelRenderer lfwing;
/*     */   ModelRenderer rfwing;
/*     */   ModelRenderer lrwing;
/*     */   ModelRenderer rrwing;
/*     */   ModelRenderer rarm1;
/*     */   ModelRenderer rarm2;
/*     */   ModelRenderer rarm3;
/*     */   ModelRenderer rlfleg3;
/*     */   ModelRenderer rfleg4;
/*     */   ModelRenderer rfleg2;
/*     */   ModelRenderer rfleg1;
/*     */   ModelRenderer rrleg3;
/*     */   ModelRenderer rrleg4;
/*     */   ModelRenderer rrleg2;
/*     */   ModelRenderer rrleg1;
/*     */   
/*     */   public ModelMantis(float f1) {
/*  53 */     this.wingspeed = f1;
/*     */     
/*  55 */     this.textureWidth = 256;
/*  56 */     this.textureHeight = 256;
/*     */ 
/*     */     
/*  59 */     this.lfleg1 = new ModelRenderer(this, 28, 35);
/*  60 */     this.lfleg1.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
/*  61 */     this.lfleg1.setRotationPoint(27.0F, 16.0F, -3.0F);
/*  62 */     this.lfleg1.setTextureSize(256, 256);
/*  63 */     this.lfleg1.mirror = true;
/*  64 */     setRotation(this.lfleg1, 0.0F, 0.0F, -0.6283185F);
/*  65 */     this.lfleg2 = new ModelRenderer(this, 0, 32);
/*  66 */     this.lfleg2.addBox(0.0F, 0.0F, 0.0F, 1, 22, 1);
/*  67 */     this.lfleg2.setRotationPoint(21.0F, -5.0F, -3.0F);
/*  68 */     this.lfleg2.setTextureSize(256, 256);
/*  69 */     this.lfleg2.mirror = true;
/*  70 */     setRotation(this.lfleg2, 0.0F, 0.0F, -0.2792527F);
/*  71 */     this.lfleg3 = new ModelRenderer(this, 64, 2);
/*  72 */     this.lfleg3.addBox(0.0F, 0.0F, 0.0F, 20, 1, 1);
/*  73 */     this.lfleg3.setRotationPoint(2.0F, -5.0F, 0.0F);
/*  74 */     this.lfleg3.setTextureSize(256, 256);
/*  75 */     this.lfleg3.mirror = true;
/*  76 */     setRotation(this.lfleg3, 0.0F, 0.1570796F, 0.0F);
/*  77 */     this.lfleg4 = new ModelRenderer(this, 64, 20);
/*  78 */     this.lfleg4.addBox(15.0F, 0.0F, -2.0F, 4, 1, 5);
/*  79 */     this.lfleg4.setRotationPoint(2.0F, -5.0F, 0.0F);
/*  80 */     this.lfleg4.setTextureSize(256, 256);
/*  81 */     this.lfleg4.mirror = true;
/*  82 */     setRotation(this.lfleg4, 0.0F, 0.1570796F, 0.0F);
/*  83 */     this.lrleg1 = new ModelRenderer(this, 35, 35);
/*  84 */     this.lrleg1.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
/*  85 */     this.lrleg1.setRotationPoint(32.0F, 18.0F, 11.0F);
/*  86 */     this.lrleg1.setTextureSize(256, 256);
/*  87 */     this.lrleg1.mirror = true;
/*  88 */     setRotation(this.lrleg1, 0.0F, 0.0F, -0.8726646F);
/*  89 */     this.lrleg2 = new ModelRenderer(this, 14, 32);
/*  90 */     this.lrleg2.addBox(0.0F, 0.0F, 0.0F, 1, 22, 1);
/*  91 */     this.lrleg2.setRotationPoint(21.0F, 0.0F, 11.0F);
/*  92 */     this.lrleg2.setTextureSize(256, 256);
/*  93 */     this.lrleg2.mirror = true;
/*  94 */     setRotation(this.lrleg2, 0.0F, 0.0F, -0.5410521F);
/*  95 */     this.lrleg3 = new ModelRenderer(this, 64, 11);
/*  96 */     this.lrleg3.addBox(0.0F, 0.0F, 0.0F, 20, 1, 1);
/*  97 */     this.lrleg3.setRotationPoint(2.0F, 0.0F, 8.0F);
/*  98 */     this.lrleg3.setTextureSize(256, 256);
/*  99 */     this.lrleg3.mirror = true;
/* 100 */     setRotation(this.lrleg3, 0.0F, -0.1570796F, 0.0F);
/* 101 */     this.lrleg4 = new ModelRenderer(this, 64, 36);
/* 102 */     this.lrleg4.addBox(15.0F, 0.0F, -2.0F, 4, 1, 5);
/* 103 */     this.lrleg4.setRotationPoint(2.0F, 0.0F, 8.0F);
/* 104 */     this.lrleg4.setTextureSize(256, 256);
/* 105 */     this.lrleg4.mirror = true;
/* 106 */     setRotation(this.lrleg4, 0.0F, -0.1570796F, 0.0F);
/* 107 */     this.abdomen = new ModelRenderer(this, 118, 0);
/* 108 */     this.abdomen.addBox(0.0F, 0.0F, 0.0F, 9, 5, 53);
/* 109 */     this.abdomen.setRotationPoint(-4.0F, -11.0F, 0.0F);
/* 110 */     this.abdomen.setTextureSize(256, 256);
/* 111 */     this.abdomen.mirror = true;
/* 112 */     setRotation(this.abdomen, -0.5061455F, 0.0F, 0.0F);
/* 113 */     this.thorax = new ModelRenderer(this, 145, 62);
/* 114 */     this.thorax.addBox(0.0F, 0.0F, 0.0F, 15, 3, 13);
/* 115 */     this.thorax.setRotationPoint(-7.0F, -14.0F, -12.0F);
/* 116 */     this.thorax.setTextureSize(256, 256);
/* 117 */     this.thorax.mirror = true;
/* 118 */     setRotation(this.thorax, -0.2443461F, 0.0F, 0.0F);
/* 119 */     this.neck1 = new ModelRenderer(this, 145, 82);
/* 120 */     this.neck1.addBox(0.0F, 0.0F, 0.0F, 9, 1, 15);
/* 121 */     this.neck1.setRotationPoint(-4.0F, -15.0F, -27.0F);
/* 122 */     this.neck1.setTextureSize(256, 256);
/* 123 */     this.neck1.mirror = true;
/* 124 */     setRotation(this.neck1, -0.0698132F, 0.0F, 0.0F);
/* 125 */     this.neck2 = new ModelRenderer(this, 40, 150);
/* 126 */     this.neck2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2);
/* 127 */     this.neck2.setRotationPoint(-1.0F, -15.0F, -29.0F);
/* 128 */     this.neck2.setTextureSize(256, 256);
/* 129 */     this.neck2.mirror = true;
/* 130 */     setRotation(this.neck2, 0.0F, 0.0F, 0.0F);
/* 131 */     this.head1 = new ModelRenderer(this, 0, 150);
/* 132 */     this.head1.addBox(0.0F, 0.0F, 0.0F, 2, 6, 1);
/* 133 */     this.head1.setRotationPoint(0.0F, -16.0F, -30.0F);
/* 134 */     this.head1.setTextureSize(256, 256);
/* 135 */     this.head1.mirror = true;
/* 136 */     setRotation(this.head1, 0.0F, 0.0F, 0.1396263F);
/* 137 */     this.head2 = new ModelRenderer(this, 10, 150);
/* 138 */     this.head2.addBox(-2.0F, 0.0F, 0.0F, 2, 6, 1);
/* 139 */     this.head2.setRotationPoint(0.0F, -16.0F, -30.0F);
/* 140 */     this.head2.setTextureSize(256, 256);
/* 141 */     this.head2.mirror = true;
/* 142 */     setRotation(this.head2, 0.0F, 0.0F, -0.1745329F);
/* 143 */     this.leye = new ModelRenderer(this, 20, 150);
/* 144 */     this.leye.addBox(1.0F, 0.0F, -0.5F, 2, 2, 1);
/* 145 */     this.leye.setRotationPoint(0.0F, -16.0F, -30.0F);
/* 146 */     this.leye.setTextureSize(256, 256);
/* 147 */     this.leye.mirror = true;
/* 148 */     setRotation(this.leye, 0.0F, 0.0F, 0.1396263F);
/* 149 */     this.reye = new ModelRenderer(this, 30, 150);
/* 150 */     this.reye.addBox(-3.0F, 0.0F, -0.5F, 2, 2, 1);
/* 151 */     this.reye.setRotationPoint(0.0F, -16.0F, -30.0F);
/* 152 */     this.reye.setTextureSize(256, 256);
/* 153 */     this.reye.mirror = true;
/* 154 */     setRotation(this.reye, 0.0F, 0.0F, -0.1745329F);
/* 155 */     this.lantenna = new ModelRenderer(this, 53, 150);
/* 156 */     this.lantenna.addBox(0.0F, -20.0F, 0.0F, 1, 20, 1);
/* 157 */     this.lantenna.setRotationPoint(0.0F, -16.0F, -30.0F);
/* 158 */     this.lantenna.setTextureSize(256, 256);
/* 159 */     this.lantenna.mirror = true;
/* 160 */     setRotation(this.lantenna, 0.0F, 0.0F, 0.2792527F);
/* 161 */     this.rantenna = new ModelRenderer(this, 60, 150);
/* 162 */     this.rantenna.addBox(-1.0F, -20.0F, 0.0F, 1, 20, 1);
/* 163 */     this.rantenna.setRotationPoint(0.0F, -16.0F, -30.0F);
/* 164 */     this.rantenna.setTextureSize(256, 256);
/* 165 */     this.rantenna.mirror = true;
/* 166 */     setRotation(this.rantenna, 0.0F, 0.0F, -0.2792527F);
/* 167 */     this.larm1 = new ModelRenderer(this, 51, 0);
/* 168 */     this.larm1.addBox(0.0F, 0.0F, -1.0F, 1, 23, 4);
/* 169 */     this.larm1.setRotationPoint(2.0F, -14.0F, -23.0F);
/* 170 */     this.larm1.setTextureSize(256, 256);
/* 171 */     this.larm1.mirror = true;
/* 172 */     setRotation(this.larm1, 0.0349066F, 0.0F, 0.0F);
/* 173 */     this.larm2 = new ModelRenderer(this, 30, 0);
/* 174 */     this.larm2.addBox(0.0F, -18.0F, -2.0F, 1, 18, 2);
/* 175 */     this.larm2.setRotationPoint(2.0F, 8.0F, -22.0F);
/* 176 */     this.larm2.setTextureSize(256, 256);
/* 177 */     this.larm2.mirror = true;
/* 178 */     setRotation(this.larm2, 0.5585054F, 0.0F, 0.0F);
/* 179 */     this.larm3 = new ModelRenderer(this, 16, 0);
/* 180 */     this.larm3.addBox(0.0F, 0.0F, 0.0F, 1, 21, 1);
/* 181 */     this.larm3.setRotationPoint(2.0F, -7.0F, -33.0F);
/* 182 */     this.larm3.setTextureSize(256, 256);
/* 183 */     this.larm3.mirror = true;
/* 184 */     setRotation(this.larm3, 0.0F, 0.0F, 0.0F);
/* 185 */     this.lfwing = new ModelRenderer(this, 0, 67);
/* 186 */     this.lfwing.addBox(0.0F, 0.0F, 0.0F, 48, 1, 12);
/* 187 */     this.lfwing.setRotationPoint(2.0F, -11.0F, 0.0F);
/* 188 */     this.lfwing.setTextureSize(256, 256);
/* 189 */     this.lfwing.mirror = true;
/* 190 */     setRotation(this.lfwing, -0.2268928F, 0.0F, -0.6981317F);
/* 191 */     this.rfwing = new ModelRenderer(this, 0, 83);
/* 192 */     this.rfwing.addBox(-48.0F, 0.0F, 0.0F, 48, 1, 12);
/* 193 */     this.rfwing.setRotationPoint(-1.0F, -11.0F, 0.0F);
/* 194 */     this.rfwing.setTextureSize(256, 256);
/* 195 */     this.rfwing.mirror = true;
/* 196 */     setRotation(this.rfwing, -0.2268928F, 0.0F, 0.6981317F);
/* 197 */     this.lrwing = new ModelRenderer(this, 0, 100);
/* 198 */     this.lrwing.addBox(0.0F, 0.0F, 0.0F, 42, 1, 17);
/* 199 */     this.lrwing.setRotationPoint(2.0F, -6.0F, 10.0F);
/* 200 */     this.lrwing.setTextureSize(256, 256);
/* 201 */     this.lrwing.mirror = true;
/* 202 */     setRotation(this.lrwing, -0.2268928F, 0.0F, -0.3490659F);
/* 203 */     this.rrwing = new ModelRenderer(this, 0, 122);
/* 204 */     this.rrwing.addBox(-42.0F, 0.0F, 0.0F, 42, 1, 17);
/* 205 */     this.rrwing.setRotationPoint(-1.0F, -6.0F, 10.0F);
/* 206 */     this.rrwing.setTextureSize(256, 256);
/* 207 */     this.rrwing.mirror = true;
/* 208 */     setRotation(this.rrwing, -0.2268928F, 0.0F, 0.3490659F);
/* 209 */     this.rarm1 = new ModelRenderer(this, 38, 0);
/* 210 */     this.rarm1.addBox(0.0F, 0.0F, -1.0F, 1, 23, 4);
/* 211 */     this.rarm1.setRotationPoint(-1.0F, -14.0F, -23.0F);
/* 212 */     this.rarm1.setTextureSize(256, 256);
/* 213 */     this.rarm1.mirror = true;
/* 214 */     setRotation(this.rarm1, 0.0349066F, 0.0F, 0.0F);
/* 215 */     this.rarm2 = new ModelRenderer(this, 22, 0);
/* 216 */     this.rarm2.addBox(0.0F, -18.0F, -2.0F, 1, 18, 2);
/* 217 */     this.rarm2.setRotationPoint(-1.0F, 8.0F, -22.0F);
/* 218 */     this.rarm2.setTextureSize(256, 256);
/* 219 */     this.rarm2.mirror = true;
/* 220 */     setRotation(this.rarm2, 0.5585054F, 0.0F, 0.0F);
/* 221 */     this.rarm3 = new ModelRenderer(this, 10, 0);
/* 222 */     this.rarm3.addBox(0.0F, 0.0F, 0.0F, 1, 21, 1);
/* 223 */     this.rarm3.setRotationPoint(-1.0F, -7.0F, -33.0F);
/* 224 */     this.rarm3.setTextureSize(256, 256);
/* 225 */     this.rarm3.mirror = true;
/* 226 */     setRotation(this.rarm3, 0.0F, 0.0F, 0.0F);
/* 227 */     this.rlfleg3 = new ModelRenderer(this, 64, 6);
/* 228 */     this.rlfleg3.addBox(-20.0F, 0.0F, 0.0F, 20, 1, 1);
/* 229 */     this.rlfleg3.setRotationPoint(-1.0F, -5.0F, 0.0F);
/* 230 */     this.rlfleg3.setTextureSize(256, 256);
/* 231 */     this.rlfleg3.mirror = true;
/* 232 */     setRotation(this.rlfleg3, 0.0F, -0.1570796F, 0.0F);
/* 233 */     this.rfleg4 = new ModelRenderer(this, 64, 28);
/* 234 */     this.rfleg4.addBox(-19.0F, 0.0F, -2.0F, 4, 1, 5);
/* 235 */     this.rfleg4.setRotationPoint(-1.0F, -5.0F, 0.0F);
/* 236 */     this.rfleg4.setTextureSize(256, 256);
/* 237 */     this.rfleg4.mirror = true;
/* 238 */     setRotation(this.rfleg4, 0.0F, -0.1570796F, 0.0F);
/* 239 */     this.rfleg2 = new ModelRenderer(this, 7, 32);
/* 240 */     this.rfleg2.addBox(0.0F, 0.0F, 0.0F, 1, 22, 1);
/* 241 */     this.rfleg2.setRotationPoint(-21.0F, -5.0F, -3.0F);
/* 242 */     this.rfleg2.setTextureSize(256, 256);
/* 243 */     this.rfleg2.mirror = true;
/* 244 */     setRotation(this.rfleg2, 0.0F, 0.0F, 0.2792527F);
/* 245 */     this.rfleg1 = new ModelRenderer(this, 42, 35);
/* 246 */     this.rfleg1.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
/* 247 */     this.rfleg1.setRotationPoint(-27.0F, 16.0F, -3.0F);
/* 248 */     this.rfleg1.setTextureSize(256, 256);
/* 249 */     this.rfleg1.mirror = true;
/* 250 */     setRotation(this.rfleg1, 0.0F, 0.0F, 0.6283185F);
/* 251 */     this.rrleg3 = new ModelRenderer(this, 64, 16);
/* 252 */     this.rrleg3.addBox(-20.0F, 0.0F, 0.0F, 20, 1, 1);
/* 253 */     this.rrleg3.setRotationPoint(-1.0F, 0.0F, 8.0F);
/* 254 */     this.rrleg3.setTextureSize(256, 256);
/* 255 */     this.rrleg3.mirror = true;
/* 256 */     setRotation(this.rrleg3, 0.0F, 0.1570796F, 0.0F);
/* 257 */     this.rrleg4 = new ModelRenderer(this, 64, 44);
/* 258 */     this.rrleg4.addBox(-19.0F, 0.0F, -2.0F, 4, 1, 5);
/* 259 */     this.rrleg4.setRotationPoint(-1.0F, 0.0F, 8.0F);
/* 260 */     this.rrleg4.setTextureSize(256, 256);
/* 261 */     this.rrleg4.mirror = true;
/* 262 */     setRotation(this.rrleg4, 0.0F, 0.1570796F, 0.0F);
/* 263 */     this.rrleg2 = new ModelRenderer(this, 21, 32);
/* 264 */     this.rrleg2.addBox(0.0F, 0.0F, 0.0F, 1, 22, 1);
/* 265 */     this.rrleg2.setRotationPoint(-21.0F, 0.0F, 11.0F);
/* 266 */     this.rrleg2.setTextureSize(256, 256);
/* 267 */     this.rrleg2.mirror = true;
/* 268 */     setRotation(this.rrleg2, 0.0F, 0.0F, 0.5410521F);
/* 269 */     this.rrleg1 = new ModelRenderer(this, 49, 35);
/* 270 */     this.rrleg1.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
/* 271 */     this.rrleg1.setRotationPoint(-32.0F, 18.0F, 11.0F);
/* 272 */     this.rrleg1.setTextureSize(256, 256);
/* 273 */     this.rrleg1.mirror = true;
/* 274 */     setRotation(this.rrleg1, 0.0F, 0.0F, 0.8726646F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 279 */     float a1, newangle = 0.0F;
/*     */     
/* 281 */     Mantis b = (Mantis)entity;
/*     */     
/* 283 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 284 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */     
/* 288 */     newangle = MathHelper.cos(f2 * 0.9F * this.wingspeed) * 3.1415927F * 0.25F;
/* 289 */     this.lfwing.rotateAngleZ = -0.698F - newangle;
/* 290 */     this.rfwing.rotateAngleZ = 0.698F + newangle;
/* 291 */     newangle = MathHelper.cos(f2 * 0.9F * this.wingspeed) * 3.1415927F * 0.35F;
/* 292 */     this.lrwing.rotateAngleZ = -0.349F + newangle;
/* 293 */     this.rrwing.rotateAngleZ = 0.349F - newangle;
/*     */ 
/*     */     
/* 296 */     if (b.getAttacking() == 0) {
/* 297 */       newangle = MathHelper.cos(f2 * 0.051F * this.wingspeed) * 3.1415927F * 0.013F;
/* 298 */       a1 = -0.2F;
/*     */     } else {
/* 300 */       newangle = MathHelper.cos(f2 * 0.51F * this.wingspeed) * 3.1415927F * 0.25F;
/* 301 */       a1 = -0.698F;
/*     */     } 
/* 303 */     this.larm1.rotateAngleX = a1 + newangle;
/* 304 */     this.larm2.rotationPointZ = (float)((this.larm1.rotationPointZ + 1.0F) + Math.sin(this.larm1.rotateAngleX) * 22.0D);
/* 305 */     this.larm2.rotationPointY = (float)(this.larm1.rotationPointY + Math.cos(this.larm1.rotateAngleX) * 22.0D);
/* 306 */     this.larm2.rotateAngleX = -a1 - newangle;
/* 307 */     this.larm3.rotationPointZ = (float)((this.larm2.rotationPointZ + 1.0F) - Math.sin(this.larm2.rotateAngleX) * 17.0D);
/* 308 */     this.larm3.rotationPointY = (float)(this.larm2.rotationPointY - Math.cos(this.larm2.rotateAngleX) * 17.0D);
/* 309 */     this.larm3.rotateAngleX = a1 + newangle;
/*     */     
/* 311 */     this.rarm1.rotateAngleX = a1 - newangle;
/* 312 */     this.rarm2.rotationPointZ = (float)((this.rarm1.rotationPointZ + 1.0F) + Math.sin(this.rarm1.rotateAngleX) * 22.0D);
/* 313 */     this.rarm2.rotationPointY = (float)(this.rarm1.rotationPointY + Math.cos(this.rarm1.rotateAngleX) * 22.0D);
/* 314 */     this.rarm2.rotateAngleX = -a1 + newangle;
/* 315 */     this.rarm3.rotationPointZ = (float)((this.rarm2.rotationPointZ + 1.0F) - Math.sin(this.rarm2.rotateAngleX) * 17.0D);
/* 316 */     this.rarm3.rotationPointY = (float)(this.rarm2.rotationPointY - Math.cos(this.rarm2.rotateAngleX) * 17.0D);
/* 317 */     this.rarm3.rotateAngleX = a1 - newangle;
/*     */ 
/*     */ 
/*     */     
/* 321 */     this.lfleg1.render(f5);
/* 322 */     this.lfleg2.render(f5);
/* 323 */     this.lfleg3.render(f5);
/* 324 */     this.lfleg4.render(f5);
/* 325 */     this.lrleg1.render(f5);
/* 326 */     this.lrleg2.render(f5);
/* 327 */     this.lrleg3.render(f5);
/* 328 */     this.lrleg4.render(f5);
/* 329 */     this.abdomen.render(f5);
/* 330 */     this.thorax.render(f5);
/* 331 */     this.neck1.render(f5);
/* 332 */     this.neck2.render(f5);
/* 333 */     this.head1.render(f5);
/* 334 */     this.head2.render(f5);
/* 335 */     this.leye.render(f5);
/* 336 */     this.reye.render(f5);
/* 337 */     this.lantenna.render(f5);
/* 338 */     this.rantenna.render(f5);
/* 339 */     this.larm1.render(f5);
/* 340 */     this.larm2.render(f5);
/* 341 */     this.larm3.render(f5);
/* 342 */     this.lfwing.render(f5);
/* 343 */     this.rfwing.render(f5);
/* 344 */     this.lrwing.render(f5);
/* 345 */     this.rrwing.render(f5);
/* 346 */     this.rarm1.render(f5);
/* 347 */     this.rarm2.render(f5);
/* 348 */     this.rarm3.render(f5);
/* 349 */     this.rlfleg3.render(f5);
/* 350 */     this.rfleg4.render(f5);
/* 351 */     this.rfleg2.render(f5);
/* 352 */     this.rfleg1.render(f5);
/* 353 */     this.rrleg3.render(f5);
/* 354 */     this.rrleg4.render(f5);
/* 355 */     this.rrleg2.render(f5);
/* 356 */     this.rrleg1.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 363 */     model.rotateAngleX = x;
/* 364 */     model.rotateAngleY = y;
/* 365 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 370 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelMantis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */