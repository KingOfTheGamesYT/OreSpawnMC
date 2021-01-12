/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelHammerhead
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer chest;
/*     */   
/*     */   ModelRenderer abdomen;
/*     */   
/*     */   ModelRenderer neck;
/*     */   ModelRenderer head;
/*     */   ModelRenderer snout;
/*     */   ModelRenderer neck_armour;
/*     */   ModelRenderer horn_base;
/*     */   ModelRenderer horn_1;
/*     */   ModelRenderer horn_2;
/*     */   ModelRenderer horn_R;
/*     */   ModelRenderer horn_L;
/*     */   ModelRenderer back_armour1;
/*     */   ModelRenderer back_armour_2;
/*     */   ModelRenderer back_armour_3;
/*     */   ModelRenderer back_armour_3R;
/*     */   ModelRenderer back_armour_4;
/*     */   ModelRenderer back_armour_4R;
/*     */   ModelRenderer tail;
/*     */   ModelRenderer leg_1R;
/*     */   ModelRenderer leg_1;
/*     */   ModelRenderer leg_2;
/*     */   ModelRenderer leg_2R;
/*     */   ModelRenderer leg_3R;
/*     */   ModelRenderer leg_3;
/*     */   ModelRenderer leg_1Rb;
/*     */   ModelRenderer leg_1b;
/*     */   ModelRenderer leg_2b;
/*     */   ModelRenderer leg_2Rb;
/*     */   ModelRenderer leg_3Rb;
/*     */   ModelRenderer leg_3b;
/*     */   ModelRenderer fan1;
/*     */   ModelRenderer Lfan2;
/*     */   ModelRenderer Rfan2;
/*     */   ModelRenderer Lfan3;
/*     */   ModelRenderer Rfan3;
/*     */   ModelRenderer Lear;
/*     */   ModelRenderer Rear;
/*     */   
/*     */   public ModelHammerhead(float f1) {
/*  54 */     this.wingspeed = f1;
/*     */     
/*  56 */     this.textureWidth = 222;
/*  57 */     this.textureHeight = 256;
/*     */     
/*  59 */     this.chest = new ModelRenderer(this, 0, 0);
/*  60 */     this.chest.addBox(-9.0F, -1.0F, 0.0F, 19, 16, 17);
/*  61 */     this.chest.setRotationPoint(0.0F, -1.0F, -12.0F);
/*  62 */     this.chest.setTextureSize(222, 256);
/*  63 */     this.chest.mirror = true;
/*  64 */     setRotation(this.chest, 0.0349066F, 0.0F, 0.0F);
/*  65 */     this.abdomen = new ModelRenderer(this, 0, 34);
/*  66 */     this.abdomen.addBox(-7.5F, 0.0F, 0.0F, 16, 14, 16);
/*  67 */     this.abdomen.setRotationPoint(0.0F, -2.0F, 4.0F);
/*  68 */     this.abdomen.setTextureSize(222, 256);
/*  69 */     this.abdomen.mirror = true;
/*  70 */     setRotation(this.abdomen, -0.0349066F, 0.0F, 0.0F);
/*  71 */     this.neck = new ModelRenderer(this, 146, 59);
/*  72 */     this.neck.addBox(-6.5F, -0.5F, -12.0F, 14, 13, 13);
/*  73 */     this.neck.setRotationPoint(0.0F, -1.0F, -12.0F);
/*  74 */     this.neck.setTextureSize(222, 256);
/*  75 */     this.neck.mirror = true;
/*  76 */     setRotation(this.neck, 0.1570796F, 0.0F, 0.0F);
/*  77 */     this.head = new ModelRenderer(this, 101, 59);
/*  78 */     this.head.addBox(-6.0F, -0.5F, -21.0F, 13, 11, 9);
/*  79 */     this.head.setRotationPoint(0.0F, -1.0F, -12.0F);
/*  80 */     this.head.setTextureSize(222, 256);
/*  81 */     this.head.mirror = true;
/*  82 */     setRotation(this.head, 0.2094395F, 0.0F, 0.0F);
/*  83 */     this.snout = new ModelRenderer(this, 166, 86);
/*  84 */     this.snout.addBox(-4.0F, -6.0F, -27.0F, 9, 8, 8);
/*  85 */     this.snout.setRotationPoint(0.0F, -1.0F, -12.0F);
/*  86 */     this.snout.setTextureSize(222, 256);
/*  87 */     this.snout.mirror = true;
/*  88 */     setRotation(this.snout, 0.6108652F, 0.0F, 0.0F);
/*  89 */     this.neck_armour = new ModelRenderer(this, 73, 0);
/*  90 */     this.neck_armour.addBox(-7.0F, -1.5F, -18.0F, 15, 4, 18);
/*  91 */     this.neck_armour.setRotationPoint(0.0F, -1.0F, -12.0F);
/*  92 */     this.neck_armour.setTextureSize(222, 256);
/*  93 */     this.neck_armour.mirror = true;
/*  94 */     setRotation(this.neck_armour, 0.1570796F, 0.0F, 0.0F);
/*  95 */     this.horn_base = new ModelRenderer(this, 49, 35);
/*  96 */     this.horn_base.addBox(-7.0F, -1.5F, -27.0F, 15, 5, 9);
/*  97 */     this.horn_base.setRotationPoint(0.0F, -1.0F, -12.0F);
/*  98 */     this.horn_base.setTextureSize(222, 256);
/*  99 */     this.horn_base.mirror = true;
/* 100 */     setRotation(this.horn_base, 0.0872665F, 0.0F, 0.0F);
/* 101 */     this.horn_1 = new ModelRenderer(this, 122, 23);
/* 102 */     this.horn_1.addBox(-12.0F, -4.5F, -40.0F, 25, 6, 14);
/* 103 */     this.horn_1.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 104 */     this.horn_1.setTextureSize(222, 256);
/* 105 */     this.horn_1.mirror = true;
/* 106 */     setRotation(this.horn_1, 0.1919862F, 0.0F, 0.0F);
/* 107 */     this.horn_2 = new ModelRenderer(this, 106, 44);
/* 108 */     this.horn_2.addBox(-18.0F, -3.5F, -37.0F, 37, 4, 10);
/* 109 */     this.horn_2.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 110 */     this.horn_2.setTextureSize(222, 256);
/* 111 */     this.horn_2.mirror = true;
/* 112 */     setRotation(this.horn_2, 0.1919862F, 0.0F, 0.0F);
/* 113 */     this.horn_R = new ModelRenderer(this, 158, 0);
/* 114 */     this.horn_R.addBox(-26.0F, -5.5F, -38.5F, 8, 7, 13);
/* 115 */     this.horn_R.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 116 */     this.horn_R.setTextureSize(222, 256);
/* 117 */     this.horn_R.mirror = true;
/* 118 */     setRotation(this.horn_R, 0.1919862F, 0.0F, -0.0174533F);
/* 119 */     this.horn_L = new ModelRenderer(this, 158, 0);
/* 120 */     this.horn_L.addBox(19.0F, -5.5F, -38.5F, 8, 7, 13);
/* 121 */     this.horn_L.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 122 */     this.horn_L.setTextureSize(222, 256);
/* 123 */     this.horn_L.mirror = true;
/* 124 */     setRotation(this.horn_L, 0.1919862F, 0.0F, -0.0174533F);
/* 125 */     this.back_armour1 = new ModelRenderer(this, 0, 98);
/* 126 */     this.back_armour1.addBox(-5.0F, -2.5F, -6.0F, 9, 3, 7);
/* 127 */     this.back_armour1.setRotationPoint(1.0F, -4.0F, -15.0F);
/* 128 */     this.back_armour1.setTextureSize(222, 256);
/* 129 */     this.back_armour1.mirror = true;
/* 130 */     setRotation(this.back_armour1, -0.0872665F, 0.0F, 0.0F);
/* 131 */     this.back_armour_2 = new ModelRenderer(this, 0, 65);
/* 132 */     this.back_armour_2.addBox(-8.0F, -4.5F, -13.0F, 17, 4, 28);
/* 133 */     this.back_armour_2.setRotationPoint(0.0F, -1.0F, -3.0F);
/* 134 */     this.back_armour_2.setTextureSize(222, 256);
/* 135 */     this.back_armour_2.mirror = true;
/* 136 */     setRotation(this.back_armour_2, -0.122173F, 0.0F, 0.0F);
/* 137 */     this.back_armour_3 = new ModelRenderer(this, 15, 104);
/* 138 */     this.back_armour_3.addBox(0.5F, -3.5F, -13.0F, 4, 4, 20);
/* 139 */     this.back_armour_3.setRotationPoint(8.0F, 1.0F, -2.0F);
/* 140 */     this.back_armour_3.setTextureSize(222, 256);
/* 141 */     this.back_armour_3.mirror = true;
/* 142 */     setRotation(this.back_armour_3, 0.0174533F, 0.1570796F, 0.0F);
/* 143 */     this.back_armour_3R = new ModelRenderer(this, 15, 104);
/* 144 */     this.back_armour_3R.addBox(-3.5F, -3.5F, -13.0F, 4, 4, 20);
/* 145 */     this.back_armour_3R.setRotationPoint(-8.0F, 1.0F, -2.0F);
/* 146 */     this.back_armour_3R.setTextureSize(222, 256);
/* 147 */     this.back_armour_3R.mirror = true;
/* 148 */     setRotation(this.back_armour_3R, 0.0174533F, -0.1570796F, 0.0F);
/* 149 */     this.back_armour_4 = new ModelRenderer(this, 0, 65);
/* 150 */     this.back_armour_4.addBox(1.5F, -1.5F, -3.0F, 3, 4, 10);
/* 151 */     this.back_armour_4.setRotationPoint(6.0F, 5.0F, -10.0F);
/* 152 */     this.back_armour_4.setTextureSize(222, 256);
/* 153 */     this.back_armour_4.mirror = true;
/* 154 */     setRotation(this.back_armour_4, -0.1396263F, 0.3490659F, 0.0F);
/* 155 */     this.back_armour_4R = new ModelRenderer(this, 0, 65);
/* 156 */     this.back_armour_4R.addBox(-1.5F, -1.5F, -3.0F, 3, 4, 10);
/* 157 */     this.back_armour_4R.setRotationPoint(-8.0F, 5.0F, -11.0F);
/* 158 */     this.back_armour_4R.setTextureSize(222, 256);
/* 159 */     this.back_armour_4R.mirror = true;
/* 160 */     setRotation(this.back_armour_4R, -0.1396263F, -0.3490659F, 0.0F);
/* 161 */     this.tail = new ModelRenderer(this, 66, 52);
/* 162 */     this.tail.addBox(-2.0F, 0.0F, -3.0F, 5, 5, 3);
/* 163 */     this.tail.setRotationPoint(0.0F, 0.0F, 20.0F);
/* 164 */     this.tail.setTextureSize(222, 256);
/* 165 */     this.tail.mirror = true;
/* 166 */     setRotation(this.tail, 0.5061455F, 0.0F, 0.0F);
/* 167 */     this.leg_1R = new ModelRenderer(this, 71, 102);
/* 168 */     this.leg_1R.addBox(-2.5F, -2.5F, -3.0F, 5, 10, 6);
/* 169 */     this.leg_1R.setRotationPoint(-9.0F, 11.0F, -10.0F);
/* 170 */     this.leg_1R.setTextureSize(222, 256);
/* 171 */     this.leg_1R.mirror = true;
/* 172 */     setRotation(this.leg_1R, -0.0872665F, 0.0F, 0.0F);
/* 173 */     this.leg_1 = new ModelRenderer(this, 64, 76);
/* 174 */     this.leg_1.addBox(-1.5F, -2.5F, -3.0F, 5, 10, 6);
/* 175 */     this.leg_1.setRotationPoint(9.0F, 11.0F, -10.0F);
/* 176 */     this.leg_1.setTextureSize(222, 256);
/* 177 */     this.leg_1.mirror = true;
/* 178 */     setRotation(this.leg_1, -0.0872665F, 0.0F, 0.0F);
/* 179 */     this.leg_2 = new ModelRenderer(this, 98, 28);
/* 180 */     this.leg_2.addBox(-1.5F, -2.5F, -3.0F, 5, 9, 6);
/* 181 */     this.leg_2.setRotationPoint(9.0F, 12.0F, -2.0F);
/* 182 */     this.leg_2.setTextureSize(222, 256);
/* 183 */     this.leg_2.mirror = true;
/* 184 */     setRotation(this.leg_2, -0.0523599F, 0.0F, 0.0F);
/* 185 */     this.leg_2R = new ModelRenderer(this, 98, 80);
/* 186 */     this.leg_2R.addBox(-1.5F, -2.5F, -3.0F, 5, 9, 6);
/* 187 */     this.leg_2R.setRotationPoint(-10.0F, 12.0F, -2.0F);
/* 188 */     this.leg_2R.setTextureSize(222, 256);
/* 189 */     this.leg_2R.mirror = true;
/* 190 */     setRotation(this.leg_2R, -0.0523599F, 0.0F, 0.0F);
/* 191 */     this.leg_3R = new ModelRenderer(this, 44, 129);
/* 192 */     this.leg_3R.addBox(-3.5F, -2.5F, -3.0F, 5, 11, 8);
/* 193 */     this.leg_3R.setRotationPoint(-7.0F, 9.0F, 14.0F);
/* 194 */     this.leg_3R.setTextureSize(222, 256);
/* 195 */     this.leg_3R.mirror = true;
/* 196 */     setRotation(this.leg_3R, -0.3490659F, 0.0F, 0.0F);
/* 197 */     this.leg_3 = new ModelRenderer(this, 44, 99);
/* 198 */     this.leg_3.addBox(-3.5F, -2.5F, -3.0F, 5, 11, 8);
/* 199 */     this.leg_3.setRotationPoint(10.0F, 9.0F, 14.0F);
/* 200 */     this.leg_3.setTextureSize(222, 256);
/* 201 */     this.leg_3.mirror = true;
/* 202 */     setRotation(this.leg_3, -0.3490659F, 0.0F, 0.0F);
/* 203 */     this.leg_1Rb = new ModelRenderer(this, 15, 129);
/* 204 */     this.leg_1Rb.addBox(-2.0F, 5.5F, -3.0F, 4, 8, 5);
/* 205 */     this.leg_1Rb.setRotationPoint(-9.0F, 11.0F, -10.0F);
/* 206 */     this.leg_1Rb.setTextureSize(222, 256);
/* 207 */     this.leg_1Rb.mirror = true;
/* 208 */     setRotation(this.leg_1Rb, 0.0F, 0.0F, 0.0F);
/* 209 */     this.leg_1b = new ModelRenderer(this, 15, 110);
/* 210 */     this.leg_1b.addBox(-1.0F, 5.5F, -3.0F, 4, 8, 5);
/* 211 */     this.leg_1b.setRotationPoint(9.0F, 11.0F, -10.0F);
/* 212 */     this.leg_1b.setTextureSize(222, 256);
/* 213 */     this.leg_1b.mirror = true;
/* 214 */     setRotation(this.leg_1b, 0.0F, 0.0F, 0.0F);
/* 215 */     this.leg_2b = new ModelRenderer(this, 57, 1);
/* 216 */     this.leg_2b.addBox(-1.0F, 5.5F, -3.0F, 4, 7, 5);
/* 217 */     this.leg_2b.setRotationPoint(9.0F, 12.0F, -2.0F);
/* 218 */     this.leg_2b.setTextureSize(222, 256);
/* 219 */     this.leg_2b.mirror = true;
/* 220 */     setRotation(this.leg_2b, 0.0523599F, 0.0F, 0.0F);
/* 221 */     this.leg_2Rb = new ModelRenderer(this, 94, 106);
/* 222 */     this.leg_2Rb.addBox(-2.0F, 5.5F, -3.0F, 4, 7, 5);
/* 223 */     this.leg_2Rb.setRotationPoint(-9.0F, 12.0F, -2.0F);
/* 224 */     this.leg_2Rb.setTextureSize(222, 256);
/* 225 */     this.leg_2Rb.mirror = true;
/* 226 */     setRotation(this.leg_2Rb, 0.0523599F, 0.0F, 0.0F);
/* 227 */     this.leg_3Rb = new ModelRenderer(this, 122, 81);
/* 228 */     this.leg_3Rb.addBox(-2.0F, 6.5F, -5.0F, 4, 9, 5);
/* 229 */     this.leg_3Rb.setRotationPoint(-8.0F, 9.0F, 14.0F);
/* 230 */     this.leg_3Rb.setTextureSize(222, 256);
/* 231 */     this.leg_3Rb.mirror = true;
/* 232 */     setRotation(this.leg_3Rb, 0.122173F, 0.0F, 0.0F);
/* 233 */     this.leg_3b = new ModelRenderer(this, 122, 0);
/* 234 */     this.leg_3b.addBox(-3.0F, 6.5F, -5.0F, 4, 9, 5);
/* 235 */     this.leg_3b.setRotationPoint(10.0F, 9.0F, 14.0F);
/* 236 */     this.leg_3b.setTextureSize(222, 256);
/* 237 */     this.leg_3b.mirror = true;
/* 238 */     setRotation(this.leg_3b, 0.122173F, 0.0F, 0.0F);
/* 239 */     this.fan1 = new ModelRenderer(this, 0, 109);
/* 240 */     this.fan1.addBox(-1.0F, -7.0F, -34.0F, 4, 15, 1);
/* 241 */     this.fan1.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 242 */     this.fan1.setTextureSize(222, 256);
/* 243 */     this.fan1.mirror = true;
/* 244 */     setRotation(this.fan1, -0.1396263F, 0.0F, 0.0F);
/* 245 */     this.Lfan2 = new ModelRenderer(this, 0, 109);
/* 246 */     this.Lfan2.addBox(-1.0F, -3.0F, -31.5F, 4, 12, 1);
/* 247 */     this.Lfan2.setRotationPoint(0.0F, -1.0F, -14.0F);
/* 248 */     this.Lfan2.setTextureSize(222, 256);
/* 249 */     this.Lfan2.mirror = true;
/* 250 */     setRotation(this.Lfan2, -0.2094395F, -0.122173F, 0.0F);
/* 251 */     this.Rfan2 = new ModelRenderer(this, 0, 109);
/* 252 */     this.Rfan2.addBox(-1.0F, -3.0F, -33.5F, 4, 12, 1);
/* 253 */     this.Rfan2.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 254 */     this.Rfan2.setTextureSize(222, 256);
/* 255 */     this.Rfan2.mirror = true;
/* 256 */     setRotation(this.Rfan2, -0.2094395F, 0.122173F, 0.0F);
/* 257 */     this.Lfan3 = new ModelRenderer(this, 0, 109);
/* 258 */     this.Lfan3.addBox(-1.0F, 4.0F, -32.0F, 4, 9, 1);
/* 259 */     this.Lfan3.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 260 */     this.Lfan3.setTextureSize(222, 256);
/* 261 */     this.Lfan3.mirror = true;
/* 262 */     setRotation(this.Lfan3, -0.3316126F, -0.2268928F, 0.0F);
/* 263 */     this.Rfan3 = new ModelRenderer(this, 0, 109);
/* 264 */     this.Rfan3.addBox(-1.0F, 4.0F, -32.0F, 4, 9, 1);
/* 265 */     this.Rfan3.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 266 */     this.Rfan3.setTextureSize(222, 256);
/* 267 */     this.Rfan3.mirror = true;
/* 268 */     setRotation(this.Rfan3, -0.3316126F, 0.2443461F, 0.0F);
/* 269 */     this.Lear = new ModelRenderer(this, 0, 80);
/* 270 */     this.Lear.addBox(8.5F, 2.5F, -10.0F, 1, 1, 10);
/* 271 */     this.Lear.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 272 */     this.Lear.setTextureSize(222, 256);
/* 273 */     this.Lear.mirror = true;
/* 274 */     setRotation(this.Lear, 0.3665191F, 0.2268928F, 0.0F);
/* 275 */     this.Rear = new ModelRenderer(this, 0, 80);
/* 276 */     this.Rear.addBox(-8.5F, 2.5F, -11.0F, 1, 1, 10);
/* 277 */     this.Rear.setRotationPoint(0.0F, -1.0F, -12.0F);
/* 278 */     this.Rear.setTextureSize(222, 256);
/* 279 */     this.Rear.mirror = true;
/* 280 */     setRotation(this.Rear, 0.3665191F, -0.2268928F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 286 */     Hammerhead e = (Hammerhead)entity;
/* 287 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 288 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 289 */     float newangle = 0.0F;
/* 290 */     float newangle2 = 0.0F;
/*     */     
/* 292 */     if (f1 > 0.1D) {
/* 293 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.1F * f1;
/* 294 */       newangle2 = MathHelper.cos((float)((f2 * 1.3F * this.wingspeed) + 0.7853981633974483D)) * 3.1415927F * 0.1F * f1;
/*     */     } else {
/* 296 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 299 */     this.leg_1.rotateAngleX = -0.087F + newangle;
/* 300 */     this.leg_1b.rotateAngleX = newangle;
/* 301 */     this.leg_1R.rotateAngleX = -0.087F - newangle;
/* 302 */     this.leg_1Rb.rotateAngleX = -newangle;
/*     */     
/* 304 */     this.leg_2.rotateAngleX = -0.052F + newangle2;
/* 305 */     this.leg_2b.rotateAngleX = newangle2;
/* 306 */     this.leg_2R.rotateAngleX = -0.052F - newangle2;
/* 307 */     this.leg_2Rb.rotateAngleX = -newangle2;
/*     */     
/* 309 */     this.leg_3.rotateAngleX = -0.349F - newangle;
/* 310 */     this.leg_3b.rotateAngleX = -newangle;
/* 311 */     this.leg_3R.rotateAngleX = -0.349F + newangle;
/* 312 */     this.leg_3Rb.rotateAngleX = newangle;
/*     */     
/* 314 */     this.neck.rotateAngleY = (float)Math.toRadians(f3) * 0.25F;
/* 315 */     this.neck_armour.rotateAngleY = this.neck.rotateAngleY;
/* 316 */     this.horn_base.rotateAngleY = this.neck.rotateAngleY;
/* 317 */     this.horn_1.rotateAngleY = this.neck.rotateAngleY;
/* 318 */     this.horn_2.rotateAngleY = this.neck.rotateAngleY;
/* 319 */     this.horn_L.rotateAngleY = this.neck.rotateAngleY;
/* 320 */     this.horn_R.rotateAngleY = this.neck.rotateAngleY;
/* 321 */     this.head.rotateAngleY = this.neck.rotateAngleY;
/* 322 */     this.snout.rotateAngleY = this.neck.rotateAngleY;
/* 323 */     this.fan1.rotateAngleY = this.neck.rotateAngleY;
/* 324 */     this.neck.rotateAngleY -= 0.122F;
/* 325 */     this.neck.rotateAngleY -= 0.226F;
/* 326 */     this.neck.rotateAngleY += 0.122F;
/* 327 */     this.neck.rotateAngleY += 0.226F;
/* 328 */     this.neck.rotateAngleY += 0.227F;
/* 329 */     this.neck.rotateAngleY -= 0.227F;
/*     */     
/* 331 */     newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.03F;
/* 332 */     this.back_armour_4.rotateAngleY = 0.349F + newangle;
/* 333 */     this.back_armour_4R.rotateAngleY = -0.349F - newangle;
/*     */     
/* 335 */     if (e.getAttacking() != 0) {
/* 336 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.13F;
/*     */     } else {
/* 338 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 341 */     this.neck.rotateAngleX = newangle + 0.157F;
/* 342 */     this.neck_armour.rotateAngleX = newangle + 0.157F;
/* 343 */     this.horn_base.rotateAngleX = newangle + 0.087F;
/* 344 */     this.horn_1.rotateAngleX = newangle + 0.192F;
/* 345 */     this.horn_2.rotateAngleX = newangle + 0.192F;
/* 346 */     this.horn_L.rotateAngleX = newangle + 0.192F;
/* 347 */     this.horn_R.rotateAngleX = newangle + 0.192F;
/* 348 */     this.head.rotateAngleX = newangle + 0.209F;
/* 349 */     this.snout.rotateAngleX = newangle + 0.611F;
/* 350 */     this.fan1.rotateAngleX = newangle - 0.139F;
/* 351 */     this.Lfan2.rotateAngleX = newangle - 0.209F;
/* 352 */     this.Lfan3.rotateAngleX = newangle - 0.331F;
/* 353 */     this.Rfan2.rotateAngleX = newangle - 0.209F;
/* 354 */     this.Rfan3.rotateAngleX = newangle - 0.331F;
/* 355 */     this.Lear.rotateAngleX = newangle + 0.366F;
/* 356 */     this.Rear.rotateAngleX = newangle + 0.366F;
/*     */ 
/*     */     
/* 359 */     this.chest.render(f5);
/* 360 */     this.abdomen.render(f5);
/* 361 */     this.neck.render(f5);
/* 362 */     this.head.render(f5);
/* 363 */     this.snout.render(f5);
/* 364 */     this.neck_armour.render(f5);
/* 365 */     this.horn_base.render(f5);
/* 366 */     this.horn_1.render(f5);
/* 367 */     this.horn_2.render(f5);
/* 368 */     this.horn_R.render(f5);
/* 369 */     this.horn_L.render(f5);
/* 370 */     this.back_armour1.render(f5);
/* 371 */     this.back_armour_2.render(f5);
/* 372 */     this.back_armour_3.render(f5);
/* 373 */     this.back_armour_3R.render(f5);
/* 374 */     this.back_armour_4.render(f5);
/* 375 */     this.back_armour_4R.render(f5);
/* 376 */     this.tail.render(f5);
/* 377 */     this.leg_1R.render(f5);
/* 378 */     this.leg_1.render(f5);
/* 379 */     this.leg_2.render(f5);
/* 380 */     this.leg_2R.render(f5);
/* 381 */     this.leg_3R.render(f5);
/* 382 */     this.leg_3.render(f5);
/* 383 */     this.leg_1Rb.render(f5);
/* 384 */     this.leg_1b.render(f5);
/* 385 */     this.leg_2b.render(f5);
/* 386 */     this.leg_2Rb.render(f5);
/* 387 */     this.leg_3Rb.render(f5);
/* 388 */     this.leg_3b.render(f5);
/* 389 */     this.fan1.render(f5);
/* 390 */     this.Lfan2.render(f5);
/* 391 */     this.Rfan2.render(f5);
/* 392 */     this.Lfan3.render(f5);
/* 393 */     this.Rfan3.render(f5);
/* 394 */     this.Lear.render(f5);
/* 395 */     this.Rear.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 401 */     model.rotateAngleX = x;
/* 402 */     model.rotateAngleY = y;
/* 403 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 408 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelHammerhead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */