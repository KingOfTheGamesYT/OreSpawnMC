/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelRubberDucky
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer bottom;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer back;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer head;
/*     */   ModelRenderer beak;
/*     */   ModelRenderer Lwing;
/*     */   ModelRenderer Rwing;
/*     */   
/*     */   public ModelRubberDucky(float f1) {
/*  24 */     this.wingspeed = f1;
/*     */     
/*  26 */     this.textureWidth = 64;
/*  27 */     this.textureHeight = 64;
/*     */     
/*  29 */     this.bottom = new ModelRenderer(this, 0, 56);
/*  30 */     this.bottom.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4);
/*  31 */     this.bottom.setRotationPoint(0.0F, 23.0F, 0.0F);
/*  32 */     this.bottom.setTextureSize(64, 64);
/*  33 */     this.bottom.mirror = true;
/*  34 */     setRotation(this.bottom, 0.0F, 0.0F, 0.0F);
/*  35 */     this.body = new ModelRenderer(this, 0, 45);
/*  36 */     this.body.addBox(-3.0F, 0.0F, -3.0F, 6, 2, 8);
/*  37 */     this.body.setRotationPoint(0.0F, 21.0F, 0.0F);
/*  38 */     this.body.setTextureSize(64, 64);
/*  39 */     this.body.mirror = true;
/*  40 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  41 */     this.back = new ModelRenderer(this, 0, 33);
/*  42 */     this.back.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 10);
/*  43 */     this.back.setRotationPoint(0.0F, 20.0F, 0.0F);
/*  44 */     this.back.setTextureSize(64, 64);
/*  45 */     this.back.mirror = true;
/*  46 */     setRotation(this.back, 0.0F, 0.0F, 0.0F);
/*  47 */     this.neck = new ModelRenderer(this, 17, 27);
/*  48 */     this.neck.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2);
/*  49 */     this.neck.setRotationPoint(0.0F, 19.0F, -1.0F);
/*  50 */     this.neck.setTextureSize(64, 64);
/*  51 */     this.neck.mirror = true;
/*  52 */     setRotation(this.neck, 0.0F, 0.0F, 0.0F);
/*  53 */     this.head = new ModelRenderer(this, 13, 18);
/*  54 */     this.head.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4);
/*  55 */     this.head.setRotationPoint(0.0F, 19.0F, -1.0F);
/*  56 */     this.head.setTextureSize(64, 64);
/*  57 */     this.head.mirror = true;
/*  58 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  59 */     this.beak = new ModelRenderer(this, 0, 21);
/*  60 */     this.beak.addBox(-1.5F, -1.0F, -5.0F, 3, 1, 3);
/*  61 */     this.beak.setRotationPoint(0.0F, 19.0F, -1.0F);
/*  62 */     this.beak.setTextureSize(64, 64);
/*  63 */     this.beak.mirror = true;
/*  64 */     setRotation(this.beak, 0.0F, 0.0F, 0.0F);
/*  65 */     this.Lwing = new ModelRenderer(this, 0, 0);
/*  66 */     this.Lwing.addBox(0.0F, -0.5F, 0.0F, 2, 1, 5);
/*  67 */     this.Lwing.setRotationPoint(3.0F, 21.0F, -2.0F);
/*  68 */     this.Lwing.setTextureSize(64, 64);
/*  69 */     this.Lwing.mirror = true;
/*  70 */     setRotation(this.Lwing, 0.0F, 0.0F, 0.0F);
/*  71 */     this.Rwing = new ModelRenderer(this, 17, 0);
/*  72 */     this.Rwing.addBox(-2.0F, -0.5F, 0.0F, 2, 1, 5);
/*  73 */     this.Rwing.setRotationPoint(-3.0F, 21.0F, -2.0F);
/*  74 */     this.Rwing.setTextureSize(64, 64);
/*  75 */     this.Rwing.mirror = true;
/*  76 */     setRotation(this.Rwing, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  83 */     RubberDucky c = (RubberDucky)entity;
/*  84 */     RenderInfo r = null;
/*  85 */     float hf = 0.0F;
/*  86 */     float newangle = 0.0F;
/*  87 */     float nextangle = 0.0F;
/*     */     
/*  89 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  90 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  93 */     if (f1 > 0.1D) {
/*  94 */       newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/*  96 */       newangle = 0.0F;
/*     */     } 
/*     */     
/*  99 */     this.head.rotateAngleY = (float)Math.toRadians(f3) * 0.45F;
/* 100 */     this.beak.rotateAngleY = this.head.rotateAngleY;
/* 101 */     this.head.rotateAngleX = (float)Math.toRadians(f4) * 0.65F;
/* 102 */     this.beak.rotateAngleX = this.head.rotateAngleX;
/*     */ 
/*     */     
/* 105 */     r = c.getRenderInfo();
/*     */     
/* 107 */     newangle = MathHelper.cos(f2 * 1.0F * this.wingspeed) * 3.1415927F * 0.15F;
/* 108 */     nextangle = MathHelper.cos((f2 + 0.3F) * 1.0F * this.wingspeed) * 3.1415927F * 0.15F;
/*     */ 
/*     */     
/* 111 */     if (nextangle > 0.0F && newangle < 0.0F) {
/*     */       
/* 113 */       r.ri1 = 0;
/* 114 */       if (c.worldObj.rand.nextInt(3) == 1) {
/* 115 */         r.ri1 = 1;
/*     */       }
/* 117 */       if (c.getKillCount() >= 5) {
/* 118 */         if (c.worldObj.rand.nextInt(2) == 1) {
/* 119 */           r.ri1 = 1;
/*     */         }
/* 121 */         newangle *= 4.0F;
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     if (r.ri1 == 0) {
/* 126 */       newangle = 0.0F;
/*     */     }
/* 128 */     if (c.isSitting()) {
/* 129 */       newangle = 0.0F;
/*     */     }
/* 131 */     newangle = Math.abs(newangle);
/* 132 */     this.Lwing.rotateAngleZ = -newangle;
/* 133 */     this.Lwing.rotateAngleY = newangle / 2.0F;
/* 134 */     this.Rwing.rotateAngleZ = newangle;
/* 135 */     this.Rwing.rotateAngleY = -newangle / 2.0F;
/*     */ 
/*     */     
/* 138 */     c.setRenderInfo(r);
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
/* 164 */     this.bottom.render(f5);
/* 165 */     this.body.render(f5);
/* 166 */     this.back.render(f5);
/* 167 */     this.neck.render(f5);
/* 168 */     this.head.render(f5);
/* 169 */     this.beak.render(f5);
/* 170 */     this.Lwing.render(f5);
/* 171 */     this.Rwing.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 177 */     model.rotateAngleX = x;
/* 178 */     model.rotateAngleY = y;
/* 179 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 184 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelRubberDucky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */