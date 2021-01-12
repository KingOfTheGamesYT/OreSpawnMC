/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelOstrich
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Body1;
/*     */   
/*     */   ModelRenderer body2;
/*     */   
/*     */   ModelRenderer LLeg1;
/*     */   ModelRenderer Rleg1;
/*     */   ModelRenderer LLeg2;
/*     */   ModelRenderer Lfoot1;
/*     */   ModelRenderer RLeg2;
/*     */   ModelRenderer Lfoot2;
/*     */   ModelRenderer Lfoot3;
/*     */   ModelRenderer LClaw1;
/*     */   ModelRenderer LClaw2;
/*     */   ModelRenderer LClaw3;
/*     */   ModelRenderer Lfoot4;
/*     */   ModelRenderer LClaw4;
/*     */   ModelRenderer Rfoot1;
/*     */   ModelRenderer Rfoot2;
/*     */   ModelRenderer Rclaw1;
/*     */   ModelRenderer Rfoot3;
/*     */   ModelRenderer Rclaw3;
/*     */   ModelRenderer Rfoot4;
/*     */   ModelRenderer Rclaw2;
/*     */   ModelRenderer Rclaw4;
/*     */   ModelRenderer Body3;
/*     */   ModelRenderer Tail1;
/*     */   ModelRenderer Tail2;
/*     */   ModelRenderer Tail3;
/*     */   ModelRenderer Body4;
/*     */   ModelRenderer head;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer Neck1;
/*     */   ModelRenderer Head1;
/*     */   ModelRenderer mouth1;
/*     */   ModelRenderer neck2;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer Lwing;
/*     */   ModelRenderer Rwing;
/*     */   ModelRenderer Hat1;
/*     */   ModelRenderer Hat2;
/*     */   
/*     */   public ModelOstrich(float f1) {
/*  54 */     this.wingspeed = f1;
/*     */     
/*  56 */     this.textureWidth = 256;
/*  57 */     this.textureHeight = 128;
/*     */     
/*  59 */     this.Body1 = new ModelRenderer(this, 0, 28);
/*  60 */     this.Body1.addBox(-4.0F, 0.0F, 0.0F, 8, 9, 8);
/*  61 */     this.Body1.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  62 */     this.Body1.setTextureSize(256, 128);
/*  63 */     this.Body1.mirror = true;
/*  64 */     setRotation(this.Body1, -0.2230717F, 0.0F, 0.0F);
/*  65 */     this.body2 = new ModelRenderer(this, 25, 111);
/*  66 */     this.body2.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 8);
/*  67 */     this.body2.setRotationPoint(0.0F, 2.0F, -1.0F);
/*  68 */     this.body2.setTextureSize(256, 128);
/*  69 */     this.body2.mirror = true;
/*  70 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/*  71 */     this.LLeg1 = new ModelRenderer(this, 25, 70);
/*  72 */     this.LLeg1.addBox(-1.0F, 3.0F, -5.0F, 2, 7, 3);
/*  73 */     this.LLeg1.setRotationPoint(3.0F, 8.0F, 1.0F);
/*  74 */     this.LLeg1.setTextureSize(256, 128);
/*  75 */     this.LLeg1.mirror = true;
/*  76 */     setRotation(this.LLeg1, 0.4833219F, 0.0F, 0.0F);
/*  77 */     this.Rleg1 = new ModelRenderer(this, 25, 70);
/*  78 */     this.Rleg1.addBox(-2.0F, 3.0F, -5.0F, 2, 7, 3);
/*  79 */     this.Rleg1.setRotationPoint(-2.0F, 8.0F, 1.0F);
/*  80 */     this.Rleg1.setTextureSize(256, 128);
/*  81 */     this.Rleg1.mirror = true;
/*  82 */     setRotation(this.Rleg1, 0.4833219F, 0.0F, 0.0F);
/*  83 */     this.LLeg2 = new ModelRenderer(this, 29, 59);
/*  84 */     this.LLeg2.addBox(-1.0F, 7.0F, 4.0F, 2, 7, 3);
/*  85 */     this.LLeg2.setRotationPoint(3.0F, 8.0F, 1.0F);
/*  86 */     this.LLeg2.setTextureSize(256, 128);
/*  87 */     this.LLeg2.mirror = true;
/*  88 */     setRotation(this.LLeg2, -0.4370552F, 0.0F, 0.0F);
/*  89 */     this.Lfoot1 = new ModelRenderer(this, 29, 50);
/*  90 */     this.Lfoot1.addBox(-1.0F, 14.0F, -5.0F, 2, 2, 6);
/*  91 */     this.Lfoot1.setRotationPoint(3.0F, 8.0F, 1.0F);
/*  92 */     this.Lfoot1.setTextureSize(256, 128);
/*  93 */     this.Lfoot1.mirror = true;
/*  94 */     setRotation(this.Lfoot1, 0.0F, 0.0F, 0.0F);
/*  95 */     this.RLeg2 = new ModelRenderer(this, 29, 59);
/*  96 */     this.RLeg2.addBox(-2.0F, 7.0F, 4.0F, 2, 7, 3);
/*  97 */     this.RLeg2.setRotationPoint(-2.0F, 8.0F, 1.0F);
/*  98 */     this.RLeg2.setTextureSize(256, 128);
/*  99 */     this.RLeg2.mirror = true;
/* 100 */     setRotation(this.RLeg2, -0.4370552F, 0.0F, 0.0F);
/* 101 */     this.Lfoot2 = new ModelRenderer(this, 0, 9);
/* 102 */     this.Lfoot2.addBox(-1.0F, 15.0F, -4.0F, 2, 1, 5);
/* 103 */     this.Lfoot2.setRotationPoint(3.0F, 8.0F, 1.0F);
/* 104 */     this.Lfoot2.setTextureSize(256, 128);
/* 105 */     this.Lfoot2.mirror = true;
/* 106 */     setRotation(this.Lfoot2, 0.0F, 0.2602503F, 0.0F);
/* 107 */     this.Lfoot3 = new ModelRenderer(this, 0, 9);
/* 108 */     this.Lfoot3.addBox(-1.0F, 15.0F, -4.0F, 2, 1, 5);
/* 109 */     this.Lfoot3.setRotationPoint(3.0F, 8.0F, 1.0F);
/* 110 */     this.Lfoot3.setTextureSize(256, 128);
/* 111 */     this.Lfoot3.mirror = true;
/* 112 */     setRotation(this.Lfoot3, 0.0F, -0.260246F, 0.0F);
/* 113 */     this.LClaw1 = new ModelRenderer(this, 16, 10);
/* 114 */     this.LClaw1.addBox(0.0F, 14.0F, -7.0F, 0, 2, 3);
/* 115 */     this.LClaw1.setRotationPoint(3.0F, 8.0F, 1.0F);
/* 116 */     this.LClaw1.setTextureSize(256, 128);
/* 117 */     this.LClaw1.mirror = true;
/* 118 */     setRotation(this.LClaw1, 0.0F, 0.0F, 0.0F);
/* 119 */     this.LClaw2 = new ModelRenderer(this, 19, 16);
/* 120 */     this.LClaw2.addBox(-0.5F, 15.0F, -5.0F, 0, 1, 3);
/* 121 */     this.LClaw2.setRotationPoint(3.0F, 8.0F, 1.0F);
/* 122 */     this.LClaw2.setTextureSize(256, 128);
/* 123 */     this.LClaw2.mirror = true;
/* 124 */     setRotation(this.LClaw2, 0.0F, 0.260246F, 0.0F);
/* 125 */     this.LClaw3 = new ModelRenderer(this, 19, 16);
/* 126 */     this.LClaw3.addBox(0.5F, 15.0F, -5.0F, 0, 1, 3);
/* 127 */     this.LClaw3.setRotationPoint(3.0F, 8.0F, 1.0F);
/* 128 */     this.LClaw3.setTextureSize(256, 128);
/* 129 */     this.LClaw3.mirror = true;
/* 130 */     setRotation(this.LClaw3, 0.0F, -0.260246F, 0.0F);
/* 131 */     this.Lfoot4 = new ModelRenderer(this, 0, 0);
/* 132 */     this.Lfoot4.addBox(-1.0F, 14.0F, -1.0F, 2, 2, 4);
/* 133 */     this.Lfoot4.setRotationPoint(3.0F, 8.0F, 1.0F);
/* 134 */     this.Lfoot4.setTextureSize(256, 128);
/* 135 */     this.Lfoot4.mirror = true;
/* 136 */     setRotation(this.Lfoot4, 0.0F, 0.0F, 0.0F);
/* 137 */     this.LClaw4 = new ModelRenderer(this, 16, 10);
/* 138 */     this.LClaw4.addBox(0.0F, 14.0F, 2.0F, 0, 2, 3);
/* 139 */     this.LClaw4.setRotationPoint(3.0F, 8.0F, 1.0F);
/* 140 */     this.LClaw4.setTextureSize(256, 128);
/* 141 */     this.LClaw4.mirror = true;
/* 142 */     setRotation(this.LClaw4, 0.0F, 0.0F, 0.0F);
/* 143 */     this.Rfoot1 = new ModelRenderer(this, 29, 50);
/* 144 */     this.Rfoot1.addBox(-2.0F, 14.0F, -5.0F, 2, 2, 6);
/* 145 */     this.Rfoot1.setRotationPoint(-2.0F, 8.0F, 1.0F);
/* 146 */     this.Rfoot1.setTextureSize(256, 128);
/* 147 */     this.Rfoot1.mirror = true;
/* 148 */     setRotation(this.Rfoot1, 0.0F, 0.0F, 0.0F);
/* 149 */     this.Rfoot2 = new ModelRenderer(this, 0, 0);
/* 150 */     this.Rfoot2.addBox(-2.0F, 14.0F, -1.0F, 2, 2, 4);
/* 151 */     this.Rfoot2.setRotationPoint(-2.0F, 8.0F, 1.0F);
/* 152 */     this.Rfoot2.setTextureSize(256, 128);
/* 153 */     this.Rfoot2.mirror = true;
/* 154 */     setRotation(this.Rfoot2, 0.0F, 0.0F, 0.0F);
/* 155 */     this.Rclaw1 = new ModelRenderer(this, 16, 10);
/* 156 */     this.Rclaw1.addBox(-1.0F, 14.0F, -7.0F, 0, 2, 3);
/* 157 */     this.Rclaw1.setRotationPoint(-2.0F, 8.0F, 1.0F);
/* 158 */     this.Rclaw1.setTextureSize(256, 128);
/* 159 */     this.Rclaw1.mirror = true;
/* 160 */     setRotation(this.Rclaw1, 0.0F, 0.0F, 0.0F);
/* 161 */     this.Rfoot3 = new ModelRenderer(this, 0, 9);
/* 162 */     this.Rfoot3.addBox(-2.0F, 15.0F, -4.0F, 2, 1, 5);
/* 163 */     this.Rfoot3.setRotationPoint(-2.0F, 8.0F, 1.0F);
/* 164 */     this.Rfoot3.setTextureSize(256, 128);
/* 165 */     this.Rfoot3.mirror = true;
/* 166 */     setRotation(this.Rfoot3, 0.0F, -0.260246F, 0.0F);
/* 167 */     this.Rclaw3 = new ModelRenderer(this, 19, 16);
/* 168 */     this.Rclaw3.addBox(-0.5F, 15.0F, -5.0F, 0, 1, 3);
/* 169 */     this.Rclaw3.setRotationPoint(-2.0F, 8.0F, 1.0F);
/* 170 */     this.Rclaw3.setTextureSize(256, 128);
/* 171 */     this.Rclaw3.mirror = true;
/* 172 */     setRotation(this.Rclaw3, 0.0F, -0.260246F, 0.0F);
/* 173 */     this.Rfoot4 = new ModelRenderer(this, 0, 9);
/* 174 */     this.Rfoot4.addBox(-2.0F, 15.0F, -4.0F, 2, 1, 5);
/* 175 */     this.Rfoot4.setRotationPoint(-2.0F, 8.0F, 1.0F);
/* 176 */     this.Rfoot4.setTextureSize(256, 128);
/* 177 */     this.Rfoot4.mirror = true;
/* 178 */     setRotation(this.Rfoot4, 0.0F, 0.2602503F, 0.0F);
/* 179 */     this.Rclaw2 = new ModelRenderer(this, 19, 16);
/* 180 */     this.Rclaw2.addBox(-1.5F, 15.0F, -5.0F, 0, 1, 3);
/* 181 */     this.Rclaw2.setRotationPoint(-2.0F, 8.0F, 1.0F);
/* 182 */     this.Rclaw2.setTextureSize(256, 128);
/* 183 */     this.Rclaw2.mirror = true;
/* 184 */     setRotation(this.Rclaw2, 0.0F, 0.260246F, 0.0F);
/* 185 */     this.Rclaw4 = new ModelRenderer(this, 16, 10);
/* 186 */     this.Rclaw4.addBox(-1.0F, 14.0F, 2.0F, 0, 2, 3);
/* 187 */     this.Rclaw4.setRotationPoint(-2.0F, 8.0F, 1.0F);
/* 188 */     this.Rclaw4.setTextureSize(256, 128);
/* 189 */     this.Rclaw4.mirror = true;
/* 190 */     setRotation(this.Rclaw4, 0.0F, 0.0F, 0.0F);
/* 191 */     this.Body3 = new ModelRenderer(this, 17, 96);
/* 192 */     this.Body3.addBox(-3.0F, 0.0F, 0.0F, 6, 7, 3);
/* 193 */     this.Body3.setRotationPoint(0.0F, 2.0F, 6.0F);
/* 194 */     this.Body3.setTextureSize(256, 128);
/* 195 */     this.Body3.mirror = true;
/* 196 */     setRotation(this.Body3, 0.0F, 0.0F, 0.0F);
/* 197 */     this.Tail1 = new ModelRenderer(this, 33, 81);
/* 198 */     this.Tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 0, 14);
/* 199 */     this.Tail1.setRotationPoint(0.0F, 3.0F, 9.0F);
/* 200 */     this.Tail1.setTextureSize(256, 128);
/* 201 */     this.Tail1.mirror = true;
/* 202 */     setRotation(this.Tail1, -0.5948578F, 0.0F, 0.0F);
/* 203 */     this.Tail2 = new ModelRenderer(this, 36, 97);
/* 204 */     this.Tail2.addBox(-1.0F, 0.0F, 0.0F, 3, 0, 13);
/* 205 */     this.Tail2.setRotationPoint(0.0F, 3.0F, 8.0F);
/* 206 */     this.Tail2.setTextureSize(256, 128);
/* 207 */     this.Tail2.mirror = true;
/* 208 */     setRotation(this.Tail2, -0.5948578F, 0.3346075F, 0.0F);
/* 209 */     this.Tail3 = new ModelRenderer(this, 36, 97);
/* 210 */     this.Tail3.addBox(-2.0F, 0.0F, 0.0F, 3, 0, 13);
/* 211 */     this.Tail3.setRotationPoint(0.0F, 3.0F, 8.0F);
/* 212 */     this.Tail3.setTextureSize(256, 128);
/* 213 */     this.Tail3.mirror = true;
/* 214 */     setRotation(this.Tail3, -0.5948578F, -0.3346145F, 0.0F);
/* 215 */     this.Body4 = new ModelRenderer(this, 17, 89);
/* 216 */     this.Body4.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 3);
/* 217 */     this.Body4.setRotationPoint(0.0F, 6.0F, 7.0F);
/* 218 */     this.Body4.setTextureSize(256, 128);
/* 219 */     this.Body4.mirror = true;
/* 220 */     setRotation(this.Body4, 1.003822F, 0.0F, 0.0F);
/* 221 */     this.head = new ModelRenderer(this, 74, 48);
/* 222 */     this.head.addBox(-1.0F, -24.0F, -7.0F, 2, 2, 4);
/* 223 */     this.head.setRotationPoint(0.0F, 5.0F, -7.0F);
/* 224 */     this.head.setTextureSize(256, 128);
/* 225 */     this.head.mirror = true;
/* 226 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/* 227 */     this.leftleg = new ModelRenderer(this, 0, 16);
/* 228 */     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 5);
/* 229 */     this.leftleg.setRotationPoint(3.0F, 8.0F, 1.0F);
/* 230 */     this.leftleg.setTextureSize(256, 128);
/* 231 */     this.leftleg.mirror = true;
/* 232 */     setRotation(this.leftleg, -0.2974289F, 0.0F, 0.0F);
/* 233 */     this.Neck1 = new ModelRenderer(this, 79, 84);
/* 234 */     this.Neck1.addBox(-1.5F, -21.0F, -2.0F, 3, 21, 3);
/* 235 */     this.Neck1.setRotationPoint(0.0F, 5.0F, -7.0F);
/* 236 */     this.Neck1.setTextureSize(256, 128);
/* 237 */     this.Neck1.mirror = true;
/* 238 */     setRotation(this.Neck1, 0.0F, -0.0349066F, 0.0F);
/* 239 */     this.Head1 = new ModelRenderer(this, 0, 70);
/* 240 */     this.Head1.addBox(-2.0F, -25.0F, -3.0F, 4, 4, 4);
/* 241 */     this.Head1.setRotationPoint(0.0F, 5.0F, -7.0F);
/* 242 */     this.Head1.setTextureSize(256, 128);
/* 243 */     this.Head1.mirror = true;
/* 244 */     setRotation(this.Head1, 0.0F, 0.0F, 0.0F);
/* 245 */     this.mouth1 = new ModelRenderer(this, 74, 64);
/* 246 */     this.mouth1.addBox(-1.0F, -22.0F, -6.0F, 2, 1, 3);
/* 247 */     this.mouth1.setRotationPoint(0.0F, 5.0F, -7.0F);
/* 248 */     this.mouth1.setTextureSize(256, 128);
/* 249 */     this.mouth1.mirror = true;
/* 250 */     setRotation(this.mouth1, 0.0F, 0.0F, 0.0F);
/* 251 */     this.neck2 = new ModelRenderer(this, 0, 99);
/* 252 */     this.neck2.addBox(-1.0F, -2.0F, -2.0F, 2, 4, 3);
/* 253 */     this.neck2.setRotationPoint(0.0F, 5.0F, -6.9F);
/* 254 */     this.neck2.setTextureSize(256, 128);
/* 255 */     this.neck2.mirror = true;
/* 256 */     setRotation(this.neck2, 0.0F, 0.0F, 0.0F);
/* 257 */     this.rightleg = new ModelRenderer(this, 0, 16);
/* 258 */     this.rightleg.addBox(-3.0F, 0.0F, -2.0F, 4, 6, 5);
/* 259 */     this.rightleg.setRotationPoint(-2.0F, 8.0F, 1.0F);
/* 260 */     this.rightleg.setTextureSize(256, 128);
/* 261 */     this.rightleg.mirror = true;
/* 262 */     setRotation(this.rightleg, -0.2974216F, 0.0F, 0.0F);
/* 263 */     this.Lwing = new ModelRenderer(this, 0, 107);
/* 264 */     this.Lwing.addBox(0.0F, 0.0F, 0.0F, 1, 7, 11);
/* 265 */     this.Lwing.setRotationPoint(4.0F, 1.0F, -5.0F);
/* 266 */     this.Lwing.setTextureSize(256, 128);
/* 267 */     this.Lwing.mirror = true;
/* 268 */     setRotation(this.Lwing, 0.0F, 0.0F, 0.0F);
/* 269 */     this.Rwing = new ModelRenderer(this, 0, 107);
/* 270 */     this.Rwing.addBox(0.0F, 0.0F, 0.0F, 1, 7, 11);
/* 271 */     this.Rwing.setRotationPoint(-5.0F, 1.0F, -5.0F);
/* 272 */     this.Rwing.setTextureSize(256, 128);
/* 273 */     this.Rwing.mirror = true;
/* 274 */     setRotation(this.Rwing, 0.0F, 0.0F, 0.0F);
/* 275 */     this.Hat1 = new ModelRenderer(this, 40, 0);
/* 276 */     this.Hat1.addBox(-2.5F, -26.0F, -4.0F, 5, 1, 5);
/* 277 */     this.Hat1.setRotationPoint(0.0F, 5.0F, -7.0F);
/* 278 */     this.Hat1.setTextureSize(256, 128);
/* 279 */     this.Hat1.mirror = true;
/* 280 */     setRotation(this.Hat1, 0.0F, 0.0F, 0.0F);
/* 281 */     this.Hat2 = new ModelRenderer(this, 40, 0);
/* 282 */     this.Hat2.addBox(-2.0F, -28.0F, -3.0F, 4, 2, 4);
/* 283 */     this.Hat2.setRotationPoint(0.0F, 5.0F, -7.0F);
/* 284 */     this.Hat2.setTextureSize(256, 128);
/* 285 */     this.Hat2.mirror = true;
/* 286 */     setRotation(this.Hat2, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 293 */     Ostrich o = (Ostrich)entity;
/* 294 */     RenderInfo r = null;
/* 295 */     float hf = 0.0F;
/* 296 */     float newangle = 0.0F;
/* 297 */     float nextangle = 0.0F;
/* 298 */     float lspeed = 0.0F;
/*     */     
/* 300 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 301 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
/* 315 */     lspeed = (float)((o.prevPosX - o.posX) * (o.prevPosX - o.posX) + (o.prevPosZ - o.posZ) * (o.prevPosZ - o.posZ));
/* 316 */     lspeed = (float)Math.sqrt(lspeed);
/* 317 */     newangle = MathHelper.cos(f2 * 1.25F * this.wingspeed) * 3.1415927F * lspeed * 0.4F;
/* 318 */     if (newangle > 0.5D) newangle = 0.75F; 
/* 319 */     if (newangle < -0.5D) newangle = -0.75F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 325 */     this.leftleg.rotateAngleX = -0.297F + newangle;
/* 326 */     this.LLeg1.rotateAngleX = 0.483F + newangle;
/* 327 */     this.LLeg2.rotateAngleX = -0.437F + newangle;
/* 328 */     this.Lfoot1.rotateAngleX = newangle;
/* 329 */     this.Lfoot2.rotateAngleX = newangle;
/* 330 */     this.Lfoot3.rotateAngleX = newangle;
/* 331 */     this.Lfoot4.rotateAngleX = newangle;
/* 332 */     this.LClaw1.rotateAngleX = newangle;
/* 333 */     this.LClaw2.rotateAngleX = newangle;
/* 334 */     this.LClaw3.rotateAngleX = newangle;
/* 335 */     this.LClaw4.rotateAngleX = newangle;
/*     */     
/* 337 */     this.rightleg.rotateAngleX = -0.297F - newangle;
/* 338 */     this.Rleg1.rotateAngleX = 0.483F - newangle;
/* 339 */     this.RLeg2.rotateAngleX = -0.437F - newangle;
/* 340 */     this.Rfoot1.rotateAngleX = -newangle;
/* 341 */     this.Rfoot2.rotateAngleX = -newangle;
/* 342 */     this.Rfoot3.rotateAngleX = -newangle;
/* 343 */     this.Rfoot4.rotateAngleX = -newangle;
/* 344 */     this.Rclaw1.rotateAngleX = -newangle;
/* 345 */     this.Rclaw2.rotateAngleX = -newangle;
/* 346 */     this.Rclaw3.rotateAngleX = -newangle;
/* 347 */     this.Rclaw4.rotateAngleX = -newangle;
/*     */ 
/*     */     
/* 350 */     this.Tail1.rotateAngleX = -0.594F + MathHelper.cos(f2 * 0.05F) * 3.1415927F * 0.06F;
/* 351 */     this.Tail2.rotateAngleX = this.Tail1.rotateAngleX;
/* 352 */     this.Tail3.rotateAngleX = this.Tail1.rotateAngleX;
/*     */     
/* 354 */     this.Tail3.rotateAngleY = -0.334F + MathHelper.cos(f2 * 0.061F) * 3.1415927F * 0.08F;
/* 355 */     this.Tail2.rotateAngleY = 0.334F - MathHelper.cos(f2 * 0.072F) * 3.1415927F * 0.08F;
/*     */ 
/*     */     
/* 358 */     r = o.getRenderInfo();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 363 */     if (o.riddenByEntity != null) {
/*     */ 
/*     */       
/* 366 */       f3 = (o.prevRotationYaw - o.rotationYaw) * 20.0F;
/* 367 */       f3 = -f3;
/* 368 */       r.rf1 += (f3 - r.rf1) / 60.0F;
/* 369 */       if (r.rf1 > 50.0F) r.rf1 = 50.0F; 
/* 370 */       if (r.rf1 < -50.0F) r.rf1 = -50.0F; 
/* 371 */       f3 = r.rf1;
/*     */     } else {
/* 373 */       f3 /= 2.0F;
/*     */     } 
/*     */ 
/*     */     
/* 377 */     if (o.isSitting() == true && o.get_is_activated() == 0) {
/* 378 */       f3 = 0.0F;
/* 379 */       this.Head1.rotateAngleX = 3.1415F;
/* 380 */       this.head.rotateAngleX = this.Head1.rotateAngleX;
/* 381 */       this.mouth1.rotateAngleX = this.Head1.rotateAngleX;
/* 382 */       this.Neck1.rotateAngleX = this.Head1.rotateAngleX;
/* 383 */       this.Hat1.rotateAngleX = this.Head1.rotateAngleX;
/* 384 */       this.Hat2.rotateAngleX = this.Head1.rotateAngleX;
/*     */     } else {
/* 386 */       this.Head1.rotateAngleX = 0.0F;
/* 387 */       this.head.rotateAngleX = this.Head1.rotateAngleX;
/* 388 */       this.mouth1.rotateAngleX = this.Head1.rotateAngleX;
/* 389 */       this.Neck1.rotateAngleX = this.Head1.rotateAngleX;
/* 390 */       this.Hat1.rotateAngleX = this.Head1.rotateAngleX;
/* 391 */       this.Hat2.rotateAngleX = this.Head1.rotateAngleX;
/*     */     } 
/* 393 */     this.Head1.rotateAngleY = (float)Math.toRadians(f3) * 0.65F;
/* 394 */     this.head.rotateAngleY = this.Head1.rotateAngleY;
/* 395 */     this.mouth1.rotateAngleY = this.Head1.rotateAngleY;
/* 396 */     this.Hat1.rotateAngleY = this.Head1.rotateAngleY;
/* 397 */     this.Hat2.rotateAngleY = this.Head1.rotateAngleY;
/*     */     
/* 399 */     newangle = MathHelper.cos(f2 * 1.0F * this.wingspeed) * 3.1415927F * 0.15F;
/* 400 */     nextangle = MathHelper.cos((f2 + 0.3F) * 1.0F * this.wingspeed) * 3.1415927F * 0.15F;
/*     */ 
/*     */     
/* 403 */     if (nextangle > 0.0F && newangle < 0.0F) {
/*     */       
/* 405 */       r.ri1 = 0;
/* 406 */       if (o.worldObj.rand.nextInt(3) == 1) {
/* 407 */         r.ri1 = 1;
/*     */       }
/*     */     } 
/*     */     
/* 411 */     if (r.ri1 == 0) {
/* 412 */       newangle = 0.0F;
/*     */     }
/* 414 */     newangle = Math.abs(newangle);
/* 415 */     this.Lwing.rotateAngleZ = -newangle;
/* 416 */     this.Lwing.rotateAngleY = newangle / 2.0F;
/* 417 */     this.Rwing.rotateAngleZ = newangle;
/* 418 */     this.Rwing.rotateAngleY = -newangle / 2.0F;
/*     */ 
/*     */     
/* 421 */     o.setRenderInfo(r);
/*     */     
/* 423 */     this.Body1.render(f5);
/* 424 */     this.body2.render(f5);
/* 425 */     this.LLeg1.render(f5);
/* 426 */     this.Rleg1.render(f5);
/* 427 */     this.LLeg2.render(f5);
/* 428 */     this.Lfoot1.render(f5);
/* 429 */     this.RLeg2.render(f5);
/* 430 */     this.Lfoot2.render(f5);
/* 431 */     this.Lfoot3.render(f5);
/* 432 */     this.LClaw1.render(f5);
/* 433 */     this.LClaw2.render(f5);
/* 434 */     this.LClaw3.render(f5);
/* 435 */     this.Lfoot4.render(f5);
/* 436 */     this.LClaw4.render(f5);
/* 437 */     this.Rfoot1.render(f5);
/* 438 */     this.Rfoot2.render(f5);
/* 439 */     this.Rclaw1.render(f5);
/* 440 */     this.Rfoot3.render(f5);
/* 441 */     this.Rclaw3.render(f5);
/* 442 */     this.Rfoot4.render(f5);
/* 443 */     this.Rclaw2.render(f5);
/* 444 */     this.Rclaw4.render(f5);
/* 445 */     this.Body3.render(f5);
/* 446 */     this.Tail1.render(f5);
/* 447 */     this.Tail2.render(f5);
/* 448 */     this.Tail3.render(f5);
/* 449 */     this.Body4.render(f5);
/* 450 */     this.head.render(f5);
/* 451 */     this.leftleg.render(f5);
/* 452 */     this.Neck1.render(f5);
/* 453 */     this.Head1.render(f5);
/* 454 */     this.mouth1.render(f5);
/* 455 */     this.neck2.render(f5);
/* 456 */     this.rightleg.render(f5);
/* 457 */     this.Lwing.render(f5);
/* 458 */     this.Rwing.render(f5);
/* 459 */     if (o instanceof EntityCannonFodder && 
/* 460 */       o.get_is_activated() != 0) {
/* 461 */       this.Hat1.render(f5);
/* 462 */       if (o.get_is_activated() > 1) {
/* 463 */         this.Hat2.render(f5);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 473 */     model.rotateAngleX = x;
/* 474 */     model.rotateAngleY = y;
/* 475 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 480 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelOstrich.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */