/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelCaterKiller
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Head;
/*     */   
/*     */   ModelRenderer falsehead;
/*     */   
/*     */   ModelRenderer seg1;
/*     */   ModelRenderer ltusk1;
/*     */   ModelRenderer ltusk2;
/*     */   ModelRenderer rtusk1;
/*     */   ModelRenderer rtusk2;
/*     */   ModelRenderer ljaw;
/*     */   ModelRenderer rjaw;
/*     */   ModelRenderer seg1lspike;
/*     */   ModelRenderer seg1rspike;
/*     */   ModelRenderer seg1ltopspike;
/*     */   ModelRenderer seg1rtopspike;
/*     */   ModelRenderer seg1lleg;
/*     */   ModelRenderer seg1rleg;
/*     */   ModelRenderer seg2;
/*     */   ModelRenderer seg2lfoot;
/*     */   ModelRenderer seg2rfoot;
/*     */   ModelRenderer seg2ltopspike;
/*     */   ModelRenderer seg2rtopspike;
/*     */   ModelRenderer seg2lspike;
/*     */   ModelRenderer seg2rspike;
/*     */   ModelRenderer seg3;
/*     */   ModelRenderer seg3lfoot;
/*     */   ModelRenderer seg3rfoot;
/*     */   ModelRenderer seg3lspike;
/*     */   ModelRenderer seg3rspike;
/*     */   ModelRenderer seg3ltopspike;
/*     */   ModelRenderer seg3rtopspike;
/*     */   ModelRenderer seg3lbackspike;
/*     */   ModelRenderer seg3rbackspike;
/*     */   
/*     */   public ModelCaterKiller(float f1) {
/*  48 */     this.wingspeed = f1;
/*     */     
/*  50 */     this.textureWidth = 256;
/*  51 */     this.textureHeight = 512;
/*     */     
/*  53 */     this.Head = new ModelRenderer(this, 0, 50);
/*  54 */     this.Head.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 8);
/*  55 */     this.Head.setRotationPoint(0.0F, -8.0F, -12.0F);
/*  56 */     this.Head.setTextureSize(64, 32);
/*  57 */     this.Head.mirror = true;
/*  58 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/*  59 */     this.falsehead = new ModelRenderer(this, 0, 100);
/*  60 */     this.falsehead.addBox(-10.0F, -27.0F, -11.0F, 20, 20, 10);
/*  61 */     this.falsehead.setRotationPoint(0.0F, -8.0F, -12.0F);
/*  62 */     this.falsehead.setTextureSize(64, 32);
/*  63 */     this.falsehead.mirror = true;
/*  64 */     setRotation(this.falsehead, -0.1570796F, 0.0F, 0.0F);
/*  65 */     this.seg1 = new ModelRenderer(this, 0, 200);
/*  66 */     this.seg1.addBox(-14.0F, -31.0F, 0.0F, 28, 32, 14);
/*  67 */     this.seg1.setRotationPoint(0.0F, -8.0F, -12.0F);
/*  68 */     this.seg1.setTextureSize(64, 32);
/*  69 */     this.seg1.mirror = true;
/*  70 */     setRotation(this.seg1, 0.0F, 0.0F, 0.0F);
/*  71 */     this.ltusk1 = new ModelRenderer(this, 0, 140);
/*  72 */     this.ltusk1.addBox(-1.0F, -1.0F, -1.0F, 33, 3, 3);
/*  73 */     this.ltusk1.setRotationPoint(9.0F, -25.0F, -19.0F);
/*  74 */     this.ltusk1.setTextureSize(64, 32);
/*  75 */     this.ltusk1.mirror = true;
/*  76 */     setRotation(this.ltusk1, 0.0F, 0.5585054F, 0.0F);
/*  77 */     this.ltusk2 = new ModelRenderer(this, 0, 160);
/*  78 */     this.ltusk2.addBox(0.0F, 0.0F, 0.0F, 20, 1, 1);
/*  79 */     this.ltusk2.setRotationPoint(36.0F, -25.0F, -36.0F);
/*  80 */     this.ltusk2.setTextureSize(64, 32);
/*  81 */     this.ltusk2.mirror = true;
/*  82 */     setRotation(this.ltusk2, 0.0F, 0.8028515F, 0.0F);
/*  83 */     this.rtusk1 = new ModelRenderer(this, 0, 150);
/*  84 */     this.rtusk1.addBox(-33.0F, 0.0F, 0.0F, 33, 3, 3);
/*  85 */     this.rtusk1.setRotationPoint(-8.0F, -25.0F, -17.0F);
/*  86 */     this.rtusk1.setTextureSize(64, 32);
/*  87 */     this.rtusk1.mirror = true;
/*  88 */     setRotation(this.rtusk1, 0.0F, -0.5585054F, 0.0F);
/*  89 */     this.rtusk2 = new ModelRenderer(this, 0, 170);
/*  90 */     this.rtusk2.addBox(-20.0F, 0.0F, 0.0F, 20, 1, 1);
/*  91 */     this.rtusk2.setRotationPoint(-36.0F, -24.0F, -34.0F);
/*  92 */     this.rtusk2.setTextureSize(64, 32);
/*  93 */     this.rtusk2.mirror = true;
/*  94 */     setRotation(this.rtusk2, 0.0F, -0.8028515F, 0.0F);
/*  95 */     this.ljaw = new ModelRenderer(this, 100, 50);
/*  96 */     this.ljaw.addBox(0.0F, 0.0F, 0.0F, 1, 7, 4);
/*  97 */     this.ljaw.setRotationPoint(4.0F, -1.0F, -18.0F);
/*  98 */     this.ljaw.setTextureSize(64, 32);
/*  99 */     this.ljaw.mirror = true;
/* 100 */     setRotation(this.ljaw, 0.0F, 0.0F, 0.1396263F);
/* 101 */     this.rjaw = new ModelRenderer(this, 125, 50);
/* 102 */     this.rjaw.addBox(0.0F, 0.0F, 0.0F, 1, 7, 4);
/* 103 */     this.rjaw.setRotationPoint(-5.0F, -1.0F, -18.0F);
/* 104 */     this.rjaw.setTextureSize(64, 32);
/* 105 */     this.rjaw.mirror = true;
/* 106 */     setRotation(this.rjaw, 0.0F, 0.0F, -0.1396263F);
/* 107 */     this.seg1lspike = new ModelRenderer(this, 0, 260);
/* 108 */     this.seg1lspike.addBox(-1.0F, -1.0F, -1.0F, 33, 2, 2);
/* 109 */     this.seg1lspike.setRotationPoint(14.0F, -32.0F, -6.0F);
/* 110 */     this.seg1lspike.setTextureSize(64, 32);
/* 111 */     this.seg1lspike.mirror = true;
/* 112 */     setRotation(this.seg1lspike, 0.0F, 0.3316126F, -0.122173F);
/* 113 */     this.seg1rspike = new ModelRenderer(this, 0, 270);
/* 114 */     this.seg1rspike.addBox(-33.0F, -1.0F, -1.0F, 33, 2, 2);
/* 115 */     this.seg1rspike.setRotationPoint(-13.0F, -32.0F, -6.0F);
/* 116 */     this.seg1rspike.setTextureSize(64, 32);
/* 117 */     this.seg1rspike.mirror = true;
/* 118 */     setRotation(this.seg1rspike, 0.0F, -0.3316126F, 0.122173F);
/* 119 */     this.seg1ltopspike = new ModelRenderer(this, 125, 260);
/* 120 */     this.seg1ltopspike.addBox(-2.0F, -8.0F, -2.0F, 4, 9, 4);
/* 121 */     this.seg1ltopspike.setRotationPoint(8.0F, -39.0F, -6.0F);
/* 122 */     this.seg1ltopspike.setTextureSize(64, 32);
/* 123 */     this.seg1ltopspike.mirror = true;
/* 124 */     setRotation(this.seg1ltopspike, 0.0F, 0.0F, 0.1396263F);
/* 125 */     this.seg1rtopspike = new ModelRenderer(this, 150, 260);
/* 126 */     this.seg1rtopspike.addBox(-2.0F, -8.0F, -2.0F, 4, 9, 4);
/* 127 */     this.seg1rtopspike.setRotationPoint(-10.0F, -39.0F, -6.0F);
/* 128 */     this.seg1rtopspike.setTextureSize(64, 32);
/* 129 */     this.seg1rtopspike.mirror = true;
/* 130 */     setRotation(this.seg1rtopspike, 0.0F, 0.0F, -0.1396263F);
/* 131 */     this.seg1lleg = new ModelRenderer(this, 125, 200);
/* 132 */     this.seg1lleg.addBox(-1.0F, 0.0F, -1.0F, 2, 16, 2);
/* 133 */     this.seg1lleg.setRotationPoint(8.0F, -8.0F, -5.0F);
/* 134 */     this.seg1lleg.setTextureSize(64, 32);
/* 135 */     this.seg1lleg.mirror = true;
/* 136 */     setRotation(this.seg1lleg, 0.0F, 0.0F, 0.1570796F);
/* 137 */     this.seg1rleg = new ModelRenderer(this, 150, 200);
/* 138 */     this.seg1rleg.addBox(0.0F, 0.0F, 0.0F, 2, 16, 2);
/* 139 */     this.seg1rleg.setRotationPoint(-9.0F, -8.0F, -5.0F);
/* 140 */     this.seg1rleg.setTextureSize(64, 32);
/* 141 */     this.seg1rleg.mirror = true;
/* 142 */     setRotation(this.seg1rleg, 0.0F, 0.0F, -0.1570796F);
/* 143 */     this.seg2 = new ModelRenderer(this, 0, 300);
/* 144 */     this.seg2.addBox(-20.0F, -17.0F, -9.0F, 40, 34, 18);
/* 145 */     this.seg2.setRotationPoint(0.0F, -2.0F, 32.0F);
/* 146 */     this.seg2.setTextureSize(64, 32);
/* 147 */     this.seg2.mirror = true;
/* 148 */     setRotation(this.seg2, 0.0F, 0.0F, 0.0F);
/* 149 */     this.seg2lfoot = new ModelRenderer(this, 125, 300);
/* 150 */     this.seg2lfoot.addBox(-5.0F, 0.0F, -5.0F, 10, 10, 10);
/* 151 */     this.seg2lfoot.setRotationPoint(13.0F, 14.0F, 32.0F);
/* 152 */     this.seg2lfoot.setTextureSize(64, 32);
/* 153 */     this.seg2lfoot.mirror = true;
/* 154 */     setRotation(this.seg2lfoot, 0.0F, 0.0F, 0.0F);
/* 155 */     this.seg2rfoot = new ModelRenderer(this, 175, 300);
/* 156 */     this.seg2rfoot.addBox(-5.0F, 0.0F, -5.0F, 10, 10, 10);
/* 157 */     this.seg2rfoot.setRotationPoint(-13.0F, 14.0F, 32.0F);
/* 158 */     this.seg2rfoot.setTextureSize(64, 32);
/* 159 */     this.seg2rfoot.mirror = true;
/* 160 */     setRotation(this.seg2rfoot, 0.0F, 0.0F, 0.0F);
/* 161 */     this.seg2ltopspike = new ModelRenderer(this, 100, 360);
/* 162 */     this.seg2ltopspike.addBox(-2.0F, -9.0F, -2.0F, 4, 9, 4);
/* 163 */     this.seg2ltopspike.setRotationPoint(14.0F, -18.0F, 32.0F);
/* 164 */     this.seg2ltopspike.setTextureSize(64, 32);
/* 165 */     this.seg2ltopspike.mirror = true;
/* 166 */     setRotation(this.seg2ltopspike, 0.0F, 0.0F, 0.1396263F);
/* 167 */     this.seg2rtopspike = new ModelRenderer(this, 125, 360);
/* 168 */     this.seg2rtopspike.addBox(-2.0F, -9.0F, -2.0F, 4, 9, 4);
/* 169 */     this.seg2rtopspike.setRotationPoint(-14.0F, -18.0F, 32.0F);
/* 170 */     this.seg2rtopspike.setTextureSize(64, 32);
/* 171 */     this.seg2rtopspike.mirror = true;
/* 172 */     setRotation(this.seg2rtopspike, 0.0F, 0.0F, -0.1396263F);
/* 173 */     this.seg2lspike = new ModelRenderer(this, 0, 360);
/* 174 */     this.seg2lspike.addBox(0.0F, -1.0F, -1.0F, 20, 2, 2);
/* 175 */     this.seg2lspike.setRotationPoint(18.0F, -9.0F, 32.0F);
/* 176 */     this.seg2lspike.setTextureSize(64, 32);
/* 177 */     this.seg2lspike.mirror = true;
/* 178 */     setRotation(this.seg2lspike, 0.0F, 0.0F, -0.0698132F);
/* 179 */     this.seg2rspike = new ModelRenderer(this, 0, 370);
/* 180 */     this.seg2rspike.addBox(-20.0F, -1.0F, -1.0F, 20, 2, 2);
/* 181 */     this.seg2rspike.setRotationPoint(-18.0F, -9.0F, 32.0F);
/* 182 */     this.seg2rspike.setTextureSize(64, 32);
/* 183 */     this.seg2rspike.mirror = true;
/* 184 */     setRotation(this.seg2rspike, 0.0F, 0.0F, 0.0698132F);
/* 185 */     this.seg3 = new ModelRenderer(this, 0, 400);
/* 186 */     this.seg3.addBox(-15.0F, -14.0F, -7.0F, 30, 28, 14);
/* 187 */     this.seg3.setRotationPoint(0.0F, 3.0F, 48.0F);
/* 188 */     this.seg3.setTextureSize(64, 32);
/* 189 */     this.seg3.mirror = true;
/* 190 */     setRotation(this.seg3, 0.0F, 0.0F, 0.0F);
/* 191 */     this.seg3lfoot = new ModelRenderer(this, 100, 400);
/* 192 */     this.seg3lfoot.addBox(-4.0F, 0.0F, -6.0F, 8, 8, 12);
/* 193 */     this.seg3lfoot.setRotationPoint(10.0F, 16.0F, 48.0F);
/* 194 */     this.seg3lfoot.setTextureSize(64, 32);
/* 195 */     this.seg3lfoot.mirror = true;
/* 196 */     setRotation(this.seg3lfoot, 0.0F, 0.0F, 0.0F);
/* 197 */     this.seg3rfoot = new ModelRenderer(this, 150, 400);
/* 198 */     this.seg3rfoot.addBox(-4.0F, 0.0F, -6.0F, 8, 8, 12);
/* 199 */     this.seg3rfoot.setRotationPoint(-10.0F, 16.0F, 48.0F);
/* 200 */     this.seg3rfoot.setTextureSize(64, 32);
/* 201 */     this.seg3rfoot.mirror = true;
/* 202 */     setRotation(this.seg3rfoot, 0.0F, 0.0F, 0.0F);
/* 203 */     this.seg3lspike = new ModelRenderer(this, 0, 450);
/* 204 */     this.seg3lspike.addBox(0.0F, -1.0F, -1.0F, 14, 2, 2);
/* 205 */     this.seg3lspike.setRotationPoint(14.0F, -4.0F, 48.0F);
/* 206 */     this.seg3lspike.setTextureSize(64, 32);
/* 207 */     this.seg3lspike.mirror = true;
/* 208 */     setRotation(this.seg3lspike, 0.0F, 0.0F, -0.0698132F);
/* 209 */     this.seg3rspike = new ModelRenderer(this, 0, 460);
/* 210 */     this.seg3rspike.addBox(-14.0F, -1.0F, -1.0F, 14, 2, 2);
/* 211 */     this.seg3rspike.setRotationPoint(-14.0F, -4.0F, 48.0F);
/* 212 */     this.seg3rspike.setTextureSize(64, 32);
/* 213 */     this.seg3rspike.mirror = true;
/* 214 */     setRotation(this.seg3rspike, 0.0F, 0.0F, 0.0698132F);
/* 215 */     this.seg3ltopspike = new ModelRenderer(this, 100, 450);
/* 216 */     this.seg3ltopspike.addBox(-2.0F, -13.0F, -2.0F, 3, 13, 3);
/* 217 */     this.seg3ltopspike.setRotationPoint(10.0F, -10.0F, 48.0F);
/* 218 */     this.seg3ltopspike.setTextureSize(64, 32);
/* 219 */     this.seg3ltopspike.mirror = true;
/* 220 */     setRotation(this.seg3ltopspike, 0.0F, 0.0F, 0.1396263F);
/* 221 */     this.seg3rtopspike = new ModelRenderer(this, 120, 450);
/* 222 */     this.seg3rtopspike.addBox(-2.0F, -13.0F, -2.0F, 3, 13, 3);
/* 223 */     this.seg3rtopspike.setRotationPoint(-10.0F, -10.0F, 48.0F);
/* 224 */     this.seg3rtopspike.setTextureSize(64, 32);
/* 225 */     this.seg3rtopspike.mirror = true;
/* 226 */     setRotation(this.seg3rtopspike, 0.0F, 0.0F, -0.1396263F);
/* 227 */     this.seg3lbackspike = new ModelRenderer(this, 50, 450);
/* 228 */     this.seg3lbackspike.addBox(-2.0F, -20.0F, -2.0F, 4, 20, 4);
/* 229 */     this.seg3lbackspike.setRotationPoint(13.0F, -8.0F, 54.0F);
/* 230 */     this.seg3lbackspike.setTextureSize(64, 32);
/* 231 */     this.seg3lbackspike.mirror = true;
/* 232 */     setRotation(this.seg3lbackspike, -0.9773844F, 0.2792527F, 0.1396263F);
/* 233 */     this.seg3rbackspike = new ModelRenderer(this, 75, 450);
/* 234 */     this.seg3rbackspike.addBox(-2.0F, -20.0F, -2.0F, 4, 20, 4);
/* 235 */     this.seg3rbackspike.setRotationPoint(-13.0F, -8.0F, 54.0F);
/* 236 */     this.seg3rbackspike.setTextureSize(64, 32);
/* 237 */     this.seg3rbackspike.mirror = true;
/* 238 */     setRotation(this.seg3rbackspike, -0.9773844F, -0.3490659F, 0.1396263F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 244 */     CaterKiller e = (CaterKiller)entity;
/* 245 */     float newangle = 0.0F;
/* 246 */     float headoff = 0.0F;
/* 247 */     float zpi = 0.0F;
/* 248 */     float zdist = 0.0F;
/*     */     
/* 250 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 251 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 254 */     if (e.getAttacking() != 0) {
/* 255 */       newangle = MathHelper.cos(f2 * 1.7F * this.wingspeed) * 3.1415927F * 0.07F;
/*     */     } else {
/* 257 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.025F;
/*     */     } 
/* 259 */     this.ljaw.rotateAngleZ = 0.139F + newangle;
/* 260 */     this.rjaw.rotateAngleZ = -0.139F - newangle;
/*     */ 
/*     */     
/* 263 */     if (e.getAttacking() != 0) {
/* 264 */       headoff = MathHelper.cos(f2 * 1.7F * this.wingspeed) * 8.0F;
/*     */     } else {
/* 266 */       headoff = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 2.0F;
/*     */     } 
/* 268 */     this.Head.rotationPointY = -8.0F + headoff;
/* 269 */     this.falsehead.rotationPointY = -8.0F + headoff;
/* 270 */     this.ltusk1.rotationPointY = -25.0F + headoff;
/* 271 */     this.ltusk2.rotationPointY = -25.0F + headoff;
/* 272 */     this.rtusk1.rotationPointY = -25.0F + headoff;
/* 273 */     this.rtusk2.rotationPointY = -25.0F + headoff;
/* 274 */     this.ljaw.rotationPointY = -1.0F + headoff;
/* 275 */     this.rjaw.rotationPointY = -1.0F + headoff;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 282 */     newangle = MathHelper.cos(f2 * 2.11F * this.wingspeed) * 3.1415927F * 0.08F;
/* 283 */     this.ltusk2.rotateAngleY = 0.802F + newangle;
/* 284 */     newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.08F;
/* 285 */     this.rtusk2.rotateAngleY = -0.802F + newangle;
/*     */ 
/*     */     
/* 288 */     this.Head.render(f5);
/* 289 */     this.falsehead.render(f5);
/* 290 */     this.ltusk1.render(f5);
/* 291 */     this.ltusk2.render(f5);
/* 292 */     this.rtusk1.render(f5);
/* 293 */     this.rtusk2.render(f5);
/* 294 */     this.ljaw.render(f5);
/* 295 */     this.rjaw.render(f5);
/*     */     int i;
/* 297 */     for (i = 0; i < 3; i++) {
/* 298 */       this.seg1.rotationPointY = -8.0F + headoff / (i + 1) + (8 * i);
/* 299 */       this.seg1lspike.rotationPointY = -32.0F + headoff / (i + 1) + (8 * i);
/* 300 */       this.seg1rspike.rotationPointY = -32.0F + headoff / (i + 1) + (8 * i);
/* 301 */       this.seg1ltopspike.rotationPointY = -39.0F + headoff / (i + 1) + (8 * i);
/* 302 */       this.seg1rtopspike.rotationPointY = -39.0F + headoff / (i + 1) + (8 * i);
/* 303 */       this.seg1lleg.rotationPointY = -8.0F + headoff / (i + 1) + (8 * i);
/* 304 */       this.seg1rleg.rotationPointY = -8.0F + headoff / (i + 1) + (8 * i);
/*     */       
/* 306 */       this.seg1.rotationPointZ = (-12 + 14 * i);
/* 307 */       this.seg1lspike.rotationPointZ = (-6 + 14 * i);
/* 308 */       this.seg1rspike.rotationPointZ = (-6 + 14 * i);
/* 309 */       this.seg1ltopspike.rotationPointZ = (-6 + 14 * i);
/* 310 */       this.seg1rtopspike.rotationPointZ = (-6 + 14 * i);
/* 311 */       this.seg1lleg.rotationPointZ = (-5 + 14 * i);
/* 312 */       this.seg1rleg.rotationPointZ = (-5 + 14 * i);
/*     */       
/* 314 */       newangle = MathHelper.cos((float)((f2 * 0.91F * this.wingspeed) + 0.39269908169872414D * i)) * 3.1415927F * 0.08F;
/* 315 */       this.seg1lspike.rotateAngleZ = newangle;
/* 316 */       this.seg1rspike.rotateAngleZ = -newangle;
/*     */       
/* 318 */       if (e.getAttacking() != 0) {
/* 319 */         newangle = MathHelper.cos((float)((f2 * 2.91F * this.wingspeed) + 0.39269908169872414D * i)) * 3.1415927F * 0.15F;
/*     */       } else {
/* 321 */         newangle = MathHelper.cos((float)((f2 * 0.35F * this.wingspeed) + 0.39269908169872414D * i)) * 3.1415927F * 0.04F;
/*     */       } 
/*     */       
/* 324 */       this.seg1lleg.rotateAngleX = newangle;
/* 325 */       this.seg1rleg.rotateAngleX = -newangle;
/*     */       
/* 327 */       this.seg1.render(f5);
/* 328 */       this.seg1lspike.render(f5);
/* 329 */       this.seg1rspike.render(f5);
/* 330 */       this.seg1ltopspike.render(f5);
/* 331 */       this.seg1rtopspike.render(f5);
/* 332 */       this.seg1lleg.render(f5);
/* 333 */       this.seg1rleg.render(f5);
/*     */     } 
/*     */     
/* 336 */     for (i = 0; i < 6; i++) {
/*     */       
/* 338 */       zdist = MathHelper.cos(f2 * 1.7F * this.wingspeed + zpi) * 1.5F * f1;
/*     */       
/* 340 */       this.seg2.rotationPointZ = 39.0F + (16.0F + zdist) * i;
/* 341 */       this.seg2lfoot.rotationPointZ = 39.0F + (16.0F + zdist) * i;
/* 342 */       this.seg2rfoot.rotationPointZ = 39.0F + (16.0F + zdist) * i;
/* 343 */       this.seg2ltopspike.rotationPointZ = 39.0F + (16.0F + zdist) * i;
/* 344 */       this.seg2rtopspike.rotationPointZ = 39.0F + (16.0F + zdist) * i;
/* 345 */       this.seg2lspike.rotationPointZ = 39.0F + (16.0F + zdist) * i;
/* 346 */       this.seg2rspike.rotationPointZ = 39.0F + (16.0F + zdist) * i;
/*     */       
/* 348 */       newangle = MathHelper.cos((float)((f2 * 0.4F * this.wingspeed) - 0.39269908169872414D * i)) * 3.1415927F * 0.07F;
/* 349 */       this.seg2lspike.rotateAngleZ = newangle;
/* 350 */       this.seg2rspike.rotateAngleZ = -newangle;
/*     */       
/* 352 */       this.seg2.render(f5);
/* 353 */       this.seg2lfoot.render(f5);
/* 354 */       this.seg2rfoot.render(f5);
/* 355 */       this.seg2ltopspike.render(f5);
/* 356 */       this.seg2rtopspike.render(f5);
/* 357 */       this.seg2lspike.render(f5);
/* 358 */       this.seg2rspike.render(f5);
/*     */       
/* 360 */       zpi += 0.7853982F;
/*     */     } 
/*     */     
/* 363 */     this.seg2rspike.rotationPointZ += 16.0F;
/* 364 */     this.seg3lfoot.rotationPointZ = this.seg3.rotationPointZ;
/* 365 */     this.seg3rfoot.rotationPointZ = this.seg3.rotationPointZ;
/* 366 */     this.seg3lspike.rotationPointZ = this.seg3.rotationPointZ;
/* 367 */     this.seg3rspike.rotationPointZ = this.seg3.rotationPointZ;
/* 368 */     this.seg3ltopspike.rotationPointZ = this.seg3.rotationPointZ;
/* 369 */     this.seg3rtopspike.rotationPointZ = this.seg3.rotationPointZ;
/* 370 */     this.seg3.rotationPointZ += 6.0F;
/* 371 */     this.seg3.rotationPointZ += 6.0F;
/*     */     
/* 373 */     i = 6;
/* 374 */     newangle = MathHelper.cos((float)((f2 * 0.4F * this.wingspeed) - 0.39269908169872414D * i)) * 3.1415927F * 0.07F;
/* 375 */     this.seg3lspike.rotateAngleZ = newangle;
/* 376 */     this.seg3rspike.rotateAngleZ = -newangle;
/*     */     
/* 378 */     newangle = MathHelper.cos(f2 * 0.81F * this.wingspeed) * 3.1415927F * 0.04F;
/* 379 */     this.seg3lbackspike.rotateAngleX = -0.977F + newangle;
/* 380 */     newangle = MathHelper.cos(f2 * 0.87F * this.wingspeed) * 3.1415927F * 0.04F;
/* 381 */     this.seg3rbackspike.rotateAngleX = -0.977F + newangle;
/*     */     
/* 383 */     newangle = MathHelper.cos(f2 * 1.11F * this.wingspeed) * 3.1415927F * 0.04F;
/* 384 */     this.seg3lbackspike.rotateAngleY = 0.28F + newangle;
/* 385 */     newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.04F;
/* 386 */     this.seg3rbackspike.rotateAngleY = -0.28F + newangle;
/*     */     
/* 388 */     this.seg3.render(f5);
/* 389 */     this.seg3lfoot.render(f5);
/* 390 */     this.seg3rfoot.render(f5);
/* 391 */     this.seg3lspike.render(f5);
/* 392 */     this.seg3rspike.render(f5);
/* 393 */     this.seg3ltopspike.render(f5);
/* 394 */     this.seg3rtopspike.render(f5);
/* 395 */     this.seg3lbackspike.render(f5);
/* 396 */     this.seg3rbackspike.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 402 */     model.rotateAngleX = x;
/* 403 */     model.rotateAngleY = y;
/* 404 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 409 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelCaterKiller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */