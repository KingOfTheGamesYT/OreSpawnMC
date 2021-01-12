/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelChipmunk
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Cheek2;
/*     */   
/*     */   ModelRenderer Leg1;
/*     */   
/*     */   ModelRenderer Leg2;
/*     */   ModelRenderer Leg3;
/*     */   ModelRenderer Leg4;
/*     */   ModelRenderer Tail2;
/*     */   ModelRenderer Neck;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer MouthUnder;
/*     */   ModelRenderer Cheek1;
/*     */   ModelRenderer Ear2;
/*     */   ModelRenderer Nose;
/*     */   ModelRenderer Ear1;
/*     */   ModelRenderer Body;
/*     */   ModelRenderer BodyTail;
/*     */   ModelRenderer Tail1;
/*     */   ModelRenderer Hat1;
/*     */   ModelRenderer Hat2;
/*     */   
/*     */   public ModelChipmunk(float f1) {
/*  34 */     this.wingspeed = f1;
/*     */     
/*  36 */     this.textureWidth = 64;
/*  37 */     this.textureHeight = 32;
/*     */     
/*  39 */     this.Cheek2 = new ModelRenderer(this, 14, 0);
/*  40 */     this.Cheek2.addBox(0.5F, -1.5F, -3.5F, 2, 2, 2);
/*  41 */     this.Cheek2.setRotationPoint(0.0F, 20.0F, -3.0F);
/*  42 */     this.Cheek2.setTextureSize(64, 32);
/*  43 */     this.Cheek2.mirror = true;
/*  44 */     setRotation(this.Cheek2, 0.0F, 0.0F, 0.0F);
/*  45 */     this.Leg1 = new ModelRenderer(this, 22, 7);
/*  46 */     this.Leg1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/*  47 */     this.Leg1.setRotationPoint(-2.0F, 23.0F, -4.0F);
/*  48 */     this.Leg1.setTextureSize(64, 32);
/*  49 */     this.Leg1.mirror = true;
/*  50 */     setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
/*  51 */     this.Leg2 = new ModelRenderer(this, 22, 9);
/*  52 */     this.Leg2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/*  53 */     this.Leg2.setRotationPoint(1.0F, 23.0F, -4.0F);
/*  54 */     this.Leg2.setTextureSize(64, 32);
/*  55 */     this.Leg2.mirror = true;
/*  56 */     setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
/*  57 */     this.Leg3 = new ModelRenderer(this, 22, 11);
/*  58 */     this.Leg3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/*  59 */     this.Leg3.setRotationPoint(1.0F, 23.0F, 0.0F);
/*  60 */     this.Leg3.setTextureSize(64, 32);
/*  61 */     this.Leg3.mirror = true;
/*  62 */     setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
/*  63 */     this.Leg4 = new ModelRenderer(this, 22, 13);
/*  64 */     this.Leg4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/*  65 */     this.Leg4.setRotationPoint(-2.0F, 23.0F, 0.0F);
/*  66 */     this.Leg4.setTextureSize(64, 32);
/*  67 */     this.Leg4.mirror = true;
/*  68 */     setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
/*  69 */     this.Tail2 = new ModelRenderer(this, 28, 15);
/*  70 */     this.Tail2.addBox(-0.5F, 1.0F, 2.5F, 3, 3, 4);
/*  71 */     this.Tail2.setRotationPoint(-1.0F, 20.0F, 1.0F);
/*  72 */     this.Tail2.setTextureSize(64, 32);
/*  73 */     this.Tail2.mirror = true;
/*  74 */     setRotation(this.Tail2, 0.7662421F, 0.0F, 0.0F);
/*  75 */     this.Neck = new ModelRenderer(this, 26, 9);
/*  76 */     this.Neck.addBox(0.0F, 0.0F, 0.0F, 3, 2, 4);
/*  77 */     this.Neck.setRotationPoint(-1.5F, 22.0F, -5.0F);
/*  78 */     this.Neck.setTextureSize(64, 32);
/*  79 */     this.Neck.mirror = true;
/*  80 */     setRotation(this.Neck, 1.570796F, 0.0F, 0.0F);
/*  81 */     this.Head = new ModelRenderer(this, 0, 0);
/*  82 */     this.Head.addBox(-2.0F, -3.0F, 0.0F, 4, 4, 3);
/*  83 */     this.Head.setRotationPoint(0.0F, 20.0F, -3.0F);
/*  84 */     this.Head.setTextureSize(64, 32);
/*  85 */     this.Head.mirror = true;
/*  86 */     setRotation(this.Head, 1.570796F, 0.0F, 0.0F);
/*  87 */     this.MouthUnder = new ModelRenderer(this, 20, 4);
/*  88 */     this.MouthUnder.addBox(-1.0F, -1.9F, -3.8F, 2, 2, 1);
/*  89 */     this.MouthUnder.setRotationPoint(0.0F, 20.0F, -3.0F);
/*  90 */     this.MouthUnder.setTextureSize(64, 32);
/*  91 */     this.MouthUnder.mirror = true;
/*  92 */     setRotation(this.MouthUnder, 0.0F, 0.0F, 0.0F);
/*  93 */     this.Cheek1 = new ModelRenderer(this, 22, 0);
/*  94 */     this.Cheek1.addBox(-2.5F, -1.5F, -3.5F, 2, 2, 2);
/*  95 */     this.Cheek1.setRotationPoint(0.0F, 20.0F, -3.0F);
/*  96 */     this.Cheek1.setTextureSize(64, 32);
/*  97 */     this.Cheek1.mirror = true;
/*  98 */     setRotation(this.Cheek1, 0.0F, 0.0F, 0.0F);
/*  99 */     this.Ear2 = new ModelRenderer(this, 18, 11);
/* 100 */     this.Ear2.addBox(1.0F, 0.0F, 3.0F, 1, 1, 1);
/* 101 */     this.Ear2.setRotationPoint(0.0F, 20.0F, -3.0F);
/* 102 */     this.Ear2.setTextureSize(64, 32);
/* 103 */     this.Ear2.mirror = true;
/* 104 */     setRotation(this.Ear2, 1.570796F, 0.0F, 0.0F);
/* 105 */     this.Nose = new ModelRenderer(this, 18, 7);
/* 106 */     this.Nose.addBox(-0.5F, -2.0F, -4.2F, 1, 1, 1);
/* 107 */     this.Nose.setRotationPoint(0.0F, 20.0F, -3.0F);
/* 108 */     this.Nose.setTextureSize(64, 32);
/* 109 */     this.Nose.mirror = true;
/* 110 */     setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
/* 111 */     this.Ear1 = new ModelRenderer(this, 18, 9);
/* 112 */     this.Ear1.addBox(-2.0F, 0.0F, 3.0F, 1, 1, 1);
/* 113 */     this.Ear1.setRotationPoint(0.0F, 20.0F, -3.0F);
/* 114 */     this.Ear1.setTextureSize(64, 32);
/* 115 */     this.Ear1.mirror = true;
/* 116 */     setRotation(this.Ear1, 1.570796F, 0.0F, 0.0F);
/* 117 */     this.Body = new ModelRenderer(this, 0, 7);
/* 118 */     this.Body.addBox(0.0F, 0.0F, 0.0F, 4, 3, 5);
/* 119 */     this.Body.setRotationPoint(-2.0F, 20.0F, -4.0F);
/* 120 */     this.Body.setTextureSize(64, 32);
/* 121 */     this.Body.mirror = true;
/* 122 */     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
/* 123 */     this.BodyTail = new ModelRenderer(this, 0, 15);
/* 124 */     this.BodyTail.addBox(0.0F, 0.0F, 0.0F, 5, 4, 3);
/* 125 */     this.BodyTail.setRotationPoint(-2.5F, 19.0F, -1.0F);
/* 126 */     this.BodyTail.setTextureSize(64, 32);
/* 127 */     this.BodyTail.mirror = true;
/* 128 */     setRotation(this.BodyTail, 0.0F, 0.0F, 0.0F);
/* 129 */     this.Tail1 = new ModelRenderer(this, 16, 15);
/* 130 */     this.Tail1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
/* 131 */     this.Tail1.setRotationPoint(-1.0F, 20.0F, 1.0F);
/* 132 */     this.Tail1.setTextureSize(64, 32);
/* 133 */     this.Tail1.mirror = true;
/* 134 */     setRotation(this.Tail1, 0.3064968F, 0.0F, 0.0F);
/* 135 */     this.Hat1 = new ModelRenderer(this, 40, 0);
/* 136 */     this.Hat1.addBox(-2.5F, -4.0F, -4.0F, 5, 1, 5);
/* 137 */     this.Hat1.setRotationPoint(0.0F, 20.0F, -3.0F);
/* 138 */     this.Hat1.setTextureSize(64, 32);
/* 139 */     this.Hat1.mirror = true;
/* 140 */     setRotation(this.Hat1, 0.0F, 0.0F, 0.0F);
/* 141 */     this.Hat2 = new ModelRenderer(this, 40, 0);
/* 142 */     this.Hat2.addBox(-2.0F, -6.0F, -3.0F, 4, 2, 4);
/* 143 */     this.Hat2.setRotationPoint(0.0F, 20.0F, -3.0F);
/* 144 */     this.Hat2.setTextureSize(64, 32);
/* 145 */     this.Hat2.mirror = true;
/* 146 */     setRotation(this.Hat2, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 153 */     Chipmunk c = (Chipmunk)entity;
/* 154 */     float hf = 0.0F;
/* 155 */     float newangle = 0.0F;
/*     */     
/* 157 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 158 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 161 */     if (f1 > 0.1D) {
/* 162 */       newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 164 */       newangle = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 168 */     this.Leg1.rotateAngleX = newangle;
/* 169 */     this.Leg3.rotateAngleX = newangle;
/* 170 */     this.Leg2.rotateAngleX = -newangle;
/* 171 */     this.Leg4.rotateAngleX = -newangle;
/*     */     
/* 173 */     this.Head.rotateAngleY = (float)Math.toRadians(f3) * 0.45F;
/* 174 */     this.Nose.rotateAngleY = this.Head.rotateAngleY;
/* 175 */     this.Ear1.rotateAngleY = this.Head.rotateAngleY;
/* 176 */     this.Ear2.rotateAngleY = this.Head.rotateAngleY;
/* 177 */     this.MouthUnder.rotateAngleY = this.Head.rotateAngleY;
/* 178 */     this.Cheek1.rotateAngleY = this.Head.rotateAngleY;
/* 179 */     this.Cheek2.rotateAngleY = this.Head.rotateAngleY;
/* 180 */     this.Hat1.rotateAngleY = this.Head.rotateAngleY;
/* 181 */     this.Hat2.rotateAngleY = this.Head.rotateAngleY;
/*     */     
/* 183 */     if (!c.isSitting()) {
/* 184 */       this.Tail1.rotateAngleX = 0.306F + MathHelper.cos(f2 * 0.25F) * 3.1415927F * 0.06F;
/* 185 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/* 186 */       this.Tail1.rotateAngleX += newangle;
/* 187 */       this.Tail2.rotateAngleX = 0.306F + this.Tail1.rotateAngleX;
/*     */     } 
/*     */     
/* 190 */     this.Cheek2.render(f5);
/* 191 */     this.Leg1.render(f5);
/* 192 */     this.Leg2.render(f5);
/* 193 */     this.Leg3.render(f5);
/* 194 */     this.Leg4.render(f5);
/* 195 */     this.Tail2.render(f5);
/* 196 */     this.Neck.render(f5);
/* 197 */     this.Head.render(f5);
/* 198 */     this.MouthUnder.render(f5);
/* 199 */     this.Cheek1.render(f5);
/* 200 */     this.Ear2.render(f5);
/* 201 */     this.Nose.render(f5);
/* 202 */     this.Ear1.render(f5);
/* 203 */     this.Body.render(f5);
/* 204 */     this.BodyTail.render(f5);
/* 205 */     this.Tail1.render(f5);
/* 206 */     if (c instanceof EntityCannonFodder && 
/* 207 */       c.get_is_activated() != 0) {
/* 208 */       this.Hat1.render(f5);
/* 209 */       if (c.get_is_activated() > 1) {
/* 210 */         this.Hat2.render(f5);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 219 */     model.rotateAngleX = x;
/* 220 */     model.rotateAngleY = y;
/* 221 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 226 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelChipmunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */