/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelSpiderRobot
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Leg1p1;
/*     */   
/*     */   ModelRenderer Leg1p2;
/*     */   ModelRenderer Leg1p3;
/*     */   ModelRenderer Foot;
/*     */   ModelRenderer FootSpike1;
/*     */   ModelRenderer FootSpike2;
/*     */   ModelRenderer FootSpike3;
/*     */   ModelRenderer FootSpike4;
/*     */   ModelRenderer AnkleSpike1;
/*     */   ModelRenderer AnkleSpike2;
/*     */   ModelRenderer AnkleSpike3;
/*     */   ModelRenderer AnkleSpike4;
/*     */   ModelRenderer LowerKnee;
/*     */   ModelRenderer UpperKnee;
/*     */   ModelRenderer LegBump1;
/*     */   ModelRenderer LegBump2;
/*     */   ModelRenderer LowerKnee2;
/*     */   ModelRenderer UpperKnee2;
/*     */   ModelRenderer HipJoint;
/*     */   ModelRenderer BodyCenter;
/*     */   ModelRenderer Abdomen;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer Ljaw1;
/*     */   ModelRenderer Rjaw1;
/*     */   ModelRenderer Ljaw2;
/*     */   ModelRenderer Rjaw2;
/*     */   ModelRenderer Ljaw3;
/*     */   ModelRenderer Rjaw3;
/*     */   ModelRenderer Tail;
/*     */   ModelRenderer HeadSpike1;
/*     */   ModelRenderer HeadSpike2;
/*     */   ModelRenderer Hip1;
/*     */   ModelRenderer Hip2;
/*     */   ModelRenderer Hip3;
/*     */   ModelRenderer Hip4;
/*     */   ModelRenderer Hip5;
/*     */   ModelRenderer Hip6;
/*     */   ModelRenderer Hip7;
/*     */   ModelRenderer Hip8;
/*     */   
/*     */   public ModelSpiderRobot(float f1) {
/*  55 */     this.wingspeed = f1;
/*  56 */     this.textureWidth = 256;
/*  57 */     this.textureHeight = 512;
/*     */     
/*  59 */     this.Leg1p1 = new ModelRenderer(this, 0, 149);
/*  60 */     this.Leg1p1.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 100);
/*  61 */     this.Leg1p1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  62 */     this.Leg1p1.setTextureSize(64, 32);
/*  63 */     this.Leg1p1.mirror = true;
/*  64 */     setRotation(this.Leg1p1, 0.7853982F, 0.0F, 0.0F);
/*  65 */     this.Leg1p2 = new ModelRenderer(this, 0, 149);
/*  66 */     this.Leg1p2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 100);
/*  67 */     this.Leg1p2.setRotationPoint(0.0F, -70.0F, 70.0F);
/*  68 */     this.Leg1p2.setTextureSize(64, 32);
/*  69 */     this.Leg1p2.mirror = true;
/*  70 */     setRotation(this.Leg1p2, 0.0F, 0.0F, 0.0F);
/*  71 */     this.Leg1p3 = new ModelRenderer(this, 0, 149);
/*  72 */     this.Leg1p3.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 100);
/*  73 */     this.Leg1p3.setRotationPoint(0.0F, -70.0F, 169.0F);
/*  74 */     this.Leg1p3.setTextureSize(64, 32);
/*  75 */     this.Leg1p3.mirror = true;
/*  76 */     setRotation(this.Leg1p3, -0.7853982F, 0.0F, 0.0F);
/*  77 */     this.Foot = new ModelRenderer(this, 0, 28);
/*  78 */     this.Foot.addBox(-3.0F, -3.0F, 93.0F, 6, 6, 6);
/*  79 */     this.Foot.setRotationPoint(0.0F, -70.0F, 169.0F);
/*  80 */     this.Foot.setTextureSize(64, 32);
/*  81 */     this.Foot.mirror = true;
/*  82 */     setRotation(this.Foot, -0.7853982F, 0.0F, 0.0F);
/*  83 */     this.FootSpike1 = new ModelRenderer(this, 29, 27);
/*  84 */     this.FootSpike1.addBox(2.0F, 2.0F, 99.0F, 1, 1, 5);
/*  85 */     this.FootSpike1.setRotationPoint(0.0F, -70.0F, 169.0F);
/*  86 */     this.FootSpike1.setTextureSize(64, 32);
/*  87 */     this.FootSpike1.mirror = true;
/*  88 */     setRotation(this.FootSpike1, -0.7853982F, 0.0F, 0.0F);
/*  89 */     this.FootSpike2 = new ModelRenderer(this, 29, 34);
/*  90 */     this.FootSpike2.addBox(-3.0F, 2.0F, 99.0F, 1, 1, 5);
/*  91 */     this.FootSpike2.setRotationPoint(0.0F, -70.0F, 169.0F);
/*  92 */     this.FootSpike2.setTextureSize(64, 32);
/*  93 */     this.FootSpike2.mirror = true;
/*  94 */     setRotation(this.FootSpike2, -0.7853982F, 0.0F, 0.0F);
/*  95 */     this.FootSpike3 = new ModelRenderer(this, 43, 27);
/*  96 */     this.FootSpike3.addBox(2.0F, -3.0F, 99.0F, 1, 1, 5);
/*  97 */     this.FootSpike3.setRotationPoint(0.0F, -70.0F, 169.0F);
/*  98 */     this.FootSpike3.setTextureSize(64, 32);
/*  99 */     this.FootSpike3.mirror = true;
/* 100 */     setRotation(this.FootSpike3, -0.7853982F, 0.0F, 0.0F);
/* 101 */     this.FootSpike4 = new ModelRenderer(this, 43, 34);
/* 102 */     this.FootSpike4.addBox(-3.0F, -3.0F, 99.0F, 1, 1, 5);
/* 103 */     this.FootSpike4.setRotationPoint(0.0F, -70.0F, 169.0F);
/* 104 */     this.FootSpike4.setTextureSize(64, 32);
/* 105 */     this.FootSpike4.mirror = true;
/* 106 */     setRotation(this.FootSpike4, -0.7853982F, 0.0F, 0.0F);
/* 107 */     this.AnkleSpike1 = new ModelRenderer(this, 1, 42);
/* 108 */     this.AnkleSpike1.addBox(3.0F, -10.0F, 92.0F, 1, 20, 1);
/* 109 */     this.AnkleSpike1.setRotationPoint(0.0F, -70.0F, 169.0F);
/* 110 */     this.AnkleSpike1.setTextureSize(64, 32);
/* 111 */     this.AnkleSpike1.mirror = true;
/* 112 */     setRotation(this.AnkleSpike1, -0.7853982F, 0.0F, 0.0F);
/* 113 */     this.AnkleSpike2 = new ModelRenderer(this, 7, 42);
/* 114 */     this.AnkleSpike2.addBox(-4.0F, -10.0F, 92.0F, 1, 20, 1);
/* 115 */     this.AnkleSpike2.setRotationPoint(0.0F, -70.0F, 169.0F);
/* 116 */     this.AnkleSpike2.setTextureSize(64, 32);
/* 117 */     this.AnkleSpike2.mirror = true;
/* 118 */     setRotation(this.AnkleSpike2, -0.7853982F, 0.0F, 0.0F);
/* 119 */     this.AnkleSpike3 = new ModelRenderer(this, 14, 42);
/* 120 */     this.AnkleSpike3.addBox(-10.0F, 3.0F, 92.0F, 20, 1, 1);
/* 121 */     this.AnkleSpike3.setRotationPoint(0.0F, -70.0F, 169.0F);
/* 122 */     this.AnkleSpike3.setTextureSize(64, 32);
/* 123 */     this.AnkleSpike3.mirror = true;
/* 124 */     setRotation(this.AnkleSpike3, -0.7853982F, 0.0F, 0.0F);
/* 125 */     this.AnkleSpike4 = new ModelRenderer(this, 14, 46);
/* 126 */     this.AnkleSpike4.addBox(-10.0F, -4.0F, 92.0F, 20, 1, 1);
/* 127 */     this.AnkleSpike4.setRotationPoint(0.0F, -70.0F, 169.0F);
/* 128 */     this.AnkleSpike4.setTextureSize(64, 32);
/* 129 */     this.AnkleSpike4.mirror = true;
/* 130 */     setRotation(this.AnkleSpike4, -0.7853982F, 0.0F, 0.0F);
/* 131 */     this.LowerKnee = new ModelRenderer(this, 14, 49);
/* 132 */     this.LowerKnee.addBox(-1.5F, -1.5F, -1.0F, 3, 3, 15);
/* 133 */     this.LowerKnee.setRotationPoint(0.0F, -70.0F, 169.0F);
/* 134 */     this.LowerKnee.setTextureSize(64, 32);
/* 135 */     this.LowerKnee.mirror = true;
/* 136 */     setRotation(this.LowerKnee, -0.7853982F, 0.0F, 0.0F);
/* 137 */     this.UpperKnee = new ModelRenderer(this, 0, 69);
/* 138 */     this.UpperKnee.addBox(-2.5F, -2.5F, 81.0F, 5, 5, 20);
/* 139 */     this.UpperKnee.setRotationPoint(0.0F, -70.0F, 70.0F);
/* 140 */     this.UpperKnee.setTextureSize(64, 32);
/* 141 */     this.UpperKnee.mirror = true;
/* 142 */     setRotation(this.UpperKnee, 0.0F, 0.0F, 0.0F);
/* 143 */     this.LegBump1 = new ModelRenderer(this, 52, 50);
/* 144 */     this.LegBump1.addBox(-0.5F, -2.0F, 80.0F, 1, 1, 1);
/* 145 */     this.LegBump1.setRotationPoint(0.0F, -70.0F, 169.0F);
/* 146 */     this.LegBump1.setTextureSize(64, 32);
/* 147 */     this.LegBump1.mirror = true;
/* 148 */     setRotation(this.LegBump1, -0.7853982F, 0.0F, 0.0F);
/* 149 */     this.LegBump2 = new ModelRenderer(this, 52, 54);
/* 150 */     this.LegBump2.addBox(-0.5F, -2.0F, 70.0F, 1, 1, 1);
/* 151 */     this.LegBump2.setRotationPoint(0.0F, -70.0F, 169.0F);
/* 152 */     this.LegBump2.setTextureSize(64, 32);
/* 153 */     this.LegBump2.mirror = true;
/* 154 */     setRotation(this.LegBump2, -0.7853982F, 0.0F, 0.0F);
/* 155 */     this.LowerKnee2 = new ModelRenderer(this, 0, 96);
/* 156 */     this.LowerKnee2.addBox(-2.5F, -2.5F, -1.0F, 5, 5, 15);
/* 157 */     this.LowerKnee2.setRotationPoint(0.0F, -70.0F, 70.0F);
/* 158 */     this.LowerKnee2.setTextureSize(64, 32);
/* 159 */     this.LowerKnee2.mirror = true;
/* 160 */     setRotation(this.LowerKnee2, 0.0F, 0.0F, 0.0F);
/* 161 */     this.UpperKnee2 = new ModelRenderer(this, 0, 119);
/* 162 */     this.UpperKnee2.addBox(-3.0F, -3.0F, 81.0F, 6, 6, 20);
/* 163 */     this.UpperKnee2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 164 */     this.UpperKnee2.setTextureSize(64, 32);
/* 165 */     this.UpperKnee2.mirror = true;
/* 166 */     setRotation(this.UpperKnee2, 0.7853982F, 0.0F, 0.0F);
/* 167 */     this.HipJoint = new ModelRenderer(this, 0, 149);
/* 168 */     this.HipJoint.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 16);
/* 169 */     this.HipJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 170 */     this.HipJoint.setTextureSize(64, 32);
/* 171 */     this.HipJoint.mirror = true;
/* 172 */     setRotation(this.HipJoint, 0.7853982F, 0.0F, 0.0F);
/* 173 */     this.BodyCenter = new ModelRenderer(this, 0, 321);
/* 174 */     this.BodyCenter.addBox(-18.0F, -12.0F, -21.0F, 36, 24, 51);
/* 175 */     this.BodyCenter.setRotationPoint(0.0F, -4.0F, 0.0F);
/* 176 */     this.BodyCenter.setTextureSize(64, 32);
/* 177 */     this.BodyCenter.mirror = true;
/* 178 */     setRotation(this.BodyCenter, 0.0F, 0.0F, 0.0F);
/* 179 */     this.Abdomen = new ModelRenderer(this, 0, 398);
/* 180 */     this.Abdomen.addBox(-24.0F, -30.0F, 29.0F, 48, 40, 73);
/* 181 */     this.Abdomen.setRotationPoint(0.0F, -4.0F, 0.0F);
/* 182 */     this.Abdomen.setTextureSize(64, 32);
/* 183 */     this.Abdomen.mirror = true;
/* 184 */     setRotation(this.Abdomen, 0.0F, 0.0F, 0.0F);
/* 185 */     this.Head = new ModelRenderer(this, 0, 256);
/* 186 */     this.Head.addBox(-15.0F, -16.0F, -57.0F, 30, 26, 36);
/* 187 */     this.Head.setRotationPoint(0.0F, -4.0F, 0.0F);
/* 188 */     this.Head.setTextureSize(64, 32);
/* 189 */     this.Head.mirror = true;
/* 190 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/* 191 */     this.Ljaw1 = new ModelRenderer(this, 75, 26);
/* 192 */     this.Ljaw1.addBox(-4.0F, 0.0F, -4.0F, 8, 3, 8);
/* 193 */     this.Ljaw1.setRotationPoint(14.0F, -3.0F, -56.0F);
/* 194 */     this.Ljaw1.setTextureSize(64, 32);
/* 195 */     this.Ljaw1.mirror = true;
/* 196 */     setRotation(this.Ljaw1, 0.0F, 0.0F, 0.0F);
/* 197 */     this.Rjaw1 = new ModelRenderer(this, 75, 26);
/* 198 */     this.Rjaw1.addBox(-4.0F, 0.0F, -4.0F, 8, 3, 8);
/* 199 */     this.Rjaw1.setRotationPoint(-14.0F, -3.0F, -56.0F);
/* 200 */     this.Rjaw1.setTextureSize(64, 32);
/* 201 */     this.Rjaw1.mirror = true;
/* 202 */     setRotation(this.Rjaw1, 0.0F, 0.0F, 0.0F);
/* 203 */     this.Ljaw2 = new ModelRenderer(this, 63, 40);
/* 204 */     this.Ljaw2.addBox(0.0F, 1.0F, -3.0F, 21, 2, 6);
/* 205 */     this.Ljaw2.setRotationPoint(14.0F, -3.0F, -56.0F);
/* 206 */     this.Ljaw2.setTextureSize(64, 32);
/* 207 */     this.Ljaw2.mirror = true;
/* 208 */     setRotation(this.Ljaw2, 0.0F, 0.7504916F, 0.0F);
/* 209 */     this.Rjaw2 = new ModelRenderer(this, 63, 40);
/* 210 */     this.Rjaw2.addBox(0.0F, 1.0F, -3.0F, 21, 2, 6);
/* 211 */     this.Rjaw2.setRotationPoint(-14.0F, -3.0F, -56.0F);
/* 212 */     this.Rjaw2.setTextureSize(64, 32);
/* 213 */     this.Rjaw2.mirror = true;
/* 214 */     setRotation(this.Rjaw2, 0.0F, 2.303835F, 0.0F);
/* 215 */     this.Ljaw3 = new ModelRenderer(this, 0, 18);
/* 216 */     this.Ljaw3.addBox(11.0F, 2.0F, 14.0F, 23, 1, 4);
/* 217 */     this.Ljaw3.setRotationPoint(14.0F, -3.0F, -56.0F);
/* 218 */     this.Ljaw3.setTextureSize(64, 32);
/* 219 */     this.Ljaw3.mirror = true;
/* 220 */     setRotation(this.Ljaw3, 0.0F, 1.710423F, 0.0F);
/* 221 */     this.Rjaw3 = new ModelRenderer(this, 0, 18);
/* 222 */     this.Rjaw3.addBox(11.0F, 2.0F, -17.0F, 23, 1, 4);
/* 223 */     this.Rjaw3.setRotationPoint(-14.0F, -3.0F, -56.0F);
/* 224 */     this.Rjaw3.setTextureSize(64, 32);
/* 225 */     this.Rjaw3.mirror = true;
/* 226 */     setRotation(this.Rjaw3, 0.0F, 1.413717F, 0.0F);
/* 227 */     this.Tail = new ModelRenderer(this, 130, 0);
/* 228 */     this.Tail.addBox(-5.0F, -5.0F, -5.0F, 10, 10, 49);
/* 229 */     this.Tail.setRotationPoint(0.0F, -32.0F, 69.0F);
/* 230 */     this.Tail.setTextureSize(64, 32);
/* 231 */     this.Tail.mirror = true;
/* 232 */     setRotation(this.Tail, 0.0F, 0.0F, 0.0F);
/* 233 */     this.HeadSpike1 = new ModelRenderer(this, 74, 0);
/* 234 */     this.HeadSpike1.addBox(-1.0F, -1.0F, -10.0F, 2, 2, 21);
/* 235 */     this.HeadSpike1.setRotationPoint(6.0F, -20.0F, -60.0F);
/* 236 */     this.HeadSpike1.setTextureSize(64, 32);
/* 237 */     this.HeadSpike1.mirror = true;
/* 238 */     setRotation(this.HeadSpike1, 0.0F, 0.0F, 0.0F);
/* 239 */     this.HeadSpike2 = new ModelRenderer(this, 74, 0);
/* 240 */     this.HeadSpike2.addBox(-1.0F, -1.0F, -10.0F, 2, 2, 21);
/* 241 */     this.HeadSpike2.setRotationPoint(-6.0F, -20.0F, -60.0F);
/* 242 */     this.HeadSpike2.setTextureSize(64, 32);
/* 243 */     this.HeadSpike2.mirror = true;
/* 244 */     setRotation(this.HeadSpike2, 0.0F, 0.0F, 0.0F);
/* 245 */     this.Hip1 = new ModelRenderer(this, 70, 60);
/* 246 */     this.Hip1.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10);
/* 247 */     this.Hip1.setRotationPoint(22.0F, -3.0F, 44.0F);
/* 248 */     this.Hip1.setTextureSize(256, 512);
/* 249 */     this.Hip1.mirror = true;
/* 250 */     setRotation(this.Hip1, 0.0F, 0.0F, 0.0F);
/* 251 */     this.Hip2 = new ModelRenderer(this, 70, 60);
/* 252 */     this.Hip2.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10);
/* 253 */     this.Hip2.setRotationPoint(-32.0F, -3.0F, 44.0F);
/* 254 */     this.Hip2.setTextureSize(256, 512);
/* 255 */     this.Hip2.mirror = true;
/* 256 */     setRotation(this.Hip2, 0.0F, 0.0F, 0.0F);
/* 257 */     this.Hip3 = new ModelRenderer(this, 70, 60);
/* 258 */     this.Hip3.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10);
/* 259 */     this.Hip3.setRotationPoint(16.0F, -1.0F, 12.0F);
/* 260 */     this.Hip3.setTextureSize(256, 512);
/* 261 */     this.Hip3.mirror = true;
/* 262 */     setRotation(this.Hip3, 0.0F, 0.0F, 0.0F);
/* 263 */     this.Hip4 = new ModelRenderer(this, 70, 60);
/* 264 */     this.Hip4.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10);
/* 265 */     this.Hip4.setRotationPoint(-26.0F, -1.0F, 12.0F);
/* 266 */     this.Hip4.setTextureSize(256, 512);
/* 267 */     this.Hip4.mirror = true;
/* 268 */     setRotation(this.Hip4, 0.0F, 0.0F, 0.0F);
/* 269 */     this.Hip5 = new ModelRenderer(this, 70, 60);
/* 270 */     this.Hip5.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10);
/* 271 */     this.Hip5.setRotationPoint(16.0F, -1.0F, -11.0F);
/* 272 */     this.Hip5.setTextureSize(256, 512);
/* 273 */     this.Hip5.mirror = true;
/* 274 */     setRotation(this.Hip5, 0.0F, 0.0F, 0.0F);
/* 275 */     this.Hip6 = new ModelRenderer(this, 70, 60);
/* 276 */     this.Hip6.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10);
/* 277 */     this.Hip6.setRotationPoint(-26.0F, -1.0F, -11.0F);
/* 278 */     this.Hip6.setTextureSize(256, 512);
/* 279 */     this.Hip6.mirror = true;
/* 280 */     setRotation(this.Hip6, 0.0F, 0.0F, 0.0F);
/* 281 */     this.Hip7 = new ModelRenderer(this, 70, 60);
/* 282 */     this.Hip7.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10);
/* 283 */     this.Hip7.setRotationPoint(13.0F, -3.0F, -33.0F);
/* 284 */     this.Hip7.setTextureSize(256, 512);
/* 285 */     this.Hip7.mirror = true;
/* 286 */     setRotation(this.Hip7, 0.0F, 0.0F, 0.0F);
/* 287 */     this.Hip8 = new ModelRenderer(this, 70, 60);
/* 288 */     this.Hip8.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10);
/* 289 */     this.Hip8.setRotationPoint(-23.0F, -3.0F, -33.0F);
/* 290 */     this.Hip8.setTextureSize(256, 512);
/* 291 */     this.Hip8.mirror = true;
/* 292 */     setRotation(this.Hip8, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 298 */     SpiderRobot e = (SpiderRobot)entity;
/* 299 */     RenderSpiderRobotInfo r = null;
/* 300 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 301 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 306 */     r = e.getRenderSpiderRobotInfo();
/*     */     
/* 308 */     for (int i = 0; i < 8; i++) {
/*     */       
/* 310 */       this.Leg1p3.rotateAngleY = r.ydisplayangle[i];
/* 311 */       this.Foot.rotateAngleY = r.ydisplayangle[i];
/* 312 */       this.FootSpike1.rotateAngleY = r.ydisplayangle[i];
/* 313 */       this.FootSpike2.rotateAngleY = r.ydisplayangle[i];
/* 314 */       this.FootSpike3.rotateAngleY = r.ydisplayangle[i];
/* 315 */       this.FootSpike4.rotateAngleY = r.ydisplayangle[i];
/* 316 */       this.AnkleSpike1.rotateAngleY = r.ydisplayangle[i];
/* 317 */       this.AnkleSpike2.rotateAngleY = r.ydisplayangle[i];
/* 318 */       this.AnkleSpike3.rotateAngleY = r.ydisplayangle[i];
/* 319 */       this.AnkleSpike4.rotateAngleY = r.ydisplayangle[i];
/* 320 */       this.LowerKnee.rotateAngleY = r.ydisplayangle[i];
/* 321 */       this.UpperKnee.rotateAngleY = r.ydisplayangle[i];
/* 322 */       this.LegBump1.rotateAngleY = r.ydisplayangle[i];
/* 323 */       this.LegBump2.rotateAngleY = r.ydisplayangle[i];
/* 324 */       this.LowerKnee2.rotateAngleY = r.ydisplayangle[i];
/* 325 */       this.UpperKnee2.rotateAngleY = r.ydisplayangle[i];
/* 326 */       this.HipJoint.rotateAngleY = r.ydisplayangle[i];
/*     */ 
/*     */       
/* 329 */       this.Leg1p1.rotateAngleX = (float)r.p1xangle[i] + r.uddisplayangle[i];
/* 330 */       this.UpperKnee2.rotateAngleX = this.Leg1p1.rotateAngleX;
/* 331 */       this.HipJoint.rotateAngleX = this.Leg1p1.rotateAngleX;
/*     */       
/* 333 */       this.Leg1p2.rotateAngleX = (float)r.p2xangle[i] + r.uddisplayangle[i];
/* 334 */       this.UpperKnee.rotateAngleX = this.Leg1p2.rotateAngleX;
/* 335 */       this.LowerKnee2.rotateAngleX = this.Leg1p2.rotateAngleX;
/*     */       
/* 337 */       this.Leg1p3.rotateAngleX = (float)r.p3xangle[i] + r.uddisplayangle[i];
/* 338 */       this.Foot.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 339 */       this.FootSpike1.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 340 */       this.FootSpike2.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 341 */       this.FootSpike3.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 342 */       this.FootSpike4.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 343 */       this.AnkleSpike1.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 344 */       this.AnkleSpike2.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 345 */       this.AnkleSpike3.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 346 */       this.AnkleSpike4.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 347 */       this.LegBump1.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 348 */       this.LegBump2.rotateAngleX = this.Leg1p3.rotateAngleX;
/* 349 */       this.LowerKnee.rotateAngleX = this.Leg1p3.rotateAngleX;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 355 */       this.Leg1p1.rotationPointX = -((float)Math.cos(r.ymid[i])) * r.legoff[i] * 16.0F;
/* 356 */       this.Leg1p1.rotationPointZ = (float)Math.sin(r.ymid[i]) * r.legoff[i] * 16.0F;
/* 357 */       this.Leg1p1.rotationPointY = r.yoff[i] * -16.0F;
/*     */       
/* 359 */       this.UpperKnee2.rotationPointX = this.Leg1p1.rotationPointX;
/* 360 */       this.UpperKnee2.rotationPointY = this.Leg1p1.rotationPointY;
/* 361 */       this.UpperKnee2.rotationPointZ = this.Leg1p1.rotationPointZ;
/*     */       
/* 363 */       this.HipJoint.rotationPointX = this.Leg1p1.rotationPointX;
/* 364 */       this.HipJoint.rotationPointY = this.Leg1p1.rotationPointY;
/* 365 */       this.HipJoint.rotationPointZ = this.Leg1p1.rotationPointZ;
/*     */       
/* 367 */       this.Leg1p1.rotationPointY -= (float)Math.sin(this.Leg1p1.rotateAngleX) * 99.0F;
/* 368 */       this.Leg1p1.rotationPointZ += (float)Math.cos(this.Leg1p1.rotateAngleX) * (float)Math.cos(this.Leg1p1.rotateAngleY) * 99.0F;
/* 369 */       this.Leg1p1.rotationPointX += (float)Math.cos(this.Leg1p1.rotateAngleX) * (float)Math.sin(this.Leg1p1.rotateAngleY) * 99.0F;
/*     */       
/* 371 */       this.UpperKnee.rotationPointX = this.Leg1p2.rotationPointX;
/* 372 */       this.UpperKnee.rotationPointY = this.Leg1p2.rotationPointY;
/* 373 */       this.UpperKnee.rotationPointZ = this.Leg1p2.rotationPointZ;
/*     */       
/* 375 */       this.LowerKnee2.rotationPointX = this.Leg1p2.rotationPointX;
/* 376 */       this.LowerKnee2.rotationPointY = this.Leg1p2.rotationPointY;
/* 377 */       this.LowerKnee2.rotationPointZ = this.Leg1p2.rotationPointZ;
/*     */ 
/*     */       
/* 380 */       this.Leg1p2.rotationPointY -= (float)Math.sin(this.Leg1p2.rotateAngleX) * 99.0F;
/* 381 */       this.Leg1p2.rotationPointZ += (float)Math.cos(this.Leg1p2.rotateAngleX) * (float)Math.cos(this.Leg1p2.rotateAngleY) * 99.0F;
/* 382 */       this.Leg1p2.rotationPointX += (float)Math.cos(this.Leg1p2.rotateAngleX) * (float)Math.sin(this.Leg1p2.rotateAngleY) * 99.0F;
/*     */       
/* 384 */       this.Foot.rotationPointX = this.Leg1p3.rotationPointX;
/* 385 */       this.Foot.rotationPointY = this.Leg1p3.rotationPointY;
/* 386 */       this.Foot.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 388 */       this.FootSpike1.rotationPointX = this.Leg1p3.rotationPointX;
/* 389 */       this.FootSpike1.rotationPointY = this.Leg1p3.rotationPointY;
/* 390 */       this.FootSpike1.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 392 */       this.FootSpike2.rotationPointX = this.Leg1p3.rotationPointX;
/* 393 */       this.FootSpike2.rotationPointY = this.Leg1p3.rotationPointY;
/* 394 */       this.FootSpike2.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 396 */       this.FootSpike3.rotationPointX = this.Leg1p3.rotationPointX;
/* 397 */       this.FootSpike3.rotationPointY = this.Leg1p3.rotationPointY;
/* 398 */       this.FootSpike3.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 400 */       this.FootSpike4.rotationPointX = this.Leg1p3.rotationPointX;
/* 401 */       this.FootSpike4.rotationPointY = this.Leg1p3.rotationPointY;
/* 402 */       this.FootSpike4.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 404 */       this.AnkleSpike1.rotationPointX = this.Leg1p3.rotationPointX;
/* 405 */       this.AnkleSpike1.rotationPointY = this.Leg1p3.rotationPointY;
/* 406 */       this.AnkleSpike1.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 408 */       this.AnkleSpike2.rotationPointX = this.Leg1p3.rotationPointX;
/* 409 */       this.AnkleSpike2.rotationPointY = this.Leg1p3.rotationPointY;
/* 410 */       this.AnkleSpike2.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 412 */       this.AnkleSpike3.rotationPointX = this.Leg1p3.rotationPointX;
/* 413 */       this.AnkleSpike3.rotationPointY = this.Leg1p3.rotationPointY;
/* 414 */       this.AnkleSpike3.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 416 */       this.AnkleSpike4.rotationPointX = this.Leg1p3.rotationPointX;
/* 417 */       this.AnkleSpike4.rotationPointY = this.Leg1p3.rotationPointY;
/* 418 */       this.AnkleSpike4.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 420 */       this.LegBump1.rotationPointX = this.Leg1p3.rotationPointX;
/* 421 */       this.LegBump1.rotationPointY = this.Leg1p3.rotationPointY;
/* 422 */       this.LegBump1.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 424 */       this.LegBump2.rotationPointX = this.Leg1p3.rotationPointX;
/* 425 */       this.LegBump2.rotationPointY = this.Leg1p3.rotationPointY;
/* 426 */       this.LegBump2.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */       
/* 428 */       this.LowerKnee.rotationPointX = this.Leg1p3.rotationPointX;
/* 429 */       this.LowerKnee.rotationPointY = this.Leg1p3.rotationPointY;
/* 430 */       this.LowerKnee.rotationPointZ = this.Leg1p3.rotationPointZ;
/*     */ 
/*     */ 
/*     */       
/* 434 */       this.Leg1p1.render(f5);
/* 435 */       this.Leg1p2.render(f5);
/* 436 */       this.Leg1p3.render(f5);
/* 437 */       this.Foot.render(f5);
/* 438 */       this.FootSpike1.render(f5);
/* 439 */       this.FootSpike2.render(f5);
/* 440 */       this.FootSpike3.render(f5);
/* 441 */       this.FootSpike4.render(f5);
/* 442 */       this.AnkleSpike1.render(f5);
/* 443 */       this.AnkleSpike2.render(f5);
/* 444 */       this.AnkleSpike3.render(f5);
/* 445 */       this.AnkleSpike4.render(f5);
/* 446 */       this.LowerKnee.render(f5);
/* 447 */       this.UpperKnee.render(f5);
/* 448 */       this.LegBump1.render(f5);
/* 449 */       this.LegBump2.render(f5);
/* 450 */       this.LowerKnee2.render(f5);
/* 451 */       this.UpperKnee2.render(f5);
/* 452 */       this.HipJoint.render(f5);
/*     */     } 
/*     */     
/* 455 */     if (e.getAttacking() == 0) {
/* 456 */       this.Ljaw1.rotateAngleY = 0.0F;
/* 457 */       this.Ljaw2.rotateAngleY = 0.75F;
/* 458 */       this.Ljaw3.rotateAngleY = 1.71F;
/* 459 */       this.Rjaw1.rotateAngleY = 0.0F;
/* 460 */       this.Rjaw2.rotateAngleY = 2.3F;
/* 461 */       this.Rjaw3.rotateAngleY = 1.41F;
/*     */     } else {
/* 463 */       float newangle = MathHelper.cos(r.gpcounter * 0.25F) * 3.1415927F * 0.22F;
/* 464 */       this.Ljaw1.rotateAngleY = newangle;
/* 465 */       this.Ljaw2.rotateAngleY = newangle + 0.75F;
/* 466 */       this.Ljaw3.rotateAngleY = newangle + 1.71F;
/* 467 */       this.Rjaw1.rotateAngleY = -newangle;
/* 468 */       this.Rjaw2.rotateAngleY = 2.3F - newangle;
/* 469 */       this.Rjaw3.rotateAngleY = 1.41F - newangle;
/*     */     } 
/*     */     
/* 472 */     this.BodyCenter.render(f5);
/* 473 */     this.Abdomen.render(f5);
/* 474 */     this.Head.render(f5);
/* 475 */     this.Ljaw1.render(f5);
/* 476 */     this.Rjaw1.render(f5);
/* 477 */     this.Ljaw2.render(f5);
/* 478 */     this.Rjaw2.render(f5);
/* 479 */     this.Ljaw3.render(f5);
/* 480 */     this.Rjaw3.render(f5);
/* 481 */     this.Tail.render(f5);
/* 482 */     this.HeadSpike1.render(f5);
/* 483 */     this.HeadSpike2.render(f5);
/* 484 */     this.Hip1.render(f5);
/* 485 */     this.Hip2.render(f5);
/* 486 */     this.Hip3.render(f5);
/* 487 */     this.Hip4.render(f5);
/* 488 */     this.Hip5.render(f5);
/* 489 */     this.Hip6.render(f5);
/* 490 */     this.Hip7.render(f5);
/* 491 */     this.Hip8.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 497 */     model.rotateAngleX = x;
/* 498 */     model.rotateAngleY = y;
/* 499 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 504 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelSpiderRobot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */