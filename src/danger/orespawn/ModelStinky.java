/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelStinky
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer neck1;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer neckbase;
/*     */   ModelRenderer head;
/*     */   ModelRenderer Rleg1;
/*     */   ModelRenderer Lleg1;
/*     */   ModelRenderer Lhorn1;
/*     */   ModelRenderer Rhorn1;
/*     */   ModelRenderer snout;
/*     */   ModelRenderer Lhorn2;
/*     */   ModelRenderer Rhorn2;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer Rleg2;
/*     */   ModelRenderer Lleg2;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer tail3;
/*     */   ModelRenderer tail4;
/*     */   ModelRenderer Lwing;
/*     */   ModelRenderer Rwing;
/*     */   
/*     */   public ModelStinky(float f1) {
/*  35 */     this.wingspeed = f1;
/*     */     
/*  37 */     this.textureWidth = 128;
/*  38 */     this.textureHeight = 64;
/*     */     
/*  40 */     this.body = new ModelRenderer(this, 0, 12);
/*  41 */     this.body.addBox(-4.5F, -3.0F, -5.0F, 8, 8, 10);
/*  42 */     this.body.setRotationPoint(0.5F, 15.0F, 1.0F);
/*  43 */     this.body.setTextureSize(128, 64);
/*  44 */     this.body.mirror = true;
/*  45 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  46 */     this.neck1 = new ModelRenderer(this, 0, 31);
/*  47 */     this.neck1.addBox(-2.0F, -3.0F, -2.0F, 4, 5, 5);
/*  48 */     this.neck1.setRotationPoint(0.0F, 16.0F, -5.0F);
/*  49 */     this.neck1.setTextureSize(128, 64);
/*  50 */     this.neck1.mirror = true;
/*  51 */     setRotation(this.neck1, 0.715585F, 0.0F, 0.0F);
/*  52 */     this.neck = new ModelRenderer(this, 0, 42);
/*  53 */     this.neck.addBox(-2.0F, -8.0F, -3.0F, 4, 8, 4);
/*  54 */     this.neck.setRotationPoint(0.0F, 15.0F, -5.5F);
/*  55 */     this.neck.setTextureSize(128, 64);
/*  56 */     this.neck.mirror = true;
/*  57 */     setRotation(this.neck, 0.0F, 0.0F, 0.0F);
/*  58 */     this.neckbase = new ModelRenderer(this, 0, 55);
/*  59 */     this.neckbase.addBox(-3.0F, -4.0F, 0.0F, 6, 6, 3);
/*  60 */     this.neckbase.setRotationPoint(0.0F, 17.0F, 5.0F);
/*  61 */     this.neckbase.setTextureSize(128, 64);
/*  62 */     this.neckbase.mirror = true;
/*  63 */     setRotation(this.neckbase, 0.0F, 0.0F, 0.0F);
/*  64 */     this.head = new ModelRenderer(this, 0, 0);
/*  65 */     this.head.addBox(-2.5F, -10.0F, -3.5F, 5, 5, 5);
/*  66 */     this.head.setRotationPoint(0.0F, 15.0F, -5.5F);
/*  67 */     this.head.setTextureSize(128, 64);
/*  68 */     this.head.mirror = true;
/*  69 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  70 */     this.Rleg1 = new ModelRenderer(this, 19, 53);
/*  71 */     this.Rleg1.addBox(-1.5F, 0.0F, -1.0F, 3, 8, 3);
/*  72 */     this.Rleg1.setRotationPoint(2.0F, 16.0F, 5.5F);
/*  73 */     this.Rleg1.setTextureSize(128, 64);
/*  74 */     this.Rleg1.mirror = true;
/*  75 */     setRotation(this.Rleg1, 0.0F, 0.0F, 0.0F);
/*  76 */     this.Lleg1 = new ModelRenderer(this, 19, 53);
/*  77 */     this.Lleg1.addBox(-1.5F, 0.0F, -0.5F, 3, 8, 3);
/*  78 */     this.Lleg1.setRotationPoint(-2.0F, 16.0F, 5.0F);
/*  79 */     this.Lleg1.setTextureSize(128, 64);
/*  80 */     this.Lleg1.mirror = true;
/*  81 */     setRotation(this.Lleg1, 0.0F, 0.0F, 0.0F);
/*  82 */     this.Lhorn1 = new ModelRenderer(this, 19, 47);
/*  83 */     this.Lhorn1.addBox(-3.0F, -10.5F, -1.0F, 2, 2, 3);
/*  84 */     this.Lhorn1.setRotationPoint(0.0F, 15.0F, -5.5F);
/*  85 */     this.Lhorn1.setTextureSize(128, 64);
/*  86 */     this.Lhorn1.mirror = true;
/*  87 */     setRotation(this.Lhorn1, 0.0F, 0.0F, 0.0F);
/*  88 */     this.Rhorn1 = new ModelRenderer(this, 19, 47);
/*  89 */     this.Rhorn1.addBox(1.0F, -10.5F, -1.0F, 2, 2, 3);
/*  90 */     this.Rhorn1.setRotationPoint(0.0F, 15.0F, -5.5F);
/*  91 */     this.Rhorn1.setTextureSize(128, 64);
/*  92 */     this.Rhorn1.mirror = true;
/*  93 */     setRotation(this.Rhorn1, 0.0F, 0.0F, 0.0F);
/*  94 */     this.snout = new ModelRenderer(this, 32, 57);
/*  95 */     this.snout.addBox(-1.5F, -8.0F, -6.5F, 3, 3, 4);
/*  96 */     this.snout.setRotationPoint(0.0F, 15.0F, -5.5F);
/*  97 */     this.snout.setTextureSize(128, 64);
/*  98 */     this.snout.mirror = true;
/*  99 */     setRotation(this.snout, 0.0F, 0.0F, 0.0F);
/* 100 */     this.Lhorn2 = new ModelRenderer(this, 19, 42);
/* 101 */     this.Lhorn2.addBox(-2.5F, -10.0F, 1.0F, 1, 1, 3);
/* 102 */     this.Lhorn2.setRotationPoint(0.0F, 15.0F, -5.5F);
/* 103 */     this.Lhorn2.setTextureSize(128, 64);
/* 104 */     this.Lhorn2.mirror = true;
/* 105 */     setRotation(this.Lhorn2, 0.0F, 0.0F, 0.0F);
/* 106 */     this.Rhorn2 = new ModelRenderer(this, 19, 42);
/* 107 */     this.Rhorn2.addBox(1.5F, -10.0F, 1.0F, 1, 1, 3);
/* 108 */     this.Rhorn2.setRotationPoint(0.0F, 15.0F, -5.5F);
/* 109 */     this.Rhorn2.setTextureSize(128, 64);
/* 110 */     this.Rhorn2.mirror = true;
/* 111 */     setRotation(this.Rhorn2, 0.0F, 0.0F, 0.0F);
/* 112 */     this.tail1 = new ModelRenderer(this, 47, 55);
/* 113 */     this.tail1.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 3);
/* 114 */     this.tail1.setRotationPoint(0.0F, 16.5F, -2.0F);
/* 115 */     this.tail1.setTextureSize(128, 64);
/* 116 */     this.tail1.mirror = true;
/* 117 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/* 118 */     this.Rleg2 = new ModelRenderer(this, 19, 53);
/* 119 */     this.Rleg2.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3);
/* 120 */     this.Rleg2.setRotationPoint(2.0F, 16.0F, -3.0F);
/* 121 */     this.Rleg2.setTextureSize(128, 64);
/* 122 */     this.Rleg2.mirror = true;
/* 123 */     setRotation(this.Rleg2, 0.0F, 0.0F, 0.0F);
/* 124 */     this.Lleg2 = new ModelRenderer(this, 19, 53);
/* 125 */     this.Lleg2.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3);
/* 126 */     this.Lleg2.setRotationPoint(-2.0F, 16.0F, -3.0F);
/* 127 */     this.Lleg2.setTextureSize(128, 64);
/* 128 */     this.Lleg2.mirror = true;
/* 129 */     setRotation(this.Lleg2, 0.0F, 0.0F, 0.0F);
/* 130 */     this.tail2 = new ModelRenderer(this, 19, 31);
/* 131 */     this.tail2.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 5);
/* 132 */     this.tail2.setRotationPoint(0.0F, 16.0F, 7.0F);
/* 133 */     this.tail2.setTextureSize(128, 64);
/* 134 */     this.tail2.mirror = true;
/* 135 */     setRotation(this.tail2, -0.3839724F, 0.0F, 0.0F);
/* 136 */     this.tail3 = new ModelRenderer(this, 32, 46);
/* 137 */     this.tail3.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 4);
/* 138 */     this.tail3.setRotationPoint(0.0F, 17.2F, 11.0F);
/* 139 */     this.tail3.setTextureSize(128, 64);
/* 140 */     this.tail3.mirror = true;
/* 141 */     setRotation(this.tail3, -0.2094395F, 0.0F, 0.0F);
/* 142 */     this.tail4 = new ModelRenderer(this, 37, 13);
/* 143 */     this.tail4.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 5);
/* 144 */     this.tail4.setRotationPoint(0.0F, 17.5F, 14.0F);
/* 145 */     this.tail4.setTextureSize(128, 64);
/* 146 */     this.tail4.mirror = true;
/* 147 */     setRotation(this.tail4, -0.0698132F, 0.0F, 0.0F);
/* 148 */     this.Lwing = new ModelRenderer(this, 59, 0);
/* 149 */     this.Lwing.addBox(-18.0F, 0.0F, -5.0F, 18, 0, 10);
/* 150 */     this.Lwing.setRotationPoint(-2.0F, 12.6F, 0.0F);
/* 151 */     this.Lwing.setTextureSize(128, 64);
/* 152 */     this.Lwing.mirror = true;
/* 153 */     setRotation(this.Lwing, 0.0F, 0.0F, 0.4014257F);
/* 154 */     this.Rwing = new ModelRenderer(this, 59, 11);
/* 155 */     this.Rwing.addBox(0.0F, 0.0F, -5.0F, 18, 0, 10);
/* 156 */     this.Rwing.setRotationPoint(2.0F, 12.6F, 0.0F);
/* 157 */     this.Rwing.setTextureSize(128, 64);
/* 158 */     this.Rwing.mirror = true;
/* 159 */     setRotation(this.Rwing, 0.0F, 0.0F, -0.4014257F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 167 */     Stinky c = (Stinky)entity;
/* 168 */     float hf = 0.0F;
/* 169 */     float newangle = 0.0F;
/* 170 */     int current_activity = c.getActivity();
/*     */     
/* 172 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 173 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     if (f1 > 0.1D) {
/* 179 */       newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/*     */     } else {
/* 181 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 184 */     this.Rwing.rotateAngleZ = newangle - 0.4F;
/* 185 */     this.Lwing.rotateAngleZ = -newangle + 0.4F;
/*     */ 
/*     */ 
/*     */     
/* 189 */     if (f1 > 0.1D) {
/* 190 */       newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 192 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 195 */     if (current_activity != 2) {
/* 196 */       this.Rleg1.rotateAngleX = newangle;
/* 197 */       this.Lleg1.rotateAngleX = -newangle;
/* 198 */       this.Rleg2.rotateAngleX = -newangle;
/* 199 */       this.Lleg2.rotateAngleX = newangle;
/*     */     } else {
/*     */       
/* 202 */       newangle = -1.0F;
/* 203 */       this.Rleg2.rotateAngleX = newangle;
/* 204 */       this.Lleg2.rotateAngleX = newangle;
/* 205 */       newangle = 1.0F;
/* 206 */       this.Rleg1.rotateAngleX = newangle;
/* 207 */       this.Lleg1.rotateAngleX = newangle;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 212 */     newangle = MathHelper.cos(f2 * 1.0F * this.wingspeed) * 3.1415927F * 0.2F;
/* 213 */     if (c.isSitting() == true) {
/* 214 */       newangle = 0.0F;
/*     */     }
/* 216 */     this.tail2.rotateAngleY = newangle;
/*     */     
/* 218 */     this.tail2.rotationPointZ += (float)Math.cos(this.tail2.rotateAngleY) * 4.0F;
/* 219 */     this.tail3.rotationPointX = this.tail2.rotationPointX + (float)Math.sin(this.tail2.rotateAngleY) * 4.0F - 0.5F;
/* 220 */     this.tail3.rotateAngleY = newangle * 1.6F;
/*     */     
/* 222 */     this.tail3.rotationPointZ += (float)Math.cos(this.tail3.rotateAngleY) * 3.0F;
/* 223 */     this.tail4.rotationPointX = this.tail3.rotationPointX + (float)Math.sin(this.tail3.rotateAngleY) * 3.0F - 0.5F;
/* 224 */     this.tail4.rotateAngleY = newangle * 2.6F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     this.head.rotateAngleY = (float)Math.toRadians(f3);
/* 230 */     this.snout.rotateAngleY = (float)Math.toRadians(f3);
/* 231 */     this.neck.rotateAngleY = (float)Math.toRadians(f3) / 2.0F;
/* 232 */     this.Rhorn1.rotateAngleY = (float)Math.toRadians(f3);
/* 233 */     this.Rhorn2.rotateAngleY = (float)Math.toRadians(f3);
/* 234 */     this.Lhorn1.rotateAngleY = (float)Math.toRadians(f3);
/* 235 */     this.Lhorn2.rotateAngleY = (float)Math.toRadians(f3);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 240 */     this.head.rotateAngleX = (float)Math.toRadians(f4) / 3.0F;
/* 241 */     this.snout.rotateAngleX = (float)Math.toRadians(f4) / 3.0F;
/* 242 */     this.neck.rotateAngleX = (float)Math.toRadians(f4) / 3.0F;
/* 243 */     this.Rhorn1.rotateAngleX = (float)Math.toRadians(f4) / 3.0F;
/* 244 */     this.Rhorn2.rotateAngleX = (float)Math.toRadians(f4) / 3.0F;
/* 245 */     this.Lhorn1.rotateAngleX = (float)Math.toRadians(f4) / 3.0F;
/* 246 */     this.Lhorn2.rotateAngleX = (float)Math.toRadians(f4) / 3.0F;
/*     */ 
/*     */     
/* 249 */     this.body.render(f5);
/* 250 */     this.neck1.render(f5);
/* 251 */     this.neck.render(f5);
/* 252 */     this.neckbase.render(f5);
/* 253 */     this.head.render(f5);
/* 254 */     this.Rleg1.render(f5);
/* 255 */     this.Lleg1.render(f5);
/* 256 */     this.Lhorn1.render(f5);
/* 257 */     this.Rhorn1.render(f5);
/* 258 */     this.snout.render(f5);
/* 259 */     this.Lhorn2.render(f5);
/* 260 */     this.Rhorn2.render(f5);
/* 261 */     this.tail1.render(f5);
/* 262 */     this.Rleg2.render(f5);
/* 263 */     this.Lleg2.render(f5);
/* 264 */     this.tail2.render(f5);
/* 265 */     this.tail3.render(f5);
/* 266 */     this.tail4.render(f5);
/* 267 */     this.Lwing.render(f5);
/* 268 */     this.Rwing.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 273 */     model.rotateAngleX = x;
/* 274 */     model.rotateAngleY = y;
/* 275 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 280 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelStinky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */