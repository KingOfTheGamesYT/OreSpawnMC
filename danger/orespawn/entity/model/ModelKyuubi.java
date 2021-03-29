/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Kyuubi;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelKyuubi
/*     */   extends ModelBase
/*     */ {
/*  14 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer rtHorn5;
/*     */   ModelRenderer lfHorn5;
/*     */   ModelRenderer tail9;
/*     */   ModelRenderer tail8;
/*     */   ModelRenderer tail7;
/*     */   ModelRenderer tail6;
/*     */   ModelRenderer tail5;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail0;
/*     */   ModelRenderer lfLegLower;
/*     */   ModelRenderer rtLegLower;
/*     */   ModelRenderer head;
/*     */   ModelRenderer chest;
/*     */   ModelRenderer lfArmUpper;
/*     */   ModelRenderer rtArmLower;
/*     */   ModelRenderer lfLegUpper;
/*     */   ModelRenderer rtLegUpper;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rtArmUpper;
/*     */   ModelRenderer lfArmLower;
/*     */   ModelRenderer tail3;
/*     */   ModelRenderer tail4;
/*     */   ModelRenderer lfHorn2;
/*     */   ModelRenderer rtHorn1;
/*     */   ModelRenderer rtHorn2;
/*     */   ModelRenderer lfHorn1;
/*     */   ModelRenderer lfHorn3;
/*     */   ModelRenderer rtHorn3;
/*     */   ModelRenderer lfHorn4;
/*     */   ModelRenderer rtHorn4;
/*     */   ModelRenderer headFire;
/*     */   ModelRenderer lfArmUpperFire;
/*     */   ModelRenderer chestFire;
/*     */   ModelRenderer bodyFire;
/*     */   ModelRenderer lfArmLowerFire;
/*     */   ModelRenderer rtArmUpperFire;
/*     */   ModelRenderer rtArmLowerFire;
/*     */   ModelRenderer lfLegUppperFire;
/*     */   ModelRenderer lfLegLowerFire;
/*     */   ModelRenderer rtLegUpperFire;
/*     */   ModelRenderer rtLegLowerFire;
/*     */   
/*     */   public ModelKyuubi(float f1) {
/*  60 */     this.wingspeed = f1;
/*     */     
/*  62 */     this.textureWidth = 512;
/*  63 */     this.textureHeight = 256;
/*     */     
/*  65 */     this.rtHorn5 = new ModelRenderer(this, 56, 8);
/*  66 */     this.rtHorn5.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2);
/*  67 */     this.rtHorn5.setRotationPoint(3.0F, -11.5F, -7.0F);
/*  68 */     this.rtHorn5.setTextureSize(512, 256);
/*  69 */     this.rtHorn5.mirror = false;
/*  70 */     setRotation(this.rtHorn5, -0.4461433F, 0.0F, 0.0F);
/*  71 */     this.lfHorn5 = new ModelRenderer(this, 56, 24);
/*  72 */     this.lfHorn5.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2);
/*  73 */     this.lfHorn5.setRotationPoint(-3.0F, -11.5F, -7.0F);
/*  74 */     this.lfHorn5.setTextureSize(512, 256);
/*  75 */     this.lfHorn5.mirror = false;
/*  76 */     setRotation(this.lfHorn5, -0.4461433F, 0.0F, 0.0F);
/*  77 */     this.tail9 = new ModelRenderer(this, 145, 47);
/*  78 */     this.tail9.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1);
/*  79 */     this.tail9.setRotationPoint(0.0F, 9.0F, -26.0F);
/*  80 */     this.tail9.setTextureSize(512, 256);
/*  81 */     this.tail9.mirror = false;
/*  82 */     setRotation(this.tail9, 2.007645F, 0.0F, 0.0F);
/*  83 */     this.tail8 = new ModelRenderer(this, 135, 45);
/*  84 */     this.tail8.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
/*  85 */     this.tail8.setRotationPoint(0.0F, 7.0F, -25.75F);
/*  86 */     this.tail8.setTextureSize(512, 256);
/*  87 */     this.tail8.mirror = false;
/*  88 */     setRotation(this.tail8, 1.524323F, 0.0F, 0.0F);
/*  89 */     this.tail7 = new ModelRenderer(this, 122, 44);
/*  90 */     this.tail7.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3);
/*  91 */     this.tail7.setRotationPoint(0.0F, 5.0F, -24.0F);
/*  92 */     this.tail7.setTextureSize(512, 256);
/*  93 */     this.tail7.mirror = false;
/*  94 */     setRotation(this.tail7, 0.8922867F, 0.0F, 0.0F);
/*  95 */     this.tail6 = new ModelRenderer(this, 105, 43);
/*  96 */     this.tail6.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4);
/*  97 */     this.tail6.setRotationPoint(0.0F, 3.0F, -21.0F);
/*  98 */     this.tail6.setTextureSize(512, 256);
/*  99 */     this.tail6.mirror = false;
/* 100 */     setRotation(this.tail6, 0.6320364F, 0.0F, 0.0F);
/* 101 */     this.tail5 = new ModelRenderer(this, 84, 42);
/* 102 */     this.tail5.addBox(-2.5F, -2.5F, -5.0F, 5, 5, 5);
/* 103 */     this.tail5.setRotationPoint(0.0F, 2.0F, -17.0F);
/* 104 */     this.tail5.setTextureSize(512, 256);
/* 105 */     this.tail5.mirror = false;
/* 106 */     setRotation(this.tail5, 0.2230717F, 0.0F, 0.0F);
/* 107 */     this.tail2 = new ModelRenderer(this, 20, 43);
/* 108 */     this.tail2.addBox(-2.0F, -2.0F, -5.0F, 4, 4, 5);
/* 109 */     this.tail2.setRotationPoint(0.0F, 10.0F, -7.0F);
/* 110 */     this.tail2.setTextureSize(512, 256);
/* 111 */     this.tail2.mirror = false;
/* 112 */     setRotation(this.tail2, -0.7807508F, 0.0F, 0.0F);
/* 113 */     this.tail1 = new ModelRenderer(this, 9, 36);
/* 114 */     this.tail1.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3);
/* 115 */     this.tail1.setRotationPoint(0.0F, 10.0F, -4.333333F);
/* 116 */     this.tail1.setTextureSize(512, 256);
/* 117 */     this.tail1.mirror = false;
/* 118 */     setRotation(this.tail1, -0.2602503F, 0.0F, 0.0F);
/* 119 */     this.tail0 = new ModelRenderer(this, 0, 46);
/* 120 */     this.tail0.addBox(-1.0F, -1.0F, -3.0F, 4, 4, 3);
/* 121 */     this.tail0.setRotationPoint(-1.0F, 9.0F, -2.0F);
/* 122 */     this.tail0.setTextureSize(512, 256);
/* 123 */     this.tail0.mirror = false;
/* 124 */     setRotation(this.tail0, 0.0F, 0.0F, 0.0F);
/* 125 */     this.lfLegLower = new ModelRenderer(this, 205, 55);
/* 126 */     this.lfLegLower.addBox(-2.0F, 0.0F, -3.0F, 4, 6, 4);
/* 127 */     this.lfLegLower.setRotationPoint(-3.0F, 18.0F, 2.0F);
/* 128 */     this.lfLegLower.setTextureSize(512, 256);
/* 129 */     this.lfLegLower.mirror = false;
/* 130 */     setRotation(this.lfLegLower, -0.4461433F, 0.0F, 0.0F);
/* 131 */     this.rtLegLower = new ModelRenderer(this, 149, 53);
/* 132 */     this.rtLegLower.addBox(-2.0F, -1.0F, -3.0F, 4, 7, 4);
/* 133 */     this.rtLegLower.setRotationPoint(3.0F, 18.0F, 4.0F);
/* 134 */     this.rtLegLower.setTextureSize(512, 256);
/* 135 */     this.rtLegLower.mirror = false;
/* 136 */     setRotation(this.rtLegLower, -0.1487144F, 0.0F, 0.0F);
/* 137 */     this.head = new ModelRenderer(this, 168, 0);
/* 138 */     this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
/* 139 */     this.head.setRotationPoint(0.0F, 0.0F, 6.0F);
/* 140 */     this.head.setTextureSize(512, 256);
/* 141 */     this.head.mirror = false;
/* 142 */     setRotation(this.head, 0.2230705F, 3.141593F, 0.0F);
/* 143 */     this.chest = new ModelRenderer(this, 170, 17);
/* 144 */     this.chest.addBox(-4.0F, 0.0F, -2.0F, 8, 7, 6);
/* 145 */     this.chest.setRotationPoint(0.0F, 0.0F, 5.0F);
/* 146 */     this.chest.setTextureSize(512, 256);
/* 147 */     this.chest.mirror = false;
/* 148 */     setRotation(this.chest, -0.8551081F, 0.0F, 0.0F);
/* 149 */     this.lfArmUpper = new ModelRenderer(this, 205, 16);
/* 150 */     this.lfArmUpper.addBox(-3.0F, -2.0F, -2.0F, 4, 7, 4);
/* 151 */     this.lfArmUpper.setRotationPoint(-5.0F, 2.0F, 3.0F);
/* 152 */     this.lfArmUpper.setTextureSize(512, 256);
/* 153 */     this.lfArmUpper.mirror = false;
/* 154 */     setRotation(this.lfArmUpper, 0.0F, 0.0F, 0.3020292F);
/* 155 */     this.rtArmLower = new ModelRenderer(this, 136, 29);
/* 156 */     this.rtArmLower.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 157 */     this.rtArmLower.setRotationPoint(7.0F, 6.0F, 2.0F);
/* 158 */     this.rtArmLower.setTextureSize(512, 256);
/* 159 */     this.rtArmLower.mirror = false;
/* 160 */     setRotation(this.rtArmLower, 0.4833219F, 0.0F, 0.0F);
/* 161 */     this.lfLegUpper = new ModelRenderer(this, 188, 46);
/* 162 */     this.lfLegUpper.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 163 */     this.lfLegUpper.setRotationPoint(-2.0F, 12.0F, 0.0F);
/* 164 */     this.lfLegUpper.setTextureSize(512, 256);
/* 165 */     this.lfLegUpper.mirror = false;
/* 166 */     setRotation(this.lfLegUpper, 0.260246F, 0.0F, 0.2602503F);
/* 167 */     this.rtLegUpper = new ModelRenderer(this, 168, 46);
/* 168 */     this.rtLegUpper.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 169 */     this.rtLegUpper.setRotationPoint(2.0F, 12.0F, 0.0F);
/* 170 */     this.rtLegUpper.setTextureSize(512, 256);
/* 171 */     this.rtLegUpper.mirror = false;
/* 172 */     setRotation(this.rtLegUpper, 0.5948578F, 0.0F, -0.260246F);
/* 173 */     this.body = new ModelRenderer(this, 170, 31);
/* 174 */     this.body.addBox(-4.0F, 0.0F, -3.0F, 8, 7, 6);
/* 175 */     this.body.setRotationPoint(0.0F, 5.0F, 1.0F);
/* 176 */     this.body.setTextureSize(512, 256);
/* 177 */     this.body.mirror = false;
/* 178 */     setRotation(this.body, -0.2974289F, 0.0F, 0.0F);
/* 179 */     this.rtArmUpper = new ModelRenderer(this, 142, 16);
/* 180 */     this.rtArmUpper.addBox(-1.0F, -2.0F, -2.0F, 4, 7, 4);
/* 181 */     this.rtArmUpper.setRotationPoint(5.0F, 2.0F, 2.0F);
/* 182 */     this.rtArmUpper.setTextureSize(512, 256);
/* 183 */     this.rtArmUpper.mirror = false;
/* 184 */     setRotation(this.rtArmUpper, 0.0F, 0.0F, -0.302028F);
/* 185 */     this.lfArmLower = new ModelRenderer(this, 208, 31);
/* 186 */     this.lfArmLower.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
/* 187 */     this.lfArmLower.setRotationPoint(-7.0F, 6.0F, 2.0F);
/* 188 */     this.lfArmLower.setTextureSize(512, 256);
/* 189 */     this.lfArmLower.mirror = false;
/* 190 */     setRotation(this.lfArmLower, 0.4833219F, 0.0F, 0.0F);
/* 191 */     this.tail3 = new ModelRenderer(this, 38, 42);
/* 192 */     this.tail3.addBox(-2.5F, -2.0F, -5.0F, 5, 5, 5);
/* 193 */     this.tail3.setRotationPoint(0.0F, 6.5F, -10.0F);
/* 194 */     this.tail3.setTextureSize(512, 256);
/* 195 */     this.tail3.mirror = false;
/* 196 */     setRotation(this.tail3, -0.96F, 0.0F, 0.0F);
/* 197 */     this.tail4 = new ModelRenderer(this, 59, 41);
/* 198 */     this.tail4.addBox(-3.0F, -3.0F, -6.0F, 6, 6, 6);
/* 199 */     this.tail4.setRotationPoint(0.0F, 3.0F, -12.0F);
/* 200 */     this.tail4.setTextureSize(512, 256);
/* 201 */     this.tail4.mirror = false;
/* 202 */     setRotation(this.tail4, -0.22F, 0.0F, 0.0F);
/* 203 */     this.lfHorn2 = new ModelRenderer(this, 13, 5);
/* 204 */     this.lfHorn2.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4);
/* 205 */     this.lfHorn2.setRotationPoint(-3.0F, -10.0F, 2.0F);
/* 206 */     this.lfHorn2.setTextureSize(512, 256);
/* 207 */     this.lfHorn2.mirror = false;
/* 208 */     setRotation(this.lfHorn2, -0.2230705F, 0.0F, 0.0F);
/* 209 */     this.rtHorn1 = new ModelRenderer(this, 0, 22);
/* 210 */     this.rtHorn1.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3);
/* 211 */     this.rtHorn1.setRotationPoint(3.0F, -8.7F, 4.0F);
/* 212 */     this.rtHorn1.setTextureSize(512, 256);
/* 213 */     this.rtHorn1.mirror = false;
/* 214 */     setRotation(this.rtHorn1, -0.5576792F, 0.0F, 0.0F);
/* 215 */     this.rtHorn2 = new ModelRenderer(this, 13, 21);
/* 216 */     this.rtHorn2.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4);
/* 217 */     this.rtHorn2.setRotationPoint(3.0F, -10.0F, 2.0F);
/* 218 */     this.rtHorn2.setTextureSize(512, 256);
/* 219 */     this.rtHorn2.mirror = false;
/* 220 */     setRotation(this.rtHorn2, -0.2230705F, 0.0F, 0.0F);
/* 221 */     this.lfHorn1 = new ModelRenderer(this, 0, 6);
/* 222 */     this.lfHorn1.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3);
/* 223 */     this.lfHorn1.setRotationPoint(-3.0F, -8.7F, 4.0F);
/* 224 */     this.lfHorn1.setTextureSize(512, 256);
/* 225 */     this.lfHorn1.mirror = false;
/* 226 */     setRotation(this.lfHorn1, -0.5576792F, 0.0F, 0.0F);
/* 227 */     this.lfHorn3 = new ModelRenderer(this, 31, 6);
/* 228 */     this.lfHorn3.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3);
/* 229 */     this.lfHorn3.setRotationPoint(-3.0F, -11.0F, -2.0F);
/* 230 */     this.lfHorn3.setTextureSize(512, 256);
/* 231 */     this.lfHorn3.mirror = false;
/* 232 */     setRotation(this.lfHorn3, -0.0371786F, 0.0F, 0.0F);
/* 233 */     this.rtHorn3 = new ModelRenderer(this, 31, 22);
/* 234 */     this.rtHorn3.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3);
/* 235 */     this.rtHorn3.setRotationPoint(3.0F, -11.0F, -2.0F);
/* 236 */     this.rtHorn3.setTextureSize(512, 256);
/* 237 */     this.rtHorn3.mirror = false;
/* 238 */     setRotation(this.rtHorn3, -0.0371786F, 0.0F, 0.0F);
/* 239 */     this.lfHorn4 = new ModelRenderer(this, 45, 23);
/* 240 */     this.lfHorn4.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
/* 241 */     this.lfHorn4.setRotationPoint(-3.0F, -11.0F, -5.0F);
/* 242 */     this.lfHorn4.setTextureSize(512, 256);
/* 243 */     this.lfHorn4.mirror = false;
/* 244 */     setRotation(this.lfHorn4, -0.2230717F, 0.0F, 0.0F);
/* 245 */     this.rtHorn4 = new ModelRenderer(this, 45, 7);
/* 246 */     this.rtHorn4.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
/* 247 */     this.rtHorn4.setRotationPoint(3.0F, -11.0F, -5.0F);
/* 248 */     this.rtHorn4.setTextureSize(512, 256);
/* 249 */     this.rtHorn4.mirror = false;
/* 250 */     setRotation(this.rtHorn4, -0.2230717F, 0.0F, 0.0F);
/* 251 */     this.headFire = new ModelRenderer(this, 168, 84);
/* 252 */     this.headFire.addBox(-5.0F, -10.0F, -5.0F, 10, 10, 10);
/* 253 */     this.headFire.setRotationPoint(0.0F, 1.0F, 6.0F);
/* 254 */     this.headFire.setTextureSize(512, 256);
/* 255 */     this.headFire.mirror = false;
/* 256 */     setRotation(this.headFire, -0.2230717F, 0.0F, 0.0F);
/* 257 */     this.lfArmUpperFire = new ModelRenderer(this, 209, 108);
/* 258 */     this.lfArmUpperFire.addBox(-6.0F, -1.0F, -3.0F, 6, 9, 6);
/* 259 */     this.lfArmUpperFire.setRotationPoint(-3.0F, 1.0F, 3.0F);
/* 260 */     this.lfArmUpperFire.setTextureSize(512, 256);
/* 261 */     this.lfArmUpperFire.mirror = false;
/* 262 */     setRotation(this.lfArmUpperFire, 0.0F, 0.0F, 0.3020292F);
/* 263 */     this.chestFire = new ModelRenderer(this, 170, 105);
/* 264 */     this.chestFire.addBox(-5.0F, 0.0F, -3.0F, 10, 9, 8);
/* 265 */     this.chestFire.setRotationPoint(0.0F, -1.0F, 6.0F);
/* 266 */     this.chestFire.setTextureSize(512, 256);
/* 267 */     this.chestFire.mirror = false;
/* 268 */     setRotation(this.chestFire, -0.8551081F, 0.0F, 0.0F);
/* 269 */     this.bodyFire = new ModelRenderer(this, 170, 125);
/* 270 */     this.bodyFire.addBox(-5.0F, 0.0F, -4.0F, 10, 9, 8);
/* 271 */     this.bodyFire.setRotationPoint(0.0F, 4.0F, 1.0F);
/* 272 */     this.bodyFire.setTextureSize(512, 256);
/* 273 */     this.bodyFire.mirror = false;
/* 274 */     setRotation(this.bodyFire, -0.2974289F, 0.0F, 0.0F);
/* 275 */     this.lfArmLowerFire = new ModelRenderer(this, 208, 126);
/* 276 */     this.lfArmLowerFire.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6);
/* 277 */     this.lfArmLowerFire.setRotationPoint(-7.333333F, 5.0F, 1.5F);
/* 278 */     this.lfArmLowerFire.setTextureSize(512, 256);
/* 279 */     this.lfArmLowerFire.mirror = false;
/* 280 */     setRotation(this.lfArmLowerFire, 0.4833219F, 0.0F, 0.0F);
/* 281 */     this.rtArmUpperFire = new ModelRenderer(this, 142, 105);
/* 282 */     this.rtArmUpperFire.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6);
/* 283 */     this.rtArmUpperFire.setRotationPoint(5.0F, -1.0F, 2.0F);
/* 284 */     this.rtArmUpperFire.setTextureSize(512, 256);
/* 285 */     this.rtArmUpperFire.mirror = false;
/* 286 */     setRotation(this.rtArmUpperFire, 0.0F, 0.0F, -0.302028F);
/* 287 */     this.rtArmLowerFire = new ModelRenderer(this, 136, 122);
/* 288 */     this.rtArmLowerFire.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6);
/* 289 */     this.rtArmLowerFire.setRotationPoint(7.0F, 5.0F, 1.0F);
/* 290 */     this.rtArmLowerFire.setTextureSize(512, 256);
/* 291 */     this.rtArmLowerFire.mirror = false;
/* 292 */     setRotation(this.rtArmLowerFire, 0.4833219F, 0.0F, 0.0F);
/* 293 */     this.lfLegUppperFire = new ModelRenderer(this, 188, 146);
/* 294 */     this.lfLegUppperFire.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6);
/* 295 */     this.lfLegUppperFire.setRotationPoint(-2.0F, 11.0F, 0.0F);
/* 296 */     this.lfLegUppperFire.setTextureSize(512, 256);
/* 297 */     this.lfLegUppperFire.mirror = false;
/* 298 */     setRotation(this.lfLegUppperFire, 0.260246F, 0.0F, 0.2602503F);
/* 299 */     this.lfLegLowerFire = new ModelRenderer(this, 205, 163);
/* 300 */     this.lfLegLowerFire.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6);
/* 301 */     this.lfLegLowerFire.setRotationPoint(-3.0F, 16.0F, 2.0F);
/* 302 */     this.lfLegLowerFire.setTextureSize(512, 256);
/* 303 */     this.lfLegLowerFire.mirror = false;
/* 304 */     setRotation(this.lfLegLowerFire, -0.4461433F, 0.0F, 0.0F);
/* 305 */     this.rtLegUpperFire = new ModelRenderer(this, 160, 146);
/* 306 */     this.rtLegUpperFire.addBox(-3.0F, 0.0F, -4.0F, 6, 9, 6);
/* 307 */     this.rtLegUpperFire.setRotationPoint(2.0F, 11.0F, 0.0F);
/* 308 */     this.rtLegUpperFire.setTextureSize(512, 256);
/* 309 */     this.rtLegUpperFire.mirror = false;
/* 310 */     setRotation(this.rtLegUpperFire, 0.5948578F, 0.0F, -0.260246F);
/* 311 */     this.rtLegLowerFire = new ModelRenderer(this, 150, 167);
/* 312 */     this.rtLegLowerFire.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6);
/* 313 */     this.rtLegLowerFire.setRotationPoint(3.0F, 15.0F, 4.0F);
/* 314 */     this.rtLegLowerFire.setTextureSize(512, 256);
/* 315 */     this.rtLegLowerFire.mirror = false;
/* 316 */     setRotation(this.rtLegLowerFire, -0.1487144F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 323 */     Kyuubi e = (Kyuubi)entity;
/* 324 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 325 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 326 */     float newangle = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     if (f1 > 0.1D) {
/* 334 */       newangle = MathHelper.cos(f2 * 1.1F * this.wingspeed) * 3.1415927F * 0.2F * f1;
/*     */     } else {
/* 336 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 339 */     this.rtLegUpper.rotateAngleX = 0.59F + newangle;
/* 340 */     this.rtLegUpperFire.rotateAngleX = 0.59F + newangle;
/* 341 */     this.rtLegLower.rotateAngleX = -0.15F + newangle;
/* 342 */     this.rtLegLowerFire.rotateAngleX = -0.15F + newangle;
/* 343 */     this.rtLegLower.rotationPointZ = (float)(Math.sin(this.rtLegUpperFire.rotateAngleX) * 8.0D);
/* 344 */     this.rtLegLowerFire.rotationPointZ = (float)(Math.sin(this.rtLegUpperFire.rotateAngleX) * 8.0D);
/*     */     
/* 346 */     this.lfLegUpper.rotateAngleX = 0.26F - newangle;
/* 347 */     this.lfLegUppperFire.rotateAngleX = 0.26F - newangle;
/* 348 */     this.lfLegLower.rotateAngleX = -0.44F - newangle;
/* 349 */     this.lfLegLowerFire.rotateAngleX = -0.44F - newangle;
/* 350 */     this.lfLegLower.rotationPointZ = (float)(Math.sin(this.lfLegUppperFire.rotateAngleX) * 8.0D);
/* 351 */     this.lfLegLowerFire.rotationPointZ = (float)(Math.sin(this.lfLegUppperFire.rotateAngleX) * 8.0D);
/*     */ 
/*     */ 
/*     */     
/* 355 */     newangle = MathHelper.cos(f2 * 1.1F * this.wingspeed) * 3.1415927F * 0.08F * f1;
/*     */     
/* 357 */     newangle += MathHelper.cos(f2 * 0.5F * this.wingspeed) * 3.1415927F * 0.01F;
/*     */     
/* 359 */     this.rtArmUpper.rotateAngleX = newangle;
/* 360 */     this.rtArmUpperFire.rotateAngleX = newangle;
/* 361 */     this.rtArmLower.rotateAngleX = 0.48F + newangle;
/* 362 */     this.rtArmLowerFire.rotateAngleX = 0.48F + newangle;
/* 363 */     this.rtArmLower.rotationPointZ = (float)(Math.sin(this.rtArmUpperFire.rotateAngleX) * 8.0D);
/* 364 */     this.rtArmLowerFire.rotationPointZ = (float)(Math.sin(this.rtArmUpperFire.rotateAngleX) * 8.0D);
/*     */     
/* 366 */     this.lfArmUpper.rotateAngleX = -newangle;
/* 367 */     this.lfArmUpperFire.rotateAngleX = -newangle;
/* 368 */     this.lfArmLower.rotateAngleX = 0.48F - newangle;
/* 369 */     this.lfArmLowerFire.rotateAngleX = 0.48F - newangle;
/* 370 */     this.lfArmLower.rotationPointZ = (float)(Math.sin(this.lfArmUpperFire.rotateAngleX) * 8.0D);
/* 371 */     this.lfArmLowerFire.rotationPointZ = (float)(Math.sin(this.lfArmUpperFire.rotateAngleX) * 8.0D);
/*     */ 
/*     */ 
/*     */     
/* 375 */     float pi4 = 0.7853975F;
/*     */     
/* 377 */     this.head.rotateAngleY = (float)Math.toRadians(f3) + pi4 * 4.0F;
/* 378 */     this.headFire.rotateAngleY = (float)Math.toRadians(f3);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 383 */     float fc = (float)Math.cos((this.headFire.rotateAngleY + pi4));
/* 384 */     float fs = (float)Math.sin((this.headFire.rotateAngleY + pi4));
/*     */ 
/*     */     
/* 387 */     this.headFire.rotationPointZ -= fc * 3.6F;
/* 388 */     this.headFire.rotationPointX -= fs * 3.6F;
/* 389 */     this.lfHorn1.rotateAngleY = this.headFire.rotateAngleY + 0.244F + MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.1F;
/* 390 */     this.lfHorn1.rotationPointZ -= (float)Math.cos(this.lfHorn1.rotateAngleY) * 2.0F;
/* 391 */     this.lfHorn1.rotationPointX -= (float)Math.sin(this.lfHorn1.rotateAngleY) * 2.0F;
/* 392 */     this.lfHorn2.rotateAngleY = this.headFire.rotateAngleY + 0.244F + MathHelper.cos(f2 * 1.3F * this.wingspeed - pi4) * 3.1415927F * 0.1F;
/* 393 */     this.lfHorn2.rotationPointZ -= (float)Math.cos(this.lfHorn2.rotateAngleY) * 4.0F;
/* 394 */     this.lfHorn2.rotationPointX -= (float)Math.sin(this.lfHorn2.rotateAngleY) * 4.0F;
/* 395 */     this.lfHorn3.rotateAngleY = this.headFire.rotateAngleY + 0.244F + MathHelper.cos(f2 * 1.3F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.1F;
/* 396 */     this.lfHorn3.rotationPointZ -= (float)Math.cos(this.lfHorn3.rotateAngleY) * 3.0F;
/* 397 */     this.lfHorn3.rotationPointX -= (float)Math.sin(this.lfHorn3.rotateAngleY) * 3.0F;
/* 398 */     this.lfHorn4.rotateAngleY = this.headFire.rotateAngleY + 0.244F + MathHelper.cos(f2 * 1.3F * this.wingspeed - 3.0F * pi4) * 3.1415927F * 0.1F;
/* 399 */     this.lfHorn4.rotationPointZ -= (float)Math.cos(this.lfHorn4.rotateAngleY) * 2.0F;
/* 400 */     this.lfHorn4.rotationPointX -= (float)Math.sin(this.lfHorn4.rotateAngleY) * 2.0F;
/* 401 */     this.lfHorn5.rotateAngleY = this.headFire.rotateAngleY + 0.244F + MathHelper.cos(f2 * 1.3F * this.wingspeed - 4.0F * pi4) * 3.1415927F * 0.1F;
/*     */     
/* 403 */     fc = (float)Math.cos((this.headFire.rotateAngleY - pi4));
/* 404 */     fs = (float)Math.sin((this.headFire.rotateAngleY - pi4));
/* 405 */     this.headFire.rotationPointZ -= fc * 3.6F;
/* 406 */     this.headFire.rotationPointX -= fs * 3.6F;
/* 407 */     this.rtHorn1.rotateAngleY = this.headFire.rotateAngleY + -0.244F - MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.1F;
/* 408 */     this.rtHorn1.rotationPointZ -= (float)Math.cos(this.rtHorn1.rotateAngleY) * 2.0F;
/* 409 */     this.rtHorn1.rotationPointX -= (float)Math.sin(this.rtHorn1.rotateAngleY) * 2.0F;
/* 410 */     this.rtHorn2.rotateAngleY = this.headFire.rotateAngleY + -0.244F - MathHelper.cos(f2 * 1.3F * this.wingspeed - pi4) * 3.1415927F * 0.1F;
/* 411 */     this.rtHorn2.rotationPointZ -= (float)Math.cos(this.rtHorn2.rotateAngleY) * 4.0F;
/* 412 */     this.rtHorn2.rotationPointX -= (float)Math.sin(this.rtHorn2.rotateAngleY) * 4.0F;
/* 413 */     this.rtHorn3.rotateAngleY = this.headFire.rotateAngleY + -0.244F - MathHelper.cos(f2 * 1.3F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.1F;
/* 414 */     this.rtHorn3.rotationPointZ -= (float)Math.cos(this.rtHorn3.rotateAngleY) * 3.0F;
/* 415 */     this.rtHorn3.rotationPointX -= (float)Math.sin(this.rtHorn3.rotateAngleY) * 3.0F;
/* 416 */     this.rtHorn4.rotateAngleY = this.headFire.rotateAngleY + -0.244F - MathHelper.cos(f2 * 1.3F * this.wingspeed - 3.0F * pi4) * 3.1415927F * 0.1F;
/* 417 */     this.rtHorn4.rotationPointZ -= (float)Math.cos(this.rtHorn4.rotateAngleY) * 2.0F;
/* 418 */     this.rtHorn4.rotationPointX -= (float)Math.sin(this.rtHorn4.rotateAngleY) * 2.0F;
/* 419 */     this.rtHorn5.rotateAngleY = this.headFire.rotateAngleY + -0.244F - MathHelper.cos(f2 * 1.3F * this.wingspeed - 4.0F * pi4) * 3.1415927F * 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 424 */     this.tail1.rotateAngleY = MathHelper.cos(f2 * 0.9F * this.wingspeed) * 3.1415927F * 0.2F;
/*     */     
/* 426 */     this.tail1.rotationPointX -= (float)Math.sin(this.tail1.rotateAngleY) * 3.0F;
/* 427 */     this.tail2.rotateAngleY = MathHelper.cos(f2 * 0.9F * this.wingspeed - pi4) * 3.1415927F * 0.2F;
/*     */     
/* 429 */     this.tail2.rotationPointX -= (float)Math.sin(this.tail2.rotateAngleY) * 4.0F;
/* 430 */     this.tail3.rotateAngleY = MathHelper.cos(f2 * 0.9F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.2F;
/*     */     
/* 432 */     this.tail3.rotationPointX -= (float)Math.sin(this.tail3.rotateAngleY) * 3.5F;
/* 433 */     this.tail4.rotateAngleY = MathHelper.cos(f2 * 0.9F * this.wingspeed - 3.0F * pi4) * 3.1415927F * 0.2F;
/*     */     
/* 435 */     this.tail4.rotationPointX -= (float)Math.sin(this.tail4.rotateAngleY) * 5.0F;
/* 436 */     this.tail5.rotateAngleY = MathHelper.cos(f2 * 0.9F * this.wingspeed - 4.0F * pi4) * 3.1415927F * 0.2F;
/*     */     
/* 438 */     this.tail5.rotationPointX -= (float)Math.sin(this.tail5.rotateAngleY) * 4.0F;
/* 439 */     this.tail6.rotateAngleY = MathHelper.cos(f2 * 0.9F * this.wingspeed - 5.0F * pi4) * 3.1415927F * 0.2F;
/*     */     
/* 441 */     this.tail6.rotationPointX -= (float)Math.sin(this.tail6.rotateAngleY) * 3.0F;
/* 442 */     this.tail7.rotateAngleY = MathHelper.cos(f2 * 0.9F * this.wingspeed - 6.0F * pi4) * 3.1415927F * 0.2F;
/*     */     
/* 444 */     this.tail7.rotationPointX -= (float)Math.sin(this.tail7.rotateAngleY) * 2.0F;
/* 445 */     this.tail8.rotateAngleY = MathHelper.cos(f2 * 0.9F * this.wingspeed - 7.0F * pi4) * 3.1415927F * 0.2F;
/*     */     
/* 447 */     this.tail8.rotationPointX -= (float)Math.sin(this.tail8.rotateAngleY) * 1.0F;
/* 448 */     this.tail9.rotateAngleY = MathHelper.cos(f2 * 0.9F * this.wingspeed - 8.0F * pi4) * 3.1415927F * 0.2F;
/*     */ 
/*     */     
/* 451 */     this.tail1.rotateAngleX = -0.26F + MathHelper.cos(f2 * 0.5F * this.wingspeed) * 3.1415927F * 0.1F;
/* 452 */     this.tail1.rotationPointY += (float)Math.sin(this.tail1.rotateAngleX) * 3.0F;
/* 453 */     this.tail1.rotationPointZ -= (float)Math.cos(this.tail1.rotateAngleX) * 3.0F;
/* 454 */     this.tail2.rotateAngleX = -0.78F + MathHelper.cos(f2 * 0.5F * this.wingspeed - pi4) * 3.1415927F * 0.1F;
/* 455 */     this.tail2.rotationPointY += (float)Math.sin(this.tail2.rotateAngleX) * 4.0F;
/* 456 */     this.tail2.rotationPointZ -= (float)Math.cos(this.tail2.rotateAngleX) * 4.0F;
/* 457 */     this.tail3.rotateAngleX = -1.11F + MathHelper.cos(f2 * 0.5F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.1F;
/* 458 */     this.tail3.rotationPointY += (float)Math.sin(this.tail3.rotateAngleX) * 3.5F;
/* 459 */     this.tail3.rotationPointZ -= (float)Math.cos(this.tail3.rotateAngleX) * 3.5F;
/* 460 */     this.tail4.rotateAngleX = -0.18F + MathHelper.cos(f2 * 0.5F * this.wingspeed - 3.0F * pi4) * 3.1415927F * 0.1F;
/* 461 */     this.tail4.rotationPointY += (float)Math.sin(this.tail4.rotateAngleX) * 5.0F;
/* 462 */     this.tail4.rotationPointZ -= (float)Math.cos(this.tail4.rotateAngleX) * 5.0F;
/* 463 */     this.tail5.rotateAngleX = 0.22F + MathHelper.cos(f2 * 0.5F * this.wingspeed - 4.0F * pi4) * 3.1415927F * 0.1F;
/* 464 */     this.tail5.rotationPointY += (float)Math.sin(this.tail5.rotateAngleX) * 4.0F;
/* 465 */     this.tail5.rotationPointZ -= (float)Math.cos(this.tail5.rotateAngleX) * 4.0F;
/* 466 */     this.tail6.rotateAngleX = 0.63F + MathHelper.cos(f2 * 0.5F * this.wingspeed - 5.0F * pi4) * 3.1415927F * 0.1F;
/* 467 */     this.tail6.rotationPointY += (float)Math.sin(this.tail6.rotateAngleX) * 3.0F;
/* 468 */     this.tail6.rotationPointZ -= (float)Math.cos(this.tail6.rotateAngleX) * 3.0F;
/* 469 */     this.tail7.rotateAngleX = 0.89F + MathHelper.cos(f2 * 0.5F * this.wingspeed - 6.0F * pi4) * 3.1415927F * 0.1F;
/* 470 */     this.tail7.rotationPointY += (float)Math.sin(this.tail7.rotateAngleX) * 2.0F;
/* 471 */     this.tail7.rotationPointZ -= (float)Math.cos(this.tail7.rotateAngleX) * 2.0F;
/* 472 */     this.tail8.rotateAngleX = 1.52F + MathHelper.cos(f2 * 0.5F * this.wingspeed - 7.0F * pi4) * 3.1415927F * 0.1F;
/* 473 */     this.tail8.rotationPointY += (float)Math.sin(this.tail8.rotateAngleX) * 2.0F;
/* 474 */     this.tail8.rotationPointZ -= (float)Math.cos(this.tail8.rotateAngleX) * 2.0F;
/* 475 */     this.tail9.rotateAngleX = 2.0F + MathHelper.cos(f2 * 0.5F * this.wingspeed - 8.0F * pi4) * 3.1415927F * 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 482 */     GL11.glPushMatrix();
/* 483 */     GL11.glEnable(2977);
/* 484 */     GL11.glEnable(3042);
/* 485 */     GL11.glBlendFunc(770, 771);
/* 486 */     GL11.glTranslatef(0.0F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 489 */     GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/* 490 */     GL11.glTranslatef(0.0F, 0.0F, 0.0F);
/*     */     
/* 492 */     this.lfLegLower.render(f5);
/* 493 */     this.rtLegLower.render(f5);
/* 494 */     this.head.render(f5);
/* 495 */     this.chest.render(f5);
/* 496 */     this.lfArmUpper.render(f5);
/* 497 */     this.rtArmLower.render(f5);
/* 498 */     this.lfLegUpper.render(f5);
/* 499 */     this.rtLegUpper.render(f5);
/* 500 */     this.body.render(f5);
/* 501 */     this.rtArmUpper.render(f5);
/* 502 */     this.lfArmLower.render(f5);
/*     */ 
/*     */     
/* 505 */     this.rtHorn5.render(f5);
/* 506 */     this.lfHorn5.render(f5);
/* 507 */     this.tail9.render(f5);
/* 508 */     this.tail8.render(f5);
/* 509 */     this.tail7.render(f5);
/* 510 */     this.tail6.render(f5);
/* 511 */     this.tail5.render(f5);
/* 512 */     this.tail2.render(f5);
/* 513 */     this.tail1.render(f5);
/* 514 */     this.tail0.render(f5);
/* 515 */     this.tail3.render(f5);
/* 516 */     this.tail4.render(f5);
/* 517 */     this.lfHorn2.render(f5);
/* 518 */     this.rtHorn1.render(f5);
/* 519 */     this.rtHorn2.render(f5);
/* 520 */     this.lfHorn1.render(f5);
/* 521 */     this.lfHorn3.render(f5);
/* 522 */     this.rtHorn3.render(f5);
/* 523 */     this.lfHorn4.render(f5);
/* 524 */     this.rtHorn4.render(f5);
/* 525 */     this.headFire.render(f5);
/* 526 */     this.lfArmUpperFire.render(f5);
/* 527 */     this.chestFire.render(f5);
/* 528 */     this.bodyFire.render(f5);
/* 529 */     this.lfArmLowerFire.render(f5);
/* 530 */     this.rtArmUpperFire.render(f5);
/* 531 */     this.rtArmLowerFire.render(f5);
/* 532 */     this.lfLegUppperFire.render(f5);
/* 533 */     this.lfLegLowerFire.render(f5);
/* 534 */     this.rtLegUpperFire.render(f5);
/* 535 */     this.rtLegLowerFire.render(f5);
/*     */ 
/*     */     
/* 538 */     GL11.glDisable(3042);
/* 539 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 546 */     model.rotateAngleX = x;
/* 547 */     model.rotateAngleY = y;
/* 548 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 553 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelKyuubi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */