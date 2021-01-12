/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class ModelScorpion
/*     */   extends ModelBase
/*     */ {
/*  23 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer tail3;
/*     */   ModelRenderer tail4;
/*     */   ModelRenderer tail5;
/*     */   ModelRenderer tail6;
/*     */   ModelRenderer lleg1;
/*     */   ModelRenderer rleg1;
/*     */   ModelRenderer rleg2;
/*     */   ModelRenderer lleg3;
/*     */   ModelRenderer rleg4;
/*     */   ModelRenderer rleg3;
/*     */   ModelRenderer lleg4;
/*     */   ModelRenderer lleg2;
/*     */   ModelRenderer head;
/*     */   ModelRenderer larm2;
/*     */   ModelRenderer rarm2;
/*     */   ModelRenderer larm1;
/*     */   ModelRenderer rarm1;
/*     */   ModelRenderer lclaw;
/*     */   ModelRenderer rclaw;
/*     */   
/*     */   public ModelScorpion(float f1) {
/*  50 */     this.wingspeed = f1;
/*     */     
/*  52 */     this.textureWidth = 88;
/*  53 */     this.textureHeight = 24;
/*     */     
/*  55 */     this.body = new ModelRenderer(this, 0, 0);
/*  56 */     this.body.addBox(0.0F, 0.0F, 0.0F, 6, 4, 8);
/*  57 */     this.body.setRotationPoint(-3.0F, 17.0F, -4.0F);
/*  58 */     this.body.setTextureSize(88, 24);
/*  59 */     this.body.mirror = true;
/*  60 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  61 */     this.tail1 = new ModelRenderer(this, 28, 0);
/*  62 */     this.tail1.addBox(0.0F, 0.0F, 0.0F, 4, 4, 5);
/*  63 */     this.tail1.setRotationPoint(-2.0F, 17.0F, 3.0F);
/*  64 */     this.tail1.setTextureSize(88, 24);
/*  65 */     this.tail1.mirror = true;
/*  66 */     setRotation(this.tail1, 0.2617994F, 0.0F, 0.0F);
/*  67 */     this.tail2 = new ModelRenderer(this, 46, 0);
/*  68 */     this.tail2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 5);
/*  69 */     this.tail2.setRotationPoint(-1.5F, 16.8F, 6.0F);
/*  70 */     this.tail2.setTextureSize(88, 24);
/*  71 */     this.tail2.mirror = true;
/*  72 */     setRotation(this.tail2, 1.029744F, 0.0F, 0.0F);
/*  73 */     this.tail3 = new ModelRenderer(this, 62, 0);
/*  74 */     this.tail3.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4);
/*  75 */     this.tail3.setRotationPoint(-1.5F, 14.5F, 8.0F);
/*  76 */     this.tail3.setTextureSize(88, 24);
/*  77 */     this.tail3.mirror = true;
/*  78 */     setRotation(this.tail3, 1.727876F, 0.0F, 0.0F);
/*  79 */     this.tail4 = new ModelRenderer(this, 0, 17);
/*  80 */     this.tail4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
/*  81 */     this.tail4.setRotationPoint(-1.0F, 12.0F, 9.0F);
/*  82 */     this.tail4.setTextureSize(88, 24);
/*  83 */     this.tail4.mirror = true;
/*  84 */     setRotation(this.tail4, 2.513274F, 0.0F, 0.0F);
/*  85 */     this.tail5 = new ModelRenderer(this, 70, 7);
/*  86 */     this.tail5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
/*  87 */     this.tail5.setRotationPoint(-1.0F, 9.0F, 6.0F);
/*  88 */     this.tail5.setTextureSize(88, 24);
/*  89 */     this.tail5.mirror = true;
/*  90 */     setRotation(this.tail5, 3.141593F, 0.0F, 0.0F);
/*  91 */     this.tail6 = new ModelRenderer(this, 62, 7);
/*  92 */     this.tail6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
/*  93 */     this.tail6.setRotationPoint(-0.5F, 8.0F, 2.0F);
/*  94 */     this.tail6.setTextureSize(88, 24);
/*  95 */     this.tail6.mirror = true;
/*  96 */     setRotation(this.tail6, 3.141593F, 0.0F, 0.0F);
/*  97 */     this.lleg1 = new ModelRenderer(this, 0, 12);
/*  98 */     this.lleg1.addBox(0.0F, 0.0F, 0.0F, 11, 2, 2);
/*  99 */     this.lleg1.setRotationPoint(2.0F, 18.0F, -3.0F);
/* 100 */     this.lleg1.setTextureSize(88, 24);
/* 101 */     this.lleg1.mirror = true;
/* 102 */     setRotation(this.lleg1, 0.0F, 0.4886922F, 0.3665191F);
/* 103 */     this.rleg1 = new ModelRenderer(this, 0, 12);
/* 104 */     this.rleg1.addBox(0.0F, 0.0F, 0.0F, 11, 2, 2);
/* 105 */     this.rleg1.setRotationPoint(-2.0F, 18.0F, -1.0F);
/* 106 */     this.rleg1.setTextureSize(88, 24);
/* 107 */     this.rleg1.mirror = true;
/* 108 */     setRotation(this.rleg1, 0.0F, 2.6529F, -0.3665191F);
/* 109 */     this.rleg2 = new ModelRenderer(this, 0, 12);
/* 110 */     this.rleg2.addBox(0.0F, 0.0F, 0.0F, 11, 2, 2);
/* 111 */     this.rleg2.setRotationPoint(-2.0F, 18.0F, 1.0F);
/* 112 */     this.rleg2.setTextureSize(88, 24);
/* 113 */     this.rleg2.mirror = true;
/* 114 */     setRotation(this.rleg2, 0.0F, 2.897247F, -0.3665191F);
/* 115 */     this.lleg3 = new ModelRenderer(this, 0, 12);
/* 116 */     this.lleg3.addBox(0.0F, 0.0F, 0.0F, 11, 2, 2);
/* 117 */     this.lleg3.setRotationPoint(2.0F, 18.0F, 1.0F);
/* 118 */     this.lleg3.setTextureSize(88, 24);
/* 119 */     this.lleg3.mirror = true;
/* 120 */     setRotation(this.lleg3, 0.0F, -0.2443461F, 0.3665191F);
/* 121 */     this.rleg4 = new ModelRenderer(this, 0, 12);
/* 122 */     this.rleg4.addBox(0.0F, 0.0F, 0.0F, 11, 2, 2);
/* 123 */     this.rleg4.setRotationPoint(-2.0F, 18.0F, 5.0F);
/* 124 */     this.rleg4.setTextureSize(88, 24);
/* 125 */     this.rleg4.mirror = true;
/* 126 */     setRotation(this.rleg4, 0.0F, -2.6529F, -0.3665191F);
/* 127 */     this.rleg3 = new ModelRenderer(this, 0, 12);
/* 128 */     this.rleg3.addBox(0.0F, 0.0F, 0.0F, 11, 2, 2);
/* 129 */     this.rleg3.setRotationPoint(-2.0F, 18.0F, 3.0F);
/* 130 */     this.rleg3.setTextureSize(88, 24);
/* 131 */     this.rleg3.mirror = true;
/* 132 */     setRotation(this.rleg3, 0.0F, -2.897247F, -0.3665191F);
/* 133 */     this.lleg4 = new ModelRenderer(this, 0, 12);
/* 134 */     this.lleg4.addBox(0.0F, 0.0F, 0.0F, 11, 2, 2);
/* 135 */     this.lleg4.setRotationPoint(2.0F, 18.0F, 3.0F);
/* 136 */     this.lleg4.setTextureSize(88, 24);
/* 137 */     this.lleg4.mirror = true;
/* 138 */     setRotation(this.lleg4, 0.0F, -0.4886922F, 0.3665191F);
/* 139 */     this.lleg2 = new ModelRenderer(this, 0, 12);
/* 140 */     this.lleg2.addBox(0.0F, 0.0F, 0.0F, 11, 2, 2);
/* 141 */     this.lleg2.setRotationPoint(2.0F, 18.0F, -1.0F);
/* 142 */     this.lleg2.setTextureSize(88, 24);
/* 143 */     this.lleg2.mirror = true;
/* 144 */     setRotation(this.lleg2, 0.0F, 0.2443461F, 0.3665191F);
/* 145 */     this.head = new ModelRenderer(this, 28, 9);
/* 146 */     this.head.addBox(0.0F, 0.0F, 0.0F, 5, 3, 4);
/* 147 */     this.head.setRotationPoint(-2.5F, 17.5F, -8.0F);
/* 148 */     this.head.setTextureSize(88, 24);
/* 149 */     this.head.mirror = true;
/* 150 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/* 151 */     this.larm2 = new ModelRenderer(this, 46, 8);
/* 152 */     this.larm2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
/* 153 */     this.larm2.setRotationPoint(1.0F, 18.0F, -6.0F);
/* 154 */     this.larm2.setTextureSize(88, 24);
/* 155 */     this.larm2.mirror = true;
/* 156 */     setRotation(this.larm2, 0.0F, 0.5235988F, 0.1745329F);
/* 157 */     this.rarm2 = new ModelRenderer(this, 46, 8);
/* 158 */     this.rarm2.addBox(0.0F, 0.0F, -2.0F, 6, 2, 2);
/* 159 */     this.rarm2.setRotationPoint(-1.0F, 18.0F, -6.0F);
/* 160 */     this.rarm2.setTextureSize(88, 24);
/* 161 */     this.rarm2.mirror = true;
/* 162 */     setRotation(this.rarm2, 0.0F, 2.617994F, -0.1745329F);
/* 163 */     this.larm1 = new ModelRenderer(this, 70, 13);
/* 164 */     this.larm1.addBox(-2.0F, 0.0F, -3.0F, 2, 2, 3);
/* 165 */     this.larm1.setRotationPoint(7.0F, 19.0F, -7.2F);
/* 166 */     this.larm1.setTextureSize(88, 24);
/* 167 */     this.larm1.mirror = true;
/* 168 */     setRotation(this.larm1, 0.1745329F, 0.1745329F, 0.0F);
/* 169 */     this.rarm1 = new ModelRenderer(this, 70, 13);
/* 170 */     this.rarm1.addBox(0.0F, 0.0F, -3.0F, 2, 2, 3);
/* 171 */     this.rarm1.setRotationPoint(-7.0F, 19.0F, -7.2F);
/* 172 */     this.rarm1.setTextureSize(88, 24);
/* 173 */     this.rarm1.mirror = true;
/* 174 */     setRotation(this.rarm1, 0.1745329F, -0.1745329F, 0.0F);
/* 175 */     this.lclaw = new ModelRenderer(this, 46, 12);
/* 176 */     this.lclaw.addBox(-3.0F, 0.0F, -4.0F, 3, 2, 4);
/* 177 */     this.lclaw.setRotationPoint(7.0F, 19.0F, -10.0F);
/* 178 */     this.lclaw.setTextureSize(88, 24);
/* 179 */     this.lclaw.mirror = true;
/* 180 */     setRotation(this.lclaw, 0.0174533F, 0.3839724F, 0.1396263F);
/* 181 */     this.rclaw = new ModelRenderer(this, 46, 12);
/* 182 */     this.rclaw.addBox(0.0F, 0.0F, -4.0F, 3, 2, 4);
/* 183 */     this.rclaw.setRotationPoint(-7.0F, 19.0F, -10.0F);
/* 184 */     this.rclaw.setTextureSize(88, 24);
/* 185 */     this.rclaw.mirror = true;
/* 186 */     setRotation(this.rclaw, 0.0174533F, -0.3839724F, 0.1396263F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 193 */     Scorpion e = (Scorpion)entity;
/* 194 */     RenderInfo r = null;
/* 195 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 196 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 197 */     float newangle = 0.0F, upangle = 0.0F, nextangle = 0.0F;
/*     */ 
/*     */     
/* 200 */     float pi4 = 1.570795F;
/*     */ 
/*     */     
/* 203 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.12F * f1;
/* 204 */     this.lleg1.rotateAngleY = newangle + 0.49F;
/* 205 */     this.rleg1.rotateAngleY = -newangle + 2.65F;
/*     */     
/* 207 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed - 1.0F * pi4) * 3.1415927F * 0.12F * f1;
/* 208 */     this.lleg2.rotateAngleY = newangle + 0.24F;
/* 209 */     this.rleg2.rotateAngleY = -newangle + 2.9F;
/*     */     
/* 211 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.12F * f1;
/* 212 */     this.lleg3.rotateAngleY = newangle - 0.24F;
/* 213 */     this.rleg3.rotateAngleY = -newangle - 2.9F;
/*     */     
/* 215 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed - 3.0F * pi4) * 3.1415927F * 0.12F * f1;
/* 216 */     this.lleg4.rotateAngleY = newangle - 0.49F;
/* 217 */     this.rleg4.rotateAngleY = -newangle - 2.65F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 222 */     r = e.getRenderInfo();
/*     */ 
/*     */     
/* 225 */     newangle = MathHelper.cos(f2 * 3.0F * this.wingspeed) * 3.1415927F * 0.15F;
/* 226 */     nextangle = MathHelper.cos((f2 + 0.1F) * 3.0F * this.wingspeed) * 3.1415927F * 0.15F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     if (nextangle > 0.0F && newangle < 0.0F) {
/*     */       
/* 233 */       r.ri1 = 0;
/* 234 */       if (e.getAttacking() == 0) {
/* 235 */         r.ri1 = e.worldObj.rand.nextInt(20);
/* 236 */         r.ri2 = e.worldObj.rand.nextInt(25);
/*     */       } else {
/* 238 */         r.ri1 = e.worldObj.rand.nextInt(4);
/* 239 */         r.ri2 = e.worldObj.rand.nextInt(3);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 244 */     if (r.ri1 == 1 || r.ri1 == 3) {
/* 245 */       doLeftClaw(newangle);
/*     */     } else {
/* 247 */       doLeftClaw(0.0F);
/*     */     } 
/* 249 */     if (r.ri1 == 2 || r.ri1 == 3) {
/* 250 */       doRightClaw(newangle);
/*     */     } else {
/* 252 */       doRightClaw(0.0F);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 258 */     if (r.ri2 == 1) {
/* 259 */       doTail(newangle);
/*     */     } else {
/* 261 */       doTail(0.0F);
/*     */     } 
/*     */ 
/*     */     
/* 265 */     e.setRenderInfo(r);
/*     */     
/* 267 */     this.body.render(f5);
/* 268 */     this.tail1.render(f5);
/* 269 */     this.tail2.render(f5);
/* 270 */     this.tail3.render(f5);
/* 271 */     this.tail4.render(f5);
/* 272 */     this.tail5.render(f5);
/* 273 */     this.tail6.render(f5);
/* 274 */     this.lleg1.render(f5);
/* 275 */     this.rleg1.render(f5);
/* 276 */     this.rleg2.render(f5);
/* 277 */     this.lleg3.render(f5);
/* 278 */     this.rleg4.render(f5);
/* 279 */     this.rleg3.render(f5);
/* 280 */     this.lleg4.render(f5);
/* 281 */     this.lleg2.render(f5);
/* 282 */     this.head.render(f5);
/* 283 */     this.larm2.render(f5);
/* 284 */     this.rarm2.render(f5);
/* 285 */     this.larm1.render(f5);
/* 286 */     this.rarm1.render(f5);
/* 287 */     this.lclaw.render(f5);
/* 288 */     this.rclaw.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 294 */     model.rotateAngleX = x;
/* 295 */     model.rotateAngleY = y;
/* 296 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 302 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doLeftClaw(float angle) {
/* 308 */     this.larm2.rotateAngleY = 0.52F + angle;
/* 309 */     this.larm1.rotationPointZ = (float)(this.larm2.rotationPointZ - Math.sin(this.larm2.rotateAngleY) * 4.5D);
/* 310 */     this.larm1.rotationPointZ -= 3.0F;
/* 311 */     this.lclaw.rotateAngleY = 0.381F - angle;
/*     */   }
/*     */ 
/*     */   
/*     */   private void doRightClaw(float angle) {
/* 316 */     this.rarm2.rotateAngleY = 2.61F - angle;
/* 317 */     this.rarm1.rotationPointZ = (float)(this.rarm2.rotationPointZ - Math.sin(this.rarm2.rotateAngleY) * 4.5D);
/* 318 */     this.rarm1.rotationPointZ -= 3.0F;
/* 319 */     this.rclaw.rotateAngleY = -0.381F + angle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doTail(float angle) {
/* 326 */     this.tail1.rotateAngleX = 0.26F + angle;
/*     */ 
/*     */     
/* 329 */     this.tail2.rotateAngleX = this.tail1.rotateAngleX + 0.76900005F + angle;
/* 330 */     this.tail2.rotationPointY = (float)(this.tail1.rotationPointY - Math.sin(this.tail1.rotateAngleX) * 4.0D);
/* 331 */     this.tail2.rotationPointZ = (float)(this.tail1.rotationPointZ + Math.cos(this.tail1.rotateAngleX) * 4.0D);
/*     */     
/* 333 */     this.tail3.rotateAngleX = this.tail2.rotateAngleX + 0.701F + angle;
/* 334 */     this.tail3.rotationPointY = (float)(this.tail2.rotationPointY - Math.sin(this.tail2.rotateAngleX) * 4.0D);
/* 335 */     this.tail3.rotationPointZ = (float)(this.tail2.rotationPointZ + Math.cos(this.tail2.rotateAngleX) * 4.0D);
/*     */     
/* 337 */     this.tail4.rotateAngleX = this.tail3.rotateAngleX + -5.501F - angle * 3.0F / 2.0F - 0.4F;
/* 338 */     this.tail4.rotationPointY = (float)(this.tail3.rotationPointY - Math.sin(this.tail3.rotateAngleX) * 3.0D);
/* 339 */     this.tail4.rotationPointZ = (float)(this.tail3.rotationPointZ + Math.cos(this.tail3.rotateAngleX) * 3.0D);
/*     */     
/* 341 */     this.tail5.rotationPointY = (float)(this.tail4.rotationPointY - Math.sin(this.tail4.rotateAngleX) * 4.0D);
/* 342 */     this.tail5.rotationPointZ = (float)(this.tail4.rotationPointZ + Math.cos(this.tail4.rotateAngleX) * 4.0D);
/*     */     
/* 344 */     this.tail6.rotationPointY = (float)(this.tail5.rotationPointY - Math.sin(this.tail5.rotateAngleX) * 4.0D);
/* 345 */     this.tail6.rotationPointZ = (float)(this.tail5.rotationPointZ + Math.cos(this.tail5.rotateAngleX) * 4.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelScorpion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */