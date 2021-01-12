/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelRobot4
/*     */   extends ModelBase
/*     */ {
/*  12 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer leftfootfront;
/*     */   
/*     */   ModelRenderer leftfootbase;
/*     */   ModelRenderer leftfootback;
/*     */   ModelRenderer leftfoottip;
/*     */   ModelRenderer leftshin;
/*     */   ModelRenderer leftcalf;
/*     */   ModelRenderer leftkneegaurd;
/*     */   ModelRenderer leftthigh;
/*     */   ModelRenderer rightfootfront;
/*     */   ModelRenderer rightfoottip;
/*     */   ModelRenderer rightfootbase;
/*     */   ModelRenderer rightfootback;
/*     */   ModelRenderer rightshin;
/*     */   ModelRenderer rightcalf;
/*     */   ModelRenderer rightkneegaurd;
/*     */   ModelRenderer rightthigh;
/*     */   ModelRenderer hips;
/*     */   ModelRenderer stomach;
/*     */   ModelRenderer chest;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer head;
/*     */   ModelRenderer righttopspinebase;
/*     */   ModelRenderer lefttopspinebase;
/*     */   ModelRenderer righttopspinetip;
/*     */   ModelRenderer lefttopspinetip;
/*     */   ModelRenderer middlerightspinebase;
/*     */   ModelRenderer middleleftspinebase;
/*     */   ModelRenderer middleleftspinetip;
/*     */   ModelRenderer middlerightspinetip;
/*     */   ModelRenderer torso;
/*     */   ModelRenderer rightsholder;
/*     */   ModelRenderer leftsholder;
/*     */   ModelRenderer rightsholdergaurd;
/*     */   ModelRenderer sheildbase;
/*     */   ModelRenderer sheildtip;
/*     */   ModelRenderer rightupperarm;
/*     */   ModelRenderer rightlowerarm;
/*     */   ModelRenderer sheildend;
/*     */   ModelRenderer leftupperarm;
/*     */   ModelRenderer sholdergaurdtip;
/*     */   ModelRenderer cannonbase;
/*     */   ModelRenderer cannonend;
/*     */   ModelRenderer leftcannonpiece;
/*     */   ModelRenderer topcannonpiece;
/*     */   ModelRenderer rightcannonpiece;
/*     */   ModelRenderer bottomcannonpiece;
/*     */   ModelRenderer glowycannonbit1;
/*     */   ModelRenderer glowycannonbit2;
/*     */   ModelRenderer glowycannonbit3;
/*     */   ModelRenderer glowycannonbit4;
/*     */   ModelRenderer glowycannonbit5;
/*     */   ModelRenderer cannonammo;
/*     */   ModelRenderer lowerrightspinebase;
/*     */   ModelRenderer lowerleftspinebase;
/*     */   ModelRenderer lowerrightspinetip;
/*     */   ModelRenderer lowerleftspinetip;
/*     */   
/*     */   public ModelRobot4(float f1) {
/*  73 */     this.wingspeed = f1;
/*     */     
/*  75 */     this.textureWidth = 512;
/*  76 */     this.textureHeight = 512;
/*     */     
/*  78 */     this.leftfootfront = new ModelRenderer(this, 20, 50);
/*  79 */     this.leftfootfront.addBox(-6.0F, 22.0F, -9.0F, 8, 5, 7);
/*  80 */     this.leftfootfront.setRotationPoint(-8.0F, -3.0F, 6.0F);
/*  81 */     this.leftfootfront.setTextureSize(512, 512);
/*  82 */     this.leftfootfront.mirror = true;
/*  83 */     setRotation(this.leftfootfront, 0.0F, 0.0F, 0.0F);
/*  84 */     this.leftfootbase = new ModelRenderer(this, 20, 100);
/*  85 */     this.leftfootbase.addBox(-4.0F, 22.0F, -4.0F, 4, 5, 5);
/*  86 */     this.leftfootbase.setRotationPoint(-8.0F, -3.0F, 6.0F);
/*  87 */     this.leftfootbase.setTextureSize(512, 512);
/*  88 */     this.leftfootbase.mirror = true;
/*  89 */     setRotation(this.leftfootbase, 0.0F, 0.0F, 0.0F);
/*  90 */     this.leftfootback = new ModelRenderer(this, 20, 150);
/*  91 */     this.leftfootback.addBox(-4.5F, 22.0F, 1.0F, 5, 5, 4);
/*  92 */     this.leftfootback.setRotationPoint(-8.0F, -3.0F, 6.0F);
/*  93 */     this.leftfootback.setTextureSize(512, 512);
/*  94 */     this.leftfootback.mirror = true;
/*  95 */     setRotation(this.leftfootback, 0.0F, 0.0F, 0.0F);
/*  96 */     this.leftfoottip = new ModelRenderer(this, 20, 200);
/*  97 */     this.leftfoottip.addBox(-4.5F, 23.0F, -12.0F, 5, 4, 3);
/*  98 */     this.leftfoottip.setRotationPoint(-8.0F, -3.0F, 6.0F);
/*  99 */     this.leftfoottip.setTextureSize(512, 512);
/* 100 */     this.leftfoottip.mirror = true;
/* 101 */     setRotation(this.leftfoottip, 0.0F, 0.0F, 0.0F);
/* 102 */     this.leftshin = new ModelRenderer(this, 20, 250);
/* 103 */     this.leftshin.addBox(-5.0F, 10.0F, -9.0F, 6, 13, 6);
/* 104 */     this.leftshin.setRotationPoint(-8.0F, -3.0F, 6.0F);
/* 105 */     this.leftshin.setTextureSize(512, 512);
/* 106 */     this.leftshin.mirror = true;
/* 107 */     setRotation(this.leftshin, 0.1745329F, 0.0F, 0.0F);
/* 108 */     this.leftcalf = new ModelRenderer(this, 20, 300);
/* 109 */     this.leftcalf.addBox(-6.0F, 10.0F, -9.0F, 8, 8, 9);
/* 110 */     this.leftcalf.setRotationPoint(-8.0F, -3.0F, 6.0F);
/* 111 */     this.leftcalf.setTextureSize(512, 512);
/* 112 */     this.leftcalf.mirror = true;
/* 113 */     setRotation(this.leftcalf, 0.1745329F, 0.0F, 0.0F);
/* 114 */     this.leftkneegaurd = new ModelRenderer(this, 20, 350);
/* 115 */     this.leftkneegaurd.addBox(-5.5F, 4.0F, -14.0F, 7, 7, 1);
/* 116 */     this.leftkneegaurd.setRotationPoint(-8.0F, -3.0F, 6.0F);
/* 117 */     this.leftkneegaurd.setTextureSize(512, 512);
/* 118 */     this.leftkneegaurd.mirror = true;
/* 119 */     setRotation(this.leftkneegaurd, 0.6283185F, 0.0F, 0.0F);
/* 120 */     this.leftthigh = new ModelRenderer(this, 20, 400);
/* 121 */     this.leftthigh.addBox(-5.0F, 0.0F, -4.0F, 6, 13, 8);
/* 122 */     this.leftthigh.setRotationPoint(-8.0F, -3.0F, 6.0F);
/* 123 */     this.leftthigh.setTextureSize(512, 512);
/* 124 */     this.leftthigh.mirror = true;
/* 125 */     setRotation(this.leftthigh, -0.1745329F, 0.1745329F, 0.0F);
/* 126 */     this.rightfootfront = new ModelRenderer(this, 20, 450);
/* 127 */     this.rightfootfront.addBox(0.0F, 22.0F, -9.0F, 8, 5, 7);
/* 128 */     this.rightfootfront.setRotationPoint(5.0F, -3.0F, 6.0F);
/* 129 */     this.rightfootfront.setTextureSize(512, 512);
/* 130 */     this.rightfootfront.mirror = true;
/* 131 */     setRotation(this.rightfootfront, 0.0F, 0.0F, 0.0F);
/* 132 */     this.rightfoottip = new ModelRenderer(this, 100, 50);
/* 133 */     this.rightfoottip.addBox(1.5F, 23.0F, -12.0F, 5, 4, 3);
/* 134 */     this.rightfoottip.setRotationPoint(5.0F, -3.0F, 6.0F);
/* 135 */     this.rightfoottip.setTextureSize(512, 512);
/* 136 */     this.rightfoottip.mirror = true;
/* 137 */     setRotation(this.rightfoottip, 0.0F, 0.0F, 0.0F);
/* 138 */     this.rightfootbase = new ModelRenderer(this, 100, 150);
/* 139 */     this.rightfootbase.addBox(2.0F, 22.0F, -4.0F, 4, 5, 5);
/* 140 */     this.rightfootbase.setRotationPoint(5.0F, -3.0F, 6.0F);
/* 141 */     this.rightfootbase.setTextureSize(512, 512);
/* 142 */     this.rightfootbase.mirror = true;
/* 143 */     setRotation(this.rightfootbase, 0.0F, 0.0F, 0.0F);
/* 144 */     this.rightfootback = new ModelRenderer(this, 100, 100);
/* 145 */     this.rightfootback.addBox(1.5F, 22.0F, 1.0F, 5, 5, 4);
/* 146 */     this.rightfootback.setRotationPoint(5.0F, -3.0F, 6.0F);
/* 147 */     this.rightfootback.setTextureSize(512, 512);
/* 148 */     this.rightfootback.mirror = true;
/* 149 */     setRotation(this.rightfootback, 0.0F, 0.0F, 0.0F);
/* 150 */     this.rightshin = new ModelRenderer(this, 100, 200);
/* 151 */     this.rightshin.addBox(1.0F, 10.0F, -9.0F, 6, 13, 6);
/* 152 */     this.rightshin.setRotationPoint(5.0F, -3.0F, 6.0F);
/* 153 */     this.rightshin.setTextureSize(512, 512);
/* 154 */     this.rightshin.mirror = true;
/* 155 */     setRotation(this.rightshin, 0.1745329F, 0.0F, 0.0F);
/* 156 */     this.rightcalf = new ModelRenderer(this, 100, 250);
/* 157 */     this.rightcalf.addBox(0.0F, 10.0F, -10.0F, 8, 8, 9);
/* 158 */     this.rightcalf.setRotationPoint(5.0F, -3.0F, 6.0F);
/* 159 */     this.rightcalf.setTextureSize(512, 512);
/* 160 */     this.rightcalf.mirror = true;
/* 161 */     setRotation(this.rightcalf, 0.1745329F, 0.0F, 0.0F);
/* 162 */     this.rightkneegaurd = new ModelRenderer(this, 100, 300);
/* 163 */     this.rightkneegaurd.addBox(0.5F, 4.0F, -15.0F, 7, 7, 1);
/* 164 */     this.rightkneegaurd.setRotationPoint(5.0F, -3.0F, 6.0F);
/* 165 */     this.rightkneegaurd.setTextureSize(512, 512);
/* 166 */     this.rightkneegaurd.mirror = true;
/* 167 */     setRotation(this.rightkneegaurd, 0.6283185F, 0.0F, 0.0F);
/* 168 */     this.rightthigh = new ModelRenderer(this, 100, 400);
/* 169 */     this.rightthigh.addBox(0.0F, 0.0F, -5.0F, 6, 13, 8);
/* 170 */     this.rightthigh.setRotationPoint(5.0F, -3.0F, 6.0F);
/* 171 */     this.rightthigh.setTextureSize(512, 512);
/* 172 */     this.rightthigh.mirror = true;
/* 173 */     setRotation(this.rightthigh, -0.1745329F, -0.1745329F, 0.0F);
/* 174 */     this.rightthigh.mirror = false;
/* 175 */     this.hips = new ModelRenderer(this, 100, 350);
/* 176 */     this.hips.addBox(0.0F, 0.0F, 0.0F, 14, 7, 8);
/* 177 */     this.hips.setRotationPoint(-8.0F, -3.0F, 2.0F);
/* 178 */     this.hips.setTextureSize(512, 512);
/* 179 */     this.hips.mirror = true;
/* 180 */     setRotation(this.hips, 0.1396263F, 0.0F, 0.0F);
/* 181 */     this.stomach = new ModelRenderer(this, 100, 450);
/* 182 */     this.stomach.addBox(0.0F, 0.0F, 0.0F, 12, 6, 7);
/* 183 */     this.stomach.setRotationPoint(-7.0F, -9.0F, 2.0F);
/* 184 */     this.stomach.setTextureSize(512, 512);
/* 185 */     this.stomach.mirror = true;
/* 186 */     setRotation(this.stomach, 0.1396263F, 0.0F, 0.0F);
/* 187 */     this.chest = new ModelRenderer(this, 200, 50);
/* 188 */     this.chest.addBox(0.0F, 0.0F, 0.0F, 18, 12, 13);
/* 189 */     this.chest.setRotationPoint(-10.0F, -23.0F, -4.0F);
/* 190 */     this.chest.setTextureSize(512, 512);
/* 191 */     this.chest.mirror = true;
/* 192 */     setRotation(this.chest, 0.2443461F, 0.0F, 0.0F);
/* 193 */     this.neck = new ModelRenderer(this, 200, 100);
/* 194 */     this.neck.addBox(0.0F, 0.0F, 0.0F, 6, 7, 6);
/* 195 */     this.neck.setRotationPoint(-4.0F, -22.0F, -7.0F);
/* 196 */     this.neck.setTextureSize(512, 512);
/* 197 */     this.neck.mirror = true;
/* 198 */     setRotation(this.neck, 0.8726646F, 0.0F, 0.0F);
/* 199 */     this.head = new ModelRenderer(this, 200, 150);
/* 200 */     this.head.addBox(-3.0F, -3.0F, -5.0F, 6, 6, 8);
/* 201 */     this.head.setRotationPoint(-1.0F, -26.0F, -5.0F);
/* 202 */     this.head.setTextureSize(512, 512);
/* 203 */     this.head.mirror = true;
/* 204 */     setRotation(this.head, 0.5235988F, 0.0F, 0.0F);
/* 205 */     this.righttopspinebase = new ModelRenderer(this, 200, 200);
/* 206 */     this.righttopspinebase.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
/* 207 */     this.righttopspinebase.setRotationPoint(3.0F, -29.0F, 5.0F);
/* 208 */     this.righttopspinebase.setTextureSize(512, 512);
/* 209 */     this.righttopspinebase.mirror = true;
/* 210 */     setRotation(this.righttopspinebase, -0.1396263F, 0.0F, 0.0F);
/* 211 */     this.lefttopspinebase = new ModelRenderer(this, 200, 250);
/* 212 */     this.lefttopspinebase.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
/* 213 */     this.lefttopspinebase.setRotationPoint(-7.0F, -29.0F, 5.0F);
/* 214 */     this.lefttopspinebase.setTextureSize(512, 512);
/* 215 */     this.lefttopspinebase.mirror = true;
/* 216 */     setRotation(this.lefttopspinebase, -0.1396263F, 0.0F, 0.0F);
/* 217 */     this.righttopspinetip = new ModelRenderer(this, 200, 300);
/* 218 */     this.righttopspinetip.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
/* 219 */     this.righttopspinetip.setRotationPoint(3.5F, -35.0F, 8.0F);
/* 220 */     this.righttopspinetip.setTextureSize(512, 512);
/* 221 */     this.righttopspinetip.mirror = true;
/* 222 */     setRotation(this.righttopspinetip, -0.3316126F, 0.0F, 0.0F);
/* 223 */     this.lefttopspinetip = new ModelRenderer(this, 200, 350);
/* 224 */     this.lefttopspinetip.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
/* 225 */     this.lefttopspinetip.setRotationPoint(-6.5F, -35.0F, 8.0F);
/* 226 */     this.lefttopspinetip.setTextureSize(512, 512);
/* 227 */     this.lefttopspinetip.mirror = true;
/* 228 */     setRotation(this.lefttopspinetip, -0.3316126F, 0.0F, 0.0F);
/* 229 */     this.middlerightspinebase = new ModelRenderer(this, 200, 400);
/* 230 */     this.middlerightspinebase.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
/* 231 */     this.middlerightspinebase.setRotationPoint(-6.0F, -25.0F, 14.0F);
/* 232 */     this.middlerightspinebase.setTextureSize(512, 512);
/* 233 */     this.middlerightspinebase.mirror = true;
/* 234 */     setRotation(this.middlerightspinebase, -0.6981317F, 0.0F, 0.0F);
/* 235 */     this.middleleftspinebase = new ModelRenderer(this, 200, 450);
/* 236 */     this.middleleftspinebase.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
/* 237 */     this.middleleftspinebase.setRotationPoint(2.0F, -25.0F, 14.0F);
/* 238 */     this.middleleftspinebase.setTextureSize(512, 512);
/* 239 */     this.middleleftspinebase.mirror = true;
/* 240 */     setRotation(this.middleleftspinebase, -0.6981317F, 0.0F, 0.0F);
/* 241 */     this.middleleftspinetip = new ModelRenderer(this, 300, 50);
/* 242 */     this.middleleftspinetip.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/* 243 */     this.middleleftspinetip.setRotationPoint(2.5F, -28.0F, 18.0F);
/* 244 */     this.middleleftspinetip.setTextureSize(512, 512);
/* 245 */     this.middleleftspinetip.mirror = true;
/* 246 */     setRotation(this.middleleftspinetip, -0.7853982F, 0.0F, 0.0F);
/* 247 */     this.middlerightspinetip = new ModelRenderer(this, 300, 100);
/* 248 */     this.middlerightspinetip.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/* 249 */     this.middlerightspinetip.setRotationPoint(-5.5F, -28.0F, 18.0F);
/* 250 */     this.middlerightspinetip.setTextureSize(512, 512);
/* 251 */     this.middlerightspinetip.mirror = true;
/* 252 */     setRotation(this.middlerightspinetip, -0.7853982F, 0.0F, 0.0F);
/* 253 */     this.torso = new ModelRenderer(this, 300, 150);
/* 254 */     this.torso.addBox(0.0F, 0.0F, 0.0F, 14, 6, 10);
/* 255 */     this.torso.setRotationPoint(-8.0F, -13.0F, 0.0F);
/* 256 */     this.torso.setTextureSize(512, 512);
/* 257 */     this.torso.mirror = true;
/* 258 */     setRotation(this.torso, 0.1396263F, 0.0F, 0.0F);
/* 259 */     this.rightsholder = new ModelRenderer(this, 300, 200);
/* 260 */     this.rightsholder.addBox(0.0F, -3.0F, -3.0F, 6, 6, 6);
/* 261 */     this.rightsholder.setRotationPoint(7.0F, -18.0F, 4.0F);
/* 262 */     this.rightsholder.setTextureSize(512, 512);
/* 263 */     this.rightsholder.mirror = true;
/* 264 */     setRotation(this.rightsholder, 0.0F, 0.0F, 0.0F);
/* 265 */     this.leftsholder = new ModelRenderer(this, 300, 250);
/* 266 */     this.leftsholder.addBox(-6.0F, -3.0F, -3.0F, 6, 6, 6);
/* 267 */     this.leftsholder.setRotationPoint(-9.0F, -18.0F, 4.0F);
/* 268 */     this.leftsholder.setTextureSize(512, 512);
/* 269 */     this.leftsholder.mirror = true;
/* 270 */     setRotation(this.leftsholder, 0.0F, 0.0F, 0.0F);
/* 271 */     this.rightsholdergaurd = new ModelRenderer(this, 300, 300);
/* 272 */     this.rightsholdergaurd.addBox(8.0F, -4.0F, -4.0F, 4, 12, 9);
/* 273 */     this.rightsholdergaurd.setRotationPoint(7.0F, -18.0F, 4.0F);
/* 274 */     this.rightsholdergaurd.setTextureSize(512, 512);
/* 275 */     this.rightsholdergaurd.mirror = true;
/* 276 */     setRotation(this.rightsholdergaurd, -0.2094395F, 0.0F, 0.0F);
/* 277 */     this.sheildbase = new ModelRenderer(this, 300, 350);
/* 278 */     this.sheildbase.addBox(8.0F, -4.0F, -30.0F, 3, 12, 19);
/* 279 */     this.sheildbase.setRotationPoint(7.0F, -18.0F, 4.0F);
/* 280 */     this.sheildbase.setTextureSize(512, 512);
/* 281 */     this.sheildbase.mirror = true;
/* 282 */     setRotation(this.sheildbase, 1.047198F, 0.0F, 0.0F);
/* 283 */     this.sheildtip = new ModelRenderer(this, 300, 400);
/* 284 */     this.sheildtip.addBox(9.0F, -2.0F, -34.0F, 3, 8, 4);
/* 285 */     this.sheildtip.setRotationPoint(6.0F, -18.0F, 4.0F);
/* 286 */     this.sheildtip.setTextureSize(512, 512);
/* 287 */     this.sheildtip.mirror = true;
/* 288 */     setRotation(this.sheildtip, 1.047198F, 0.0F, 0.0F);
/* 289 */     this.rightupperarm = new ModelRenderer(this, 300, 450);
/* 290 */     this.rightupperarm.addBox(3.0F, -1.0F, -4.0F, 6, 13, 6);
/* 291 */     this.rightupperarm.setRotationPoint(7.0F, -18.0F, 4.0F);
/* 292 */     this.rightupperarm.setTextureSize(512, 512);
/* 293 */     this.rightupperarm.mirror = true;
/* 294 */     setRotation(this.rightupperarm, -0.2094395F, 0.0F, 0.0F);
/* 295 */     this.rightlowerarm = new ModelRenderer(this, 350, 50);
/* 296 */     this.rightlowerarm.addBox(3.0F, 0.0F, -25.0F, 6, 6, 14);
/* 297 */     this.rightlowerarm.setRotationPoint(7.0F, -18.0F, 4.0F);
/* 298 */     this.rightlowerarm.setTextureSize(512, 512);
/* 299 */     this.rightlowerarm.mirror = true;
/* 300 */     setRotation(this.rightlowerarm, 1.047198F, 0.0F, 0.0F);
/* 301 */     this.sheildend = new ModelRenderer(this, 350, 100);
/* 302 */     this.sheildend.addBox(8.0F, -1.0F, -11.0F, 3, 8, 4);
/* 303 */     this.sheildend.setRotationPoint(7.0F, -18.0F, 4.0F);
/* 304 */     this.sheildend.setTextureSize(512, 512);
/* 305 */     this.sheildend.mirror = true;
/* 306 */     setRotation(this.sheildend, 1.047198F, 0.0F, 0.0F);
/* 307 */     this.leftupperarm = new ModelRenderer(this, 350, 200);
/* 308 */     this.leftupperarm.addBox(-9.0F, -1.0F, -4.0F, 6, 15, 6);
/* 309 */     this.leftupperarm.setRotationPoint(-9.0F, -18.0F, 4.0F);
/* 310 */     this.leftupperarm.setTextureSize(512, 512);
/* 311 */     this.leftupperarm.mirror = true;
/* 312 */     setRotation(this.leftupperarm, -0.2094395F, 0.0F, 0.0F);
/* 313 */     this.sholdergaurdtip = new ModelRenderer(this, 350, 250);
/* 314 */     this.sholdergaurdtip.addBox(10.0F, -3.0F, -7.0F, 2, 5, 3);
/* 315 */     this.sholdergaurdtip.setRotationPoint(7.0F, -18.0F, 4.0F);
/* 316 */     this.sholdergaurdtip.setTextureSize(512, 512);
/* 317 */     this.sholdergaurdtip.mirror = true;
/* 318 */     setRotation(this.sholdergaurdtip, -0.2094395F, 0.0F, 0.0F);
/* 319 */     this.cannonbase = new ModelRenderer(this, 350, 300);
/* 320 */     this.cannonbase.addBox(-4.0F, 0.0F, -4.0F, 8, 12, 8);
/* 321 */     this.cannonbase.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 322 */     this.cannonbase.setTextureSize(512, 512);
/* 323 */     this.cannonbase.mirror = true;
/* 324 */     setRotation(this.cannonbase, -0.6981317F, 0.0F, 0.0F);
/* 325 */     this.cannonend = new ModelRenderer(this, 350, 400);
/* 326 */     this.cannonend.addBox(-3.0F, 11.0F, -3.0F, 6, 4, 6);
/* 327 */     this.cannonend.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 328 */     this.cannonend.setTextureSize(512, 512);
/* 329 */     this.cannonend.mirror = true;
/* 330 */     setRotation(this.cannonend, -0.6981317F, 0.0F, 0.0F);
/* 331 */     this.leftcannonpiece = new ModelRenderer(this, 20, 20);
/* 332 */     this.leftcannonpiece.addBox(-5.0F, 11.0F, -1.5F, 3, 6, 3);
/* 333 */     this.leftcannonpiece.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 334 */     this.leftcannonpiece.setTextureSize(512, 512);
/* 335 */     this.leftcannonpiece.mirror = true;
/* 336 */     setRotation(this.leftcannonpiece, -0.6981317F, 0.0F, 0.0F);
/* 337 */     this.topcannonpiece = new ModelRenderer(this, 40, 20);
/* 338 */     this.topcannonpiece.addBox(-1.5F, 11.0F, -5.0F, 3, 6, 3);
/* 339 */     this.topcannonpiece.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 340 */     this.topcannonpiece.setTextureSize(512, 512);
/* 341 */     this.topcannonpiece.mirror = true;
/* 342 */     setRotation(this.topcannonpiece, -0.6981317F, 0.0F, 0.0F);
/* 343 */     this.rightcannonpiece = new ModelRenderer(this, 80, 20);
/* 344 */     this.rightcannonpiece.addBox(2.0F, 11.0F, -1.5F, 3, 6, 3);
/* 345 */     this.rightcannonpiece.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 346 */     this.rightcannonpiece.setTextureSize(512, 512);
/* 347 */     this.rightcannonpiece.mirror = true;
/* 348 */     setRotation(this.rightcannonpiece, -0.6981317F, 0.0F, 0.0F);
/* 349 */     this.bottomcannonpiece = new ModelRenderer(this, 100, 20);
/* 350 */     this.bottomcannonpiece.addBox(-1.5F, 11.0F, 2.0F, 3, 6, 3);
/* 351 */     this.bottomcannonpiece.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 352 */     this.bottomcannonpiece.setTextureSize(512, 512);
/* 353 */     this.bottomcannonpiece.mirror = true;
/* 354 */     setRotation(this.bottomcannonpiece, -0.6981317F, 0.0F, 0.0F);
/* 355 */     this.glowycannonbit1 = new ModelRenderer(this, 150, 20);
/* 356 */     this.glowycannonbit1.addBox(-3.5F, 0.0F, -11.0F, 2, 5, 2);
/* 357 */     this.glowycannonbit1.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 358 */     this.glowycannonbit1.setTextureSize(512, 512);
/* 359 */     this.glowycannonbit1.mirror = true;
/* 360 */     setRotation(this.glowycannonbit1, 0.1745329F, 0.0F, 0.0F);
/* 361 */     this.glowycannonbit2 = new ModelRenderer(this, 200, 20);
/* 362 */     this.glowycannonbit2.addBox(1.5F, 0.0F, -11.0F, 2, 5, 2);
/* 363 */     this.glowycannonbit2.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 364 */     this.glowycannonbit2.setTextureSize(512, 512);
/* 365 */     this.glowycannonbit2.mirror = true;
/* 366 */     setRotation(this.glowycannonbit2, 0.1745329F, 0.0F, 0.0F);
/* 367 */     this.glowycannonbit3 = new ModelRenderer(this, 250, 20);
/* 368 */     this.glowycannonbit3.addBox(-3.0F, -2.0F, -8.0F, 2, 5, 2);
/* 369 */     this.glowycannonbit3.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 370 */     this.glowycannonbit3.setTextureSize(512, 512);
/* 371 */     this.glowycannonbit3.mirror = true;
/* 372 */     setRotation(this.glowycannonbit3, 0.0872665F, 0.0F, 0.0F);
/* 373 */     this.glowycannonbit4 = new ModelRenderer(this, 300, 20);
/* 374 */     this.glowycannonbit4.addBox(1.0F, -2.0F, -8.0F, 2, 5, 2);
/* 375 */     this.glowycannonbit4.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 376 */     this.glowycannonbit4.setTextureSize(512, 512);
/* 377 */     this.glowycannonbit4.mirror = true;
/* 378 */     setRotation(this.glowycannonbit4, 0.0872665F, 0.0F, 0.0F);
/* 379 */     this.glowycannonbit5 = new ModelRenderer(this, 350, 20);
/* 380 */     this.glowycannonbit5.addBox(-1.0F, -5.0F, -5.0F, 2, 5, 2);
/* 381 */     this.glowycannonbit5.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 382 */     this.glowycannonbit5.setTextureSize(512, 512);
/* 383 */     this.glowycannonbit5.mirror = true;
/* 384 */     setRotation(this.glowycannonbit5, 0.0F, 0.0F, 0.0F);
/* 385 */     this.cannonammo = new ModelRenderer(this, 400, 400);
/* 386 */     this.cannonammo.addBox(-6.0F, 3.0F, 0.0F, 5, 5, 5);
/* 387 */     this.cannonammo.setRotationPoint(-15.0F, -5.0F, 1.0F);
/* 388 */     this.cannonammo.setTextureSize(512, 512);
/* 389 */     this.cannonammo.mirror = true;
/* 390 */     setRotation(this.cannonammo, -0.6981317F, 0.0F, 0.0F);
/* 391 */     this.lowerrightspinebase = new ModelRenderer(this, 400, 450);
/* 392 */     this.lowerrightspinebase.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
/* 393 */     this.lowerrightspinebase.setRotationPoint(4.0F, -19.0F, 15.0F);
/* 394 */     this.lowerrightspinebase.setTextureSize(512, 512);
/* 395 */     this.lowerrightspinebase.mirror = true;
/* 396 */     setRotation(this.lowerrightspinebase, -1.047198F, 0.0F, 0.0F);
/* 397 */     this.lowerleftspinebase = new ModelRenderer(this, 360, 450);
/* 398 */     this.lowerleftspinebase.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
/* 399 */     this.lowerleftspinebase.setRotationPoint(-8.0F, -19.0F, 15.0F);
/* 400 */     this.lowerleftspinebase.setTextureSize(512, 512);
/* 401 */     this.lowerleftspinebase.mirror = true;
/* 402 */     setRotation(this.lowerleftspinebase, -1.047198F, 0.0F, 0.0F);
/* 403 */     this.lowerrightspinetip = new ModelRenderer(this, 250, 100);
/* 404 */     this.lowerrightspinetip.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/* 405 */     this.lowerrightspinetip.setRotationPoint(4.5F, -21.0F, 20.0F);
/* 406 */     this.lowerrightspinetip.setTextureSize(512, 512);
/* 407 */     this.lowerrightspinetip.mirror = true;
/* 408 */     setRotation(this.lowerrightspinetip, -1.134464F, 0.0F, 0.0F);
/* 409 */     this.lowerleftspinetip = new ModelRenderer(this, 150, 100);
/* 410 */     this.lowerleftspinetip.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/* 411 */     this.lowerleftspinetip.setRotationPoint(-7.5F, -21.0F, 20.0F);
/* 412 */     this.lowerleftspinetip.setTextureSize(512, 512);
/* 413 */     this.lowerleftspinetip.mirror = true;
/* 414 */     setRotation(this.lowerleftspinetip, -1.134464F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 421 */     Robot4 e = (Robot4)entity;
/* 422 */     float newangle = 0.0F;
/* 423 */     float nextangle = 0.0F;
/* 424 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 425 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 428 */     if (f1 > 0.1D) {
/* 429 */       newangle = MathHelper.cos(f2 * 0.5F * this.wingspeed) * 3.1415927F * 0.15F * f1;
/*     */     } else {
/* 431 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 434 */     this.leftfootfront.rotateAngleX = newangle;
/* 435 */     this.leftfootbase.rotateAngleX = newangle;
/* 436 */     this.leftfootback.rotateAngleX = newangle;
/* 437 */     this.leftfoottip.rotateAngleX = newangle;
/* 438 */     this.leftshin.rotateAngleX = newangle;
/* 439 */     this.leftcalf.rotateAngleX = newangle + 0.175F;
/* 440 */     this.leftkneegaurd.rotateAngleX = newangle + 0.63F;
/* 441 */     this.leftthigh.rotateAngleX = newangle - 0.175F;
/* 442 */     this.rightfootfront.rotateAngleX = -newangle;
/* 443 */     this.rightfoottip.rotateAngleX = -newangle;
/* 444 */     this.rightfootbase.rotateAngleX = -newangle;
/* 445 */     this.rightfootback.rotateAngleX = -newangle;
/* 446 */     this.rightshin.rotateAngleX = -newangle;
/* 447 */     this.rightcalf.rotateAngleX = -newangle + 0.175F;
/* 448 */     this.rightkneegaurd.rotateAngleX = -newangle + 0.63F;
/* 449 */     this.rightthigh.rotateAngleX = -newangle - 0.175F;
/*     */     
/* 451 */     this.head.rotateAngleY = (float)Math.toRadians(f3 / 1.5D);
/*     */     
/* 453 */     float amp = 0.7853982F;
/* 454 */     if (e.getAttacking() != 0) {
/* 455 */       newangle = MathHelper.cos((float)Math.toRadians((f2 % 360.0F)) * this.wingspeed * 6.0F) * amp;
/* 456 */       newangle = Math.abs(newangle);
/* 457 */       newangle += 0.75F;
/*     */     } else {
/* 459 */       newangle = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 463 */     if (newangle > amp / 3.0D) {
/*     */ 
/*     */       
/* 466 */       e.setShielding(1);
/*     */     } else {
/* 468 */       e.setShielding(0);
/*     */     } 
/*     */     
/* 471 */     this.rightsholder.rotateAngleX = -newangle;
/* 472 */     this.rightsholdergaurd.rotateAngleX = -newangle - 0.21F;
/* 473 */     this.sheildbase.rotateAngleX = -newangle + 1.047F;
/* 474 */     this.sheildtip.rotateAngleX = -newangle + 1.047F;
/* 475 */     this.rightupperarm.rotateAngleX = -newangle - 0.21F;
/* 476 */     this.rightlowerarm.rotateAngleX = -newangle + 1.047F;
/* 477 */     this.sheildend.rotateAngleX = -newangle + 1.04F;
/* 478 */     this.sholdergaurdtip.rotateAngleX = -newangle - 0.21F;
/*     */     
/* 480 */     if (e.getAttacking() != 0) {
/* 481 */       newangle = 0.85F;
/*     */     } else {
/* 483 */       newangle = 0.0F;
/*     */     } 
/* 485 */     this.leftsholder.rotateAngleX = -newangle;
/* 486 */     this.leftupperarm.rotateAngleX = -newangle - 0.21F;
/*     */     
/* 488 */     this.cannonbase.rotateAngleX = -newangle - 0.7F;
/* 489 */     this.cannonend.rotateAngleX = -newangle - 0.7F;
/* 490 */     this.leftcannonpiece.rotateAngleX = -newangle - 0.7F;
/* 491 */     this.topcannonpiece.rotateAngleX = -newangle - 0.7F;
/* 492 */     this.rightcannonpiece.rotateAngleX = -newangle - 0.7F;
/* 493 */     this.bottomcannonpiece.rotateAngleX = -newangle - 0.7F;
/* 494 */     this.glowycannonbit1.rotateAngleX = -newangle + 0.17F;
/* 495 */     this.glowycannonbit2.rotateAngleX = -newangle + 0.17F;
/* 496 */     this.glowycannonbit3.rotateAngleX = -newangle + 0.08F;
/* 497 */     this.glowycannonbit4.rotateAngleX = -newangle + 0.08F;
/* 498 */     this.glowycannonbit5.rotateAngleX = -newangle;
/* 499 */     this.cannonammo.rotateAngleX = -newangle - 0.7F;
/*     */ 
/*     */     
/* 502 */     double newposy = (float)(this.leftsholder.rotationPointY + Math.cos(this.leftupperarm.rotateAngleX) * 14.0D);
/* 503 */     double newposz = (float)(this.leftsholder.rotationPointZ + Math.sin(this.leftupperarm.rotateAngleX) * 14.0D);
/* 504 */     this.cannonbase.rotationPointY = (float)newposy;
/* 505 */     this.cannonbase.rotationPointZ = (float)newposz;
/* 506 */     this.cannonend.rotationPointY = (float)newposy;
/* 507 */     this.cannonend.rotationPointZ = (float)newposz;
/* 508 */     this.leftcannonpiece.rotationPointY = (float)newposy;
/* 509 */     this.leftcannonpiece.rotationPointZ = (float)newposz;
/* 510 */     this.topcannonpiece.rotationPointY = (float)newposy;
/* 511 */     this.topcannonpiece.rotationPointZ = (float)newposz;
/* 512 */     this.rightcannonpiece.rotationPointY = (float)newposy;
/* 513 */     this.rightcannonpiece.rotationPointZ = (float)newposz;
/* 514 */     this.bottomcannonpiece.rotationPointY = (float)newposy;
/* 515 */     this.bottomcannonpiece.rotationPointZ = (float)newposz;
/* 516 */     this.glowycannonbit1.rotationPointY = (float)newposy;
/* 517 */     this.glowycannonbit1.rotationPointZ = (float)newposz;
/* 518 */     this.glowycannonbit2.rotationPointY = (float)newposy;
/* 519 */     this.glowycannonbit2.rotationPointZ = (float)newposz;
/* 520 */     this.glowycannonbit3.rotationPointY = (float)newposy;
/* 521 */     this.glowycannonbit3.rotationPointZ = (float)newposz;
/* 522 */     this.glowycannonbit4.rotationPointY = (float)newposy;
/* 523 */     this.glowycannonbit4.rotationPointZ = (float)newposz;
/* 524 */     this.glowycannonbit5.rotationPointY = (float)newposy;
/* 525 */     this.glowycannonbit5.rotationPointZ = (float)newposz;
/* 526 */     this.cannonammo.rotationPointY = (float)newposy;
/* 527 */     this.cannonammo.rotationPointZ = (float)newposz;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 532 */     this.leftfootfront.render(f5);
/* 533 */     this.leftfootbase.render(f5);
/* 534 */     this.leftfootback.render(f5);
/* 535 */     this.leftfoottip.render(f5);
/* 536 */     this.leftshin.render(f5);
/* 537 */     this.leftcalf.render(f5);
/* 538 */     this.leftkneegaurd.render(f5);
/* 539 */     this.leftthigh.render(f5);
/* 540 */     this.rightfootfront.render(f5);
/* 541 */     this.rightfoottip.render(f5);
/* 542 */     this.rightfootbase.render(f5);
/* 543 */     this.rightfootback.render(f5);
/* 544 */     this.rightshin.render(f5);
/* 545 */     this.rightcalf.render(f5);
/* 546 */     this.rightkneegaurd.render(f5);
/* 547 */     this.rightthigh.render(f5);
/* 548 */     this.hips.render(f5);
/* 549 */     this.stomach.render(f5);
/* 550 */     this.chest.render(f5);
/* 551 */     this.neck.render(f5);
/* 552 */     this.head.render(f5);
/* 553 */     this.righttopspinebase.render(f5);
/* 554 */     this.lefttopspinebase.render(f5);
/* 555 */     this.righttopspinetip.render(f5);
/* 556 */     this.lefttopspinetip.render(f5);
/* 557 */     this.middlerightspinebase.render(f5);
/* 558 */     this.middleleftspinebase.render(f5);
/* 559 */     this.middleleftspinetip.render(f5);
/* 560 */     this.middlerightspinetip.render(f5);
/* 561 */     this.torso.render(f5);
/* 562 */     this.rightsholder.render(f5);
/* 563 */     this.leftsholder.render(f5);
/* 564 */     this.rightsholdergaurd.render(f5);
/* 565 */     this.sheildbase.render(f5);
/* 566 */     this.sheildtip.render(f5);
/* 567 */     this.rightupperarm.render(f5);
/* 568 */     this.rightlowerarm.render(f5);
/* 569 */     this.sheildend.render(f5);
/* 570 */     this.leftupperarm.render(f5);
/* 571 */     this.sholdergaurdtip.render(f5);
/* 572 */     this.cannonbase.render(f5);
/* 573 */     this.cannonend.render(f5);
/* 574 */     this.leftcannonpiece.render(f5);
/* 575 */     this.topcannonpiece.render(f5);
/* 576 */     this.rightcannonpiece.render(f5);
/* 577 */     this.bottomcannonpiece.render(f5);
/* 578 */     this.glowycannonbit1.render(f5);
/* 579 */     this.glowycannonbit2.render(f5);
/* 580 */     this.glowycannonbit3.render(f5);
/* 581 */     this.glowycannonbit4.render(f5);
/* 582 */     this.glowycannonbit5.render(f5);
/* 583 */     this.cannonammo.render(f5);
/* 584 */     this.lowerrightspinebase.render(f5);
/* 585 */     this.lowerleftspinebase.render(f5);
/* 586 */     this.lowerrightspinetip.render(f5);
/* 587 */     this.lowerleftspinetip.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 593 */     model.rotateAngleX = x;
/* 594 */     model.rotateAngleY = y;
/* 595 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 600 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelRobot4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */