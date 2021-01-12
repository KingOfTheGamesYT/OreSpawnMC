/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelEasterBunny
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   ModelRenderer tail;
/*     */   ModelRenderer lfoot;
/*     */   ModelRenderer lleg;
/*     */   ModelRenderer upperbody;
/*     */   ModelRenderer head;
/*     */   ModelRenderer nose;
/*     */   ModelRenderer lear;
/*     */   ModelRenderer lpaw;
/*     */   ModelRenderer rleg;
/*     */   ModelRenderer rfoot;
/*     */   ModelRenderer rear;
/*     */   ModelRenderer rpaw;
/*     */   
/*     */   public ModelEasterBunny(float f1) {
/*  28 */     this.wingspeed = f1;
/*     */     
/*  30 */     this.textureWidth = 64;
/*  31 */     this.textureHeight = 128;
/*     */     
/*  33 */     this.body = new ModelRenderer(this, 0, 44);
/*  34 */     this.body.addBox(-3.0F, 0.0F, -3.0F, 6, 6, 7);
/*  35 */     this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  36 */     this.body.setTextureSize(64, 32);
/*  37 */     this.body.mirror = true;
/*  38 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  39 */     this.tail = new ModelRenderer(this, 0, 58);
/*  40 */     this.tail.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4);
/*  41 */     this.tail.setRotationPoint(0.0F, 19.0F, 6.0F);
/*  42 */     this.tail.setTextureSize(64, 32);
/*  43 */     this.tail.mirror = true;
/*  44 */     setRotation(this.tail, 0.0F, 0.0F, 0.0F);
/*  45 */     this.lfoot = new ModelRenderer(this, 0, 30);
/*  46 */     this.lfoot.addBox(-1.0F, 2.0F, -5.0F, 3, 1, 7);
/*  47 */     this.lfoot.setRotationPoint(3.0F, 21.0F, 1.0F);
/*  48 */     this.lfoot.setTextureSize(64, 32);
/*  49 */     this.lfoot.mirror = true;
/*  50 */     setRotation(this.lfoot, 0.0F, 0.0F, 0.0F);
/*  51 */     this.lleg = new ModelRenderer(this, 0, 20);
/*  52 */     this.lleg.addBox(0.0F, -2.0F, -2.0F, 1, 4, 5);
/*  53 */     this.lleg.setRotationPoint(3.0F, 21.0F, 1.0F);
/*  54 */     this.lleg.setTextureSize(64, 32);
/*  55 */     this.lleg.mirror = true;
/*  56 */     setRotation(this.lleg, 0.0F, 0.0F, 0.0F);
/*  57 */     this.upperbody = new ModelRenderer(this, 42, 27);
/*  58 */     this.upperbody.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 5);
/*  59 */     this.upperbody.setRotationPoint(0.0F, 16.0F, -1.0F);
/*  60 */     this.upperbody.setTextureSize(64, 32);
/*  61 */     this.upperbody.mirror = true;
/*  62 */     setRotation(this.upperbody, 0.0F, 0.0F, 0.0F);
/*  63 */     this.head = new ModelRenderer(this, 40, 17);
/*  64 */     this.head.addBox(-2.5F, 0.0F, -2.0F, 5, 4, 5);
/*  65 */     this.head.setRotationPoint(0.0F, 12.0F, -2.0F);
/*  66 */     this.head.setTextureSize(64, 32);
/*  67 */     this.head.mirror = true;
/*  68 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  69 */     this.nose = new ModelRenderer(this, 44, 9);
/*  70 */     this.nose.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 1);
/*  71 */     this.nose.setRotationPoint(0.0F, 15.0F, -5.0F);
/*  72 */     this.nose.setTextureSize(64, 32);
/*  73 */     this.nose.mirror = true;
/*  74 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/*  75 */     this.lear = new ModelRenderer(this, 54, 0);
/*  76 */     this.lear.addBox(0.0F, -10.0F, -1.0F, 1, 10, 3);
/*  77 */     this.lear.setRotationPoint(2.0F, 13.0F, -1.0F);
/*  78 */     this.lear.setTextureSize(64, 32);
/*  79 */     this.lear.mirror = true;
/*  80 */     setRotation(this.lear, -0.2268928F, 0.0F, 0.0F);
/*  81 */     this.lpaw = new ModelRenderer(this, 6, 7);
/*  82 */     this.lpaw.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/*  83 */     this.lpaw.setRotationPoint(0.5F, 19.0F, -4.0F);
/*  84 */     this.lpaw.setTextureSize(64, 32);
/*  85 */     this.lpaw.mirror = true;
/*  86 */     setRotation(this.lpaw, 0.0F, 0.0F, 0.0F);
/*  87 */     this.rleg = new ModelRenderer(this, 21, 20);
/*  88 */     this.rleg.addBox(0.0F, -2.0F, -2.0F, 1, 4, 5);
/*  89 */     this.rleg.setRotationPoint(-4.0F, 21.0F, 1.0F);
/*  90 */     this.rleg.setTextureSize(64, 32);
/*  91 */     this.rleg.mirror = true;
/*  92 */     setRotation(this.rleg, 0.0F, 0.0F, 0.0F);
/*  93 */     this.rfoot = new ModelRenderer(this, 21, 30);
/*  94 */     this.rfoot.addBox(-1.0F, 2.0F, -5.0F, 3, 1, 7);
/*  95 */     this.rfoot.setRotationPoint(-4.0F, 21.0F, 1.0F);
/*  96 */     this.rfoot.setTextureSize(64, 32);
/*  97 */     this.rfoot.mirror = true;
/*  98 */     setRotation(this.rfoot, 0.0F, 0.0F, 0.0F);
/*  99 */     this.rear = new ModelRenderer(this, 32, 0);
/* 100 */     this.rear.addBox(0.0F, -10.0F, -1.0F, 1, 10, 3);
/* 101 */     this.rear.setRotationPoint(-3.0F, 13.0F, -1.0F);
/* 102 */     this.rear.setTextureSize(64, 32);
/* 103 */     this.rear.mirror = true;
/* 104 */     setRotation(this.rear, -0.418879F, 0.0F, 0.0F);
/* 105 */     this.rpaw = new ModelRenderer(this, 0, 7);
/* 106 */     this.rpaw.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 107 */     this.rpaw.setRotationPoint(-1.5F, 19.0F, -4.0F);
/* 108 */     this.rpaw.setTextureSize(64, 32);
/* 109 */     this.rpaw.mirror = true;
/* 110 */     setRotation(this.rpaw, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 116 */     EasterBunny e = (EasterBunny)entity;
/* 117 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 118 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 120 */     float newangle = 0.0F;
/* 121 */     float newangle2 = 0.0F;
/*     */     
/* 123 */     if (f1 > 0.1D) {
/* 124 */       newangle = MathHelper.cos(f2 * 2.6F * this.wingspeed) * 3.1415927F * 0.15F * f1;
/* 125 */       newangle2 = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.1F * f1;
/*     */     } else {
/* 127 */       newangle = 0.0F;
/* 128 */       newangle2 = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.01F;
/*     */     } 
/*     */     
/* 131 */     this.lfoot.rotateAngleX = newangle;
/* 132 */     this.rfoot.rotateAngleX = -newangle;
/*     */     
/* 134 */     this.lear.rotateAngleX = -0.226F + newangle2;
/* 135 */     this.rear.rotateAngleX = -0.418F - newangle2;
/*     */ 
/*     */     
/* 138 */     this.body.render(f5);
/* 139 */     this.tail.render(f5);
/* 140 */     this.lfoot.render(f5);
/* 141 */     this.lleg.render(f5);
/* 142 */     this.upperbody.render(f5);
/* 143 */     this.head.render(f5);
/* 144 */     this.nose.render(f5);
/* 145 */     this.lear.render(f5);
/* 146 */     this.lpaw.render(f5);
/* 147 */     this.rleg.render(f5);
/* 148 */     this.rfoot.render(f5);
/* 149 */     this.rear.render(f5);
/* 150 */     this.rpaw.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 156 */     model.rotateAngleX = x;
/* 157 */     model.rotateAngleY = y;
/* 158 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 163 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelEasterBunny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */