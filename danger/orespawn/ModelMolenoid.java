/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMolenoid
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer shoulders;
/*     */   
/*     */   ModelRenderer head1;
/*     */   ModelRenderer head2;
/*     */   ModelRenderer head3;
/*     */   ModelRenderer nosestar1;
/*     */   ModelRenderer nosestar2;
/*     */   ModelRenderer nosestar3;
/*     */   ModelRenderer larm;
/*     */   ModelRenderer lhand;
/*     */   ModelRenderer lclaw1;
/*     */   ModelRenderer lclaw2;
/*     */   ModelRenderer lclaw3;
/*     */   ModelRenderer lclaw4;
/*     */   ModelRenderer nosestar4;
/*     */   ModelRenderer nosestar5;
/*     */   ModelRenderer nosestar6;
/*     */   ModelRenderer butt;
/*     */   ModelRenderer tail;
/*     */   ModelRenderer lleg;
/*     */   ModelRenderer lfoot;
/*     */   ModelRenderer ltoe1;
/*     */   ModelRenderer ltoe2;
/*     */   ModelRenderer ltoe3;
/*     */   ModelRenderer ltoe4;
/*     */   ModelRenderer rarm;
/*     */   ModelRenderer rhand;
/*     */   ModelRenderer rclaw1;
/*     */   ModelRenderer rclaw2;
/*     */   ModelRenderer rclaw3;
/*     */   ModelRenderer rclaw4;
/*     */   ModelRenderer rleg;
/*     */   ModelRenderer rfoot;
/*     */   ModelRenderer rtoe1;
/*     */   ModelRenderer rtoe2;
/*     */   ModelRenderer rtoe3;
/*     */   ModelRenderer rtoe4;
/*     */   
/*     */   public ModelMolenoid(float f1) {
/*  54 */     this.wingspeed = f1;
/*     */     
/*  56 */     this.textureWidth = 256;
/*  57 */     this.textureHeight = 256;
/*     */     
/*  59 */     this.body = new ModelRenderer(this, 0, 176);
/*  60 */     this.body.addBox(-16.0F, 0.0F, 0.0F, 32, 20, 56);
/*  61 */     this.body.setRotationPoint(0.0F, 1.0F, 6.0F);
/*  62 */     this.body.setTextureSize(64, 32);
/*  63 */     this.body.mirror = true;
/*  64 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  65 */     this.shoulders = new ModelRenderer(this, 0, 143);
/*  66 */     this.shoulders.addBox(-17.0F, 0.0F, 0.0F, 34, 17, 10);
/*  67 */     this.shoulders.setRotationPoint(0.0F, 3.0F, -4.0F);
/*  68 */     this.shoulders.setTextureSize(64, 32);
/*  69 */     this.shoulders.mirror = true;
/*  70 */     setRotation(this.shoulders, 0.0F, 0.0F, 0.0F);
/*  71 */     this.head1 = new ModelRenderer(this, 0, 114);
/*  72 */     this.head1.addBox(-14.0F, 0.0F, 0.0F, 28, 14, 10);
/*  73 */     this.head1.setRotationPoint(0.0F, 5.0F, -14.0F);
/*  74 */     this.head1.setTextureSize(64, 32);
/*  75 */     this.head1.mirror = true;
/*  76 */     setRotation(this.head1, 0.0F, 0.0F, 0.0F);
/*  77 */     this.head2 = new ModelRenderer(this, 0, 89);
/*  78 */     this.head2.addBox(-11.0F, 0.0F, 0.0F, 22, 10, 10);
/*  79 */     this.head2.setRotationPoint(0.0F, 6.0F, -24.0F);
/*  80 */     this.head2.setTextureSize(64, 32);
/*  81 */     this.head2.mirror = true;
/*  82 */     setRotation(this.head2, 0.0F, 0.0F, 0.0F);
/*  83 */     this.head3 = new ModelRenderer(this, 0, 67);
/*  84 */     this.head3.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 10);
/*  85 */     this.head3.setRotationPoint(0.0F, 7.0F, -34.0F);
/*  86 */     this.head3.setTextureSize(64, 32);
/*  87 */     this.head3.mirror = true;
/*  88 */     setRotation(this.head3, 0.0F, 0.0F, 0.0F);
/*  89 */     this.nosestar1 = new ModelRenderer(this, 0, 32);
/*  90 */     this.nosestar1.addBox(-0.5F, -8.0F, 0.0F, 1, 16, 1);
/*  91 */     this.nosestar1.setRotationPoint(0.0F, 11.0F, -35.0F);
/*  92 */     this.nosestar1.setTextureSize(64, 32);
/*  93 */     this.nosestar1.mirror = true;
/*  94 */     setRotation(this.nosestar1, 0.0F, 0.0F, 0.0F);
/*  95 */     this.nosestar2 = new ModelRenderer(this, 20, 32);
/*  96 */     this.nosestar2.addBox(-0.5F, -8.0F, 0.0F, 1, 16, 1);
/*  97 */     this.nosestar2.setRotationPoint(0.0F, 11.0F, -35.0F);
/*  98 */     this.nosestar2.setTextureSize(64, 32);
/*  99 */     this.nosestar2.mirror = true;
/* 100 */     setRotation(this.nosestar2, 0.0F, 0.0F, 1.047198F);
/* 101 */     this.nosestar3 = new ModelRenderer(this, 40, 32);
/* 102 */     this.nosestar3.addBox(-0.5F, -8.0F, 0.0F, 1, 16, 1);
/* 103 */     this.nosestar3.setRotationPoint(0.0F, 11.0F, -35.0F);
/* 104 */     this.nosestar3.setTextureSize(64, 32);
/* 105 */     this.nosestar3.mirror = true;
/* 106 */     setRotation(this.nosestar3, 0.0F, 0.0F, -1.047198F);
/* 107 */     this.larm = new ModelRenderer(this, 80, 0);
/* 108 */     this.larm.addBox(0.0F, 0.0F, -2.0F, 17, 11, 5);
/* 109 */     this.larm.setRotationPoint(13.0F, 8.0F, 0.0F);
/* 110 */     this.larm.setTextureSize(64, 32);
/* 111 */     this.larm.mirror = true;
/* 112 */     setRotation(this.larm, 0.0F, 0.6283185F, 0.0F);
/* 113 */     this.lhand = new ModelRenderer(this, 80, 20);
/* 114 */     this.lhand.addBox(0.0F, 0.0F, -2.0F, 12, 14, 4);
/* 115 */     this.lhand.setRotationPoint(25.0F, 7.0F, -9.0F);
/* 116 */     this.lhand.setTextureSize(64, 32);
/* 117 */     this.lhand.mirror = true;
/* 118 */     setRotation(this.lhand, 0.0F, 0.0F, 0.0F);
/* 119 */     this.lclaw1 = new ModelRenderer(this, 80, 42);
/* 120 */     this.lclaw1.addBox(0.0F, 0.0F, -1.0F, 13, 3, 2);
/* 121 */     this.lclaw1.setRotationPoint(35.0F, 20.0F, -9.0F);
/* 122 */     this.lclaw1.setTextureSize(64, 32);
/* 123 */     this.lclaw1.mirror = true;
/* 124 */     setRotation(this.lclaw1, 0.0F, -0.1745329F, 0.0F);
/* 125 */     this.lclaw2 = new ModelRenderer(this, 80, 52);
/* 126 */     this.lclaw2.addBox(0.0F, 0.0F, -1.0F, 13, 3, 2);
/* 127 */     this.lclaw2.setRotationPoint(35.0F, 15.0F, -9.0F);
/* 128 */     this.lclaw2.setTextureSize(64, 32);
/* 129 */     this.lclaw2.mirror = true;
/* 130 */     setRotation(this.lclaw2, 0.0F, -0.1745329F, 0.0F);
/* 131 */     this.lclaw3 = new ModelRenderer(this, 80, 62);
/* 132 */     this.lclaw3.addBox(0.0F, 0.0F, -1.0F, 13, 3, 2);
/* 133 */     this.lclaw3.setRotationPoint(35.0F, 10.0F, -9.0F);
/* 134 */     this.lclaw3.setTextureSize(64, 32);
/* 135 */     this.lclaw3.mirror = true;
/* 136 */     setRotation(this.lclaw3, 0.0F, -0.1745329F, 0.0F);
/* 137 */     this.lclaw4 = new ModelRenderer(this, 80, 72);
/* 138 */     this.lclaw4.addBox(0.0F, 0.0F, -1.0F, 13, 3, 2);
/* 139 */     this.lclaw4.setRotationPoint(35.0F, 5.0F, -9.0F);
/* 140 */     this.lclaw4.setTextureSize(64, 32);
/* 141 */     this.lclaw4.mirror = true;
/* 142 */     setRotation(this.lclaw4, 0.0F, -0.1745329F, 0.0F);
/* 143 */     this.nosestar4 = new ModelRenderer(this, 10, 32);
/* 144 */     this.nosestar4.addBox(-0.5F, -8.0F, 0.0F, 1, 16, 1);
/* 145 */     this.nosestar4.setRotationPoint(0.0F, 11.0F, -35.0F);
/* 146 */     this.nosestar4.setTextureSize(64, 32);
/* 147 */     this.nosestar4.mirror = true;
/* 148 */     setRotation(this.nosestar4, 0.0F, 0.0F, 0.5235988F);
/* 149 */     this.nosestar5 = new ModelRenderer(this, 30, 32);
/* 150 */     this.nosestar5.addBox(-0.5F, -8.0F, 0.0F, 1, 16, 1);
/* 151 */     this.nosestar5.setRotationPoint(0.0F, 11.0F, -35.0F);
/* 152 */     this.nosestar5.setTextureSize(64, 32);
/* 153 */     this.nosestar5.mirror = true;
/* 154 */     setRotation(this.nosestar5, 0.0F, 0.0F, 1.570796F);
/* 155 */     this.nosestar6 = new ModelRenderer(this, 50, 32);
/* 156 */     this.nosestar6.addBox(-0.5F, -8.0F, 0.0F, 1, 16, 1);
/* 157 */     this.nosestar6.setRotationPoint(0.0F, 11.0F, -35.0F);
/* 158 */     this.nosestar6.setTextureSize(64, 32);
/* 159 */     this.nosestar6.mirror = true;
/* 160 */     setRotation(this.nosestar6, 0.0F, 0.0F, -0.5235988F);
/* 161 */     this.butt = new ModelRenderer(this, 196, 215);
/* 162 */     this.butt.addBox(-11.0F, 0.0F, 0.0F, 22, 11, 5);
/* 163 */     this.butt.setRotationPoint(0.0F, 6.0F, 62.0F);
/* 164 */     this.butt.setTextureSize(64, 32);
/* 165 */     this.butt.mirror = true;
/* 166 */     setRotation(this.butt, 0.0F, 0.0F, 0.0F);
/* 167 */     this.tail = new ModelRenderer(this, 196, 200);
/* 168 */     this.tail.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 5);
/* 169 */     this.tail.setRotationPoint(0.0F, 7.0F, 67.0F);
/* 170 */     this.tail.setTextureSize(64, 32);
/* 171 */     this.tail.mirror = true;
/* 172 */     setRotation(this.tail, 0.0F, 0.0F, 0.0F);
/* 173 */     this.lleg = new ModelRenderer(this, 90, 80);
/* 174 */     this.lleg.addBox(0.0F, 0.0F, -2.0F, 17, 11, 5);
/* 175 */     this.lleg.setRotationPoint(14.0F, 9.0F, 58.0F);
/* 176 */     this.lleg.setTextureSize(64, 32);
/* 177 */     this.lleg.mirror = true;
/* 178 */     setRotation(this.lleg, 0.0F, 0.6283185F, 0.0F);
/* 179 */     this.lfoot = new ModelRenderer(this, 90, 100);
/* 180 */     this.lfoot.addBox(0.0F, 0.0F, -2.0F, 12, 14, 4);
/* 181 */     this.lfoot.setRotationPoint(26.0F, 8.0F, 49.0F);
/* 182 */     this.lfoot.setTextureSize(64, 32);
/* 183 */     this.lfoot.mirror = true;
/* 184 */     setRotation(this.lfoot, 0.0F, 0.0F, 0.0F);
/* 185 */     this.ltoe1 = new ModelRenderer(this, 90, 120);
/* 186 */     this.ltoe1.addBox(0.0F, 0.0F, -1.0F, 13, 3, 2);
/* 187 */     this.ltoe1.setRotationPoint(36.0F, 21.0F, 48.0F);
/* 188 */     this.ltoe1.setTextureSize(64, 32);
/* 189 */     this.ltoe1.mirror = true;
/* 190 */     setRotation(this.ltoe1, 0.0F, -0.2617994F, 0.0F);
/* 191 */     this.ltoe2 = new ModelRenderer(this, 90, 130);
/* 192 */     this.ltoe2.addBox(0.0F, 0.0F, -1.0F, 13, 3, 2);
/* 193 */     this.ltoe2.setRotationPoint(36.0F, 16.0F, 48.0F);
/* 194 */     this.ltoe2.setTextureSize(64, 32);
/* 195 */     this.ltoe2.mirror = true;
/* 196 */     setRotation(this.ltoe2, 0.0F, -0.2617994F, 0.0F);
/* 197 */     this.ltoe3 = new ModelRenderer(this, 90, 140);
/* 198 */     this.ltoe3.addBox(0.0F, 0.0F, -1.0F, 13, 3, 2);
/* 199 */     this.ltoe3.setRotationPoint(36.0F, 11.0F, 48.0F);
/* 200 */     this.ltoe3.setTextureSize(64, 32);
/* 201 */     this.ltoe3.mirror = true;
/* 202 */     setRotation(this.ltoe3, 0.0F, -0.2617994F, 0.0F);
/* 203 */     this.ltoe4 = new ModelRenderer(this, 90, 150);
/* 204 */     this.ltoe4.addBox(0.0F, 0.0F, -1.0F, 13, 3, 2);
/* 205 */     this.ltoe4.setRotationPoint(36.0F, 6.0F, 48.0F);
/* 206 */     this.ltoe4.setTextureSize(64, 32);
/* 207 */     this.ltoe4.mirror = true;
/* 208 */     setRotation(this.ltoe4, 0.0F, -0.2617994F, 0.0F);
/* 209 */     this.rarm = new ModelRenderer(this, 130, 0);
/* 210 */     this.rarm.addBox(-17.0F, 0.0F, -2.0F, 17, 11, 5);
/* 211 */     this.rarm.setRotationPoint(-14.0F, 8.0F, 0.0F);
/* 212 */     this.rarm.setTextureSize(64, 32);
/* 213 */     this.rarm.mirror = true;
/* 214 */     setRotation(this.rarm, 0.0F, -0.6283185F, 0.0F);
/* 215 */     this.rhand = new ModelRenderer(this, 130, 20);
/* 216 */     this.rhand.addBox(-12.0F, 0.0F, -2.0F, 12, 14, 4);
/* 217 */     this.rhand.setRotationPoint(-26.0F, 7.0F, -9.0F);
/* 218 */     this.rhand.setTextureSize(64, 32);
/* 219 */     this.rhand.mirror = true;
/* 220 */     setRotation(this.rhand, 0.0F, 0.0F, 0.0F);
/* 221 */     this.rclaw1 = new ModelRenderer(this, 130, 42);
/* 222 */     this.rclaw1.addBox(-13.0F, 0.0F, -1.0F, 13, 3, 2);
/* 223 */     this.rclaw1.setRotationPoint(-36.0F, 20.0F, -9.0F);
/* 224 */     this.rclaw1.setTextureSize(64, 32);
/* 225 */     this.rclaw1.mirror = true;
/* 226 */     setRotation(this.rclaw1, 0.0F, 0.1745329F, 0.0F);
/* 227 */     this.rclaw2 = new ModelRenderer(this, 130, 52);
/* 228 */     this.rclaw2.addBox(-13.0F, 0.0F, -1.0F, 13, 3, 2);
/* 229 */     this.rclaw2.setRotationPoint(-36.0F, 15.0F, -9.0F);
/* 230 */     this.rclaw2.setTextureSize(64, 32);
/* 231 */     this.rclaw2.mirror = true;
/* 232 */     setRotation(this.rclaw2, 0.0F, 0.1745329F, 0.0F);
/* 233 */     this.rclaw3 = new ModelRenderer(this, 130, 62);
/* 234 */     this.rclaw3.addBox(-13.0F, 0.0F, -1.0F, 13, 3, 2);
/* 235 */     this.rclaw3.setRotationPoint(-36.0F, 10.0F, -9.0F);
/* 236 */     this.rclaw3.setTextureSize(64, 32);
/* 237 */     this.rclaw3.mirror = true;
/* 238 */     setRotation(this.rclaw3, 0.0F, 0.1745329F, 0.0F);
/* 239 */     this.rclaw4 = new ModelRenderer(this, 130, 72);
/* 240 */     this.rclaw4.addBox(-13.0F, 0.0F, -1.0F, 13, 3, 2);
/* 241 */     this.rclaw4.setRotationPoint(-36.0F, 5.0F, -9.0F);
/* 242 */     this.rclaw4.setTextureSize(64, 32);
/* 243 */     this.rclaw4.mirror = true;
/* 244 */     setRotation(this.rclaw4, 0.0F, 0.1745329F, 0.0F);
/* 245 */     this.rleg = new ModelRenderer(this, 150, 80);
/* 246 */     this.rleg.addBox(-17.0F, 0.0F, -2.0F, 17, 11, 5);
/* 247 */     this.rleg.setRotationPoint(-14.0F, 9.0F, 58.0F);
/* 248 */     this.rleg.setTextureSize(64, 32);
/* 249 */     this.rleg.mirror = true;
/* 250 */     setRotation(this.rleg, 0.0F, -0.6283185F, 0.0F);
/* 251 */     this.rfoot = new ModelRenderer(this, 150, 100);
/* 252 */     this.rfoot.addBox(-12.0F, 0.0F, -2.0F, 12, 14, 4);
/* 253 */     this.rfoot.setRotationPoint(-26.0F, 8.0F, 49.0F);
/* 254 */     this.rfoot.setTextureSize(64, 32);
/* 255 */     this.rfoot.mirror = true;
/* 256 */     setRotation(this.rfoot, 0.0F, 0.0F, 0.0F);
/* 257 */     this.rtoe1 = new ModelRenderer(this, 150, 120);
/* 258 */     this.rtoe1.addBox(-13.0F, 0.0F, -1.0F, 13, 3, 2);
/* 259 */     this.rtoe1.setRotationPoint(-36.0F, 21.0F, 48.0F);
/* 260 */     this.rtoe1.setTextureSize(64, 32);
/* 261 */     this.rtoe1.mirror = true;
/* 262 */     setRotation(this.rtoe1, 0.0F, 0.2617994F, 0.0F);
/* 263 */     this.rtoe2 = new ModelRenderer(this, 150, 130);
/* 264 */     this.rtoe2.addBox(-13.0F, 0.0F, -1.0F, 13, 3, 2);
/* 265 */     this.rtoe2.setRotationPoint(-36.0F, 16.0F, 48.0F);
/* 266 */     this.rtoe2.setTextureSize(64, 32);
/* 267 */     this.rtoe2.mirror = true;
/* 268 */     setRotation(this.rtoe2, 0.0F, 0.2617994F, 0.0F);
/* 269 */     this.rtoe3 = new ModelRenderer(this, 150, 140);
/* 270 */     this.rtoe3.addBox(-13.0F, 0.0F, -1.0F, 13, 3, 2);
/* 271 */     this.rtoe3.setRotationPoint(-36.0F, 11.0F, 48.0F);
/* 272 */     this.rtoe3.setTextureSize(64, 32);
/* 273 */     this.rtoe3.mirror = true;
/* 274 */     setRotation(this.rtoe3, 0.0F, 0.2617994F, 0.0F);
/* 275 */     this.rtoe4 = new ModelRenderer(this, 150, 150);
/* 276 */     this.rtoe4.addBox(-13.0F, 0.0F, -1.0F, 13, 3, 2);
/* 277 */     this.rtoe4.setRotationPoint(-36.0F, 6.0F, 48.0F);
/* 278 */     this.rtoe4.setTextureSize(64, 32);
/* 279 */     this.rtoe4.mirror = true;
/* 280 */     setRotation(this.rtoe4, 0.0F, 0.2617994F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 286 */     Molenoid e = (Molenoid)entity;
/* 287 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 288 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 289 */     float newangle = 0.0F;
/*     */     
/* 291 */     if (e.getAttacking() != 0) {
/* 292 */       newangle = MathHelper.cos(f2 * 1.7F * this.wingspeed) * 3.1415927F * 0.25F;
/*     */     }
/* 294 */     else if (f1 > 0.1F) {
/* 295 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 297 */       newangle = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 301 */     this.larm.rotateAngleY = newangle + 0.628F;
/* 302 */     this.larm.rotationPointZ -= (float)Math.sin(this.larm.rotateAngleY) * 15.0F;
/* 303 */     this.larm.rotationPointX += (float)Math.cos(this.larm.rotateAngleY) * 15.0F;
/* 304 */     this.lhand.rotateAngleY = newangle * 1.25F;
/* 305 */     this.lhand.rotationPointZ -= (float)Math.sin(this.lhand.rotateAngleY) * 10.0F;
/* 306 */     this.lhand.rotationPointX += (float)Math.cos(this.lhand.rotateAngleY) * 10.0F;
/* 307 */     this.lclaw1.rotateAngleY = newangle * 1.5F - 0.174F;
/* 308 */     this.lclaw2.rotationPointZ = this.lclaw1.rotationPointZ;
/* 309 */     this.lclaw2.rotationPointX = this.lclaw1.rotationPointX;
/* 310 */     this.lclaw2.rotateAngleY = this.lclaw1.rotateAngleY;
/* 311 */     this.lclaw3.rotationPointZ = this.lclaw1.rotationPointZ;
/* 312 */     this.lclaw3.rotationPointX = this.lclaw1.rotationPointX;
/* 313 */     this.lclaw3.rotateAngleY = this.lclaw1.rotateAngleY;
/* 314 */     this.lclaw4.rotationPointZ = this.lclaw1.rotationPointZ;
/* 315 */     this.lclaw4.rotationPointX = this.lclaw1.rotationPointX;
/* 316 */     this.lclaw4.rotateAngleY = this.lclaw1.rotateAngleY;
/*     */     
/* 318 */     this.rarm.rotateAngleY = newangle - 0.628F;
/* 319 */     this.rarm.rotationPointZ += (float)Math.sin(this.rarm.rotateAngleY) * 15.0F;
/* 320 */     this.rarm.rotationPointX -= (float)Math.cos(this.rarm.rotateAngleY) * 15.0F;
/* 321 */     this.rhand.rotateAngleY = newangle * 1.25F;
/* 322 */     this.rhand.rotationPointZ += (float)Math.sin(this.rhand.rotateAngleY) * 10.0F;
/* 323 */     this.rhand.rotationPointX -= (float)Math.cos(this.rhand.rotateAngleY) * 10.0F;
/* 324 */     this.rclaw1.rotateAngleY = newangle * 1.5F + 0.174F;
/* 325 */     this.rclaw2.rotationPointZ = this.rclaw1.rotationPointZ;
/* 326 */     this.rclaw2.rotationPointX = this.rclaw1.rotationPointX;
/* 327 */     this.rclaw2.rotateAngleY = this.rclaw1.rotateAngleY;
/* 328 */     this.rclaw3.rotationPointZ = this.rclaw1.rotationPointZ;
/* 329 */     this.rclaw3.rotationPointX = this.rclaw1.rotationPointX;
/* 330 */     this.rclaw3.rotateAngleY = this.rclaw1.rotateAngleY;
/* 331 */     this.rclaw4.rotationPointZ = this.rclaw1.rotationPointZ;
/* 332 */     this.rclaw4.rotationPointX = this.rclaw1.rotationPointX;
/* 333 */     this.rclaw4.rotateAngleY = this.rclaw1.rotateAngleY;
/*     */     
/* 335 */     if (f1 > 0.1F) {
/* 336 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 338 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 341 */     this.lleg.rotateAngleY = -newangle + 0.628F;
/* 342 */     this.lleg.rotationPointZ -= (float)Math.sin(this.lleg.rotateAngleY) * 15.0F;
/* 343 */     this.lleg.rotationPointX += (float)Math.cos(this.lleg.rotateAngleY) * 15.0F;
/* 344 */     this.lfoot.rotateAngleY = -newangle * 1.25F;
/* 345 */     this.lfoot.rotationPointZ -= (float)Math.sin(this.lfoot.rotateAngleY) * 10.0F;
/* 346 */     this.lfoot.rotationPointX += (float)Math.cos(this.lfoot.rotateAngleY) * 10.0F;
/* 347 */     this.ltoe1.rotateAngleY = -newangle * 1.5F - 0.261F;
/* 348 */     this.ltoe2.rotationPointZ = this.ltoe1.rotationPointZ;
/* 349 */     this.ltoe2.rotationPointX = this.ltoe1.rotationPointX;
/* 350 */     this.ltoe2.rotateAngleY = this.ltoe1.rotateAngleY;
/* 351 */     this.ltoe3.rotationPointZ = this.ltoe1.rotationPointZ;
/* 352 */     this.ltoe3.rotationPointX = this.ltoe1.rotationPointX;
/* 353 */     this.ltoe3.rotateAngleY = this.ltoe1.rotateAngleY;
/* 354 */     this.ltoe4.rotationPointZ = this.ltoe1.rotationPointZ;
/* 355 */     this.ltoe4.rotationPointX = this.ltoe1.rotationPointX;
/* 356 */     this.ltoe4.rotateAngleY = this.ltoe1.rotateAngleY;
/*     */     
/* 358 */     this.rleg.rotateAngleY = -newangle - 0.628F;
/* 359 */     this.rleg.rotationPointZ += (float)Math.sin(this.rleg.rotateAngleY) * 15.0F;
/* 360 */     this.rleg.rotationPointX -= (float)Math.cos(this.rleg.rotateAngleY) * 15.0F;
/* 361 */     this.rfoot.rotateAngleY = -newangle * 1.25F;
/* 362 */     this.rfoot.rotationPointZ += (float)Math.sin(this.rfoot.rotateAngleY) * 10.0F;
/* 363 */     this.rfoot.rotationPointX -= (float)Math.cos(this.rfoot.rotateAngleY) * 10.0F;
/* 364 */     this.rtoe1.rotateAngleY = -newangle * 1.5F + 0.261F;
/* 365 */     this.rtoe2.rotationPointZ = this.rtoe1.rotationPointZ;
/* 366 */     this.rtoe2.rotationPointX = this.rtoe1.rotationPointX;
/* 367 */     this.rtoe2.rotateAngleY = this.rtoe1.rotateAngleY;
/* 368 */     this.rtoe3.rotationPointZ = this.rtoe1.rotationPointZ;
/* 369 */     this.rtoe3.rotationPointX = this.rtoe1.rotationPointX;
/* 370 */     this.rtoe3.rotateAngleY = this.rtoe1.rotateAngleY;
/* 371 */     this.rtoe4.rotationPointZ = this.rtoe1.rotationPointZ;
/* 372 */     this.rtoe4.rotationPointX = this.rtoe1.rotationPointX;
/* 373 */     this.rtoe4.rotateAngleY = this.rtoe1.rotateAngleY;
/*     */     
/* 375 */     newangle = MathHelper.cos(f2 * 0.1F * this.wingspeed) * 3.1415927F;
/* 376 */     this.nosestar1.rotateAngleZ = newangle;
/* 377 */     this.nosestar2.rotateAngleZ = newangle + 0.523F;
/* 378 */     this.nosestar3.rotateAngleZ = newangle + 1.047F;
/* 379 */     this.nosestar4.rotateAngleZ = newangle + 1.57F;
/* 380 */     this.nosestar5.rotateAngleZ = newangle - 1.047F;
/* 381 */     this.nosestar6.rotateAngleZ = newangle - 0.523F;
/*     */     
/* 383 */     this.body.render(f5);
/* 384 */     this.shoulders.render(f5);
/* 385 */     this.head1.render(f5);
/* 386 */     this.head2.render(f5);
/* 387 */     this.head3.render(f5);
/* 388 */     this.nosestar1.render(f5);
/* 389 */     this.nosestar2.render(f5);
/* 390 */     this.nosestar3.render(f5);
/* 391 */     this.larm.render(f5);
/* 392 */     this.lhand.render(f5);
/* 393 */     this.lclaw1.render(f5);
/* 394 */     this.lclaw2.render(f5);
/* 395 */     this.lclaw3.render(f5);
/* 396 */     this.lclaw4.render(f5);
/* 397 */     this.nosestar4.render(f5);
/* 398 */     this.nosestar5.render(f5);
/* 399 */     this.nosestar6.render(f5);
/* 400 */     this.butt.render(f5);
/* 401 */     this.tail.render(f5);
/* 402 */     this.lleg.render(f5);
/* 403 */     this.lfoot.render(f5);
/* 404 */     this.ltoe1.render(f5);
/* 405 */     this.ltoe2.render(f5);
/* 406 */     this.ltoe3.render(f5);
/* 407 */     this.ltoe4.render(f5);
/* 408 */     this.rarm.render(f5);
/* 409 */     this.rhand.render(f5);
/* 410 */     this.rclaw1.render(f5);
/* 411 */     this.rclaw2.render(f5);
/* 412 */     this.rclaw3.render(f5);
/* 413 */     this.rclaw4.render(f5);
/* 414 */     this.rleg.render(f5);
/* 415 */     this.rfoot.render(f5);
/* 416 */     this.rtoe1.render(f5);
/* 417 */     this.rtoe2.render(f5);
/* 418 */     this.rtoe3.render(f5);
/* 419 */     this.rtoe4.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 425 */     model.rotateAngleX = x;
/* 426 */     model.rotateAngleY = y;
/* 427 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 432 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelMolenoid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */