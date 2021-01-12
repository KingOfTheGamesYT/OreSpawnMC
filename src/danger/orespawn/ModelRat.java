/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelRat
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer tail1;
/*     */   
/*     */   ModelRenderer tail2;
/*     */   
/*     */   ModelRenderer lfleg;
/*     */   ModelRenderer rfleg;
/*     */   ModelRenderer lrleg;
/*     */   ModelRenderer rrleg;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer head;
/*     */   ModelRenderer nose;
/*     */   ModelRenderer lear;
/*     */   ModelRenderer rear;
/*     */   
/*     */   public ModelRat(float f1) {
/*  29 */     this.wingspeed = f1;
/*     */     
/*  31 */     this.textureWidth = 64;
/*  32 */     this.textureHeight = 64;
/*     */     
/*  34 */     this.body = new ModelRenderer(this, 27, 0);
/*  35 */     this.body.addBox(-2.0F, -1.0F, 0.0F, 5, 3, 10);
/*  36 */     this.body.setRotationPoint(0.0F, 20.0F, -3.0F);
/*  37 */     this.body.setTextureSize(64, 64);
/*  38 */     this.body.mirror = true;
/*  39 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  40 */     this.tail1 = new ModelRenderer(this, 0, 30);
/*  41 */     this.tail1.addBox(-0.5F, -1.0F, 0.0F, 2, 2, 9);
/*  42 */     this.tail1.setRotationPoint(0.0F, 21.0F, 7.0F);
/*  43 */     this.tail1.setTextureSize(64, 64);
/*  44 */     this.tail1.mirror = true;
/*  45 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/*  46 */     this.tail2 = new ModelRenderer(this, 0, 43);
/*  47 */     this.tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 12);
/*  48 */     this.tail2.setRotationPoint(0.0F, 21.0F, 16.0F);
/*  49 */     this.tail2.setTextureSize(64, 64);
/*  50 */     this.tail2.mirror = true;
/*  51 */     setRotation(this.tail2, 0.0F, 0.0F, 0.0F);
/*  52 */     this.lfleg = new ModelRenderer(this, 0, 14);
/*  53 */     this.lfleg.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
/*  54 */     this.lfleg.setRotationPoint(2.0F, 22.0F, -2.0F);
/*  55 */     this.lfleg.setTextureSize(64, 64);
/*  56 */     this.lfleg.mirror = true;
/*  57 */     setRotation(this.lfleg, 0.0F, 0.0F, 0.0F);
/*  58 */     this.rfleg = new ModelRenderer(this, 10, 14);
/*  59 */     this.rfleg.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
/*  60 */     this.rfleg.setRotationPoint(-2.0F, 22.0F, -2.0F);
/*  61 */     this.rfleg.setTextureSize(64, 64);
/*  62 */     this.rfleg.mirror = true;
/*  63 */     setRotation(this.rfleg, 0.0F, 0.0F, 0.0F);
/*  64 */     this.lrleg = new ModelRenderer(this, 0, 18);
/*  65 */     this.lrleg.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
/*  66 */     this.lrleg.setRotationPoint(2.0F, 20.0F, 4.0F);
/*  67 */     this.lrleg.setTextureSize(64, 64);
/*  68 */     this.lrleg.mirror = true;
/*  69 */     setRotation(this.lrleg, 0.0F, 0.0F, 0.0F);
/*  70 */     this.rrleg = new ModelRenderer(this, 9, 18);
/*  71 */     this.rrleg.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
/*  72 */     this.rrleg.setRotationPoint(-3.0F, 20.0F, 4.0F);
/*  73 */     this.rrleg.setTextureSize(64, 64);
/*  74 */     this.rrleg.mirror = true;
/*  75 */     setRotation(this.rrleg, 0.0F, 0.0F, 0.0F);
/*  76 */     this.body2 = new ModelRenderer(this, 0, 0);
/*  77 */     this.body2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
/*  78 */     this.body2.setRotationPoint(0.0F, 18.0F, 0.0F);
/*  79 */     this.body2.setTextureSize(64, 64);
/*  80 */     this.body2.mirror = true;
/*  81 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/*  82 */     this.head = new ModelRenderer(this, 27, 17);
/*  83 */     this.head.addBox(-1.0F, -2.0F, -3.0F, 3, 2, 4);
/*  84 */     this.head.setRotationPoint(0.0F, 22.0F, -4.0F);
/*  85 */     this.head.setTextureSize(64, 64);
/*  86 */     this.head.mirror = true;
/*  87 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  88 */     this.nose = new ModelRenderer(this, 27, 25);
/*  89 */     this.nose.addBox(0.0F, -1.0F, -5.0F, 1, 1, 2);
/*  90 */     this.nose.setRotationPoint(0.0F, 22.0F, -4.0F);
/*  91 */     this.nose.setTextureSize(64, 64);
/*  92 */     this.nose.mirror = true;
/*  93 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/*  94 */     this.lear = new ModelRenderer(this, 0, 9);
/*  95 */     this.lear.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/*  96 */     this.lear.setRotationPoint(1.5F, 19.5F, -4.0F);
/*  97 */     this.lear.setTextureSize(64, 64);
/*  98 */     this.lear.mirror = true;
/*  99 */     setRotation(this.lear, 0.0F, 0.0F, 0.0F);
/* 100 */     this.rear = new ModelRenderer(this, 5, 9);
/* 101 */     this.rear.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/* 102 */     this.rear.setRotationPoint(-1.5F, 19.5F, -4.0F);
/* 103 */     this.rear.setTextureSize(64, 64);
/* 104 */     this.rear.mirror = true;
/* 105 */     setRotation(this.rear, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 113 */     Rat r = (Rat)entity;
/* 114 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 115 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 117 */     float newangle = 0.0F;
/*     */     
/* 119 */     if (f1 > 0.1D) {
/* 120 */       newangle = MathHelper.cos(f2 * 1.7F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 122 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 125 */     this.rfleg.rotateAngleX = newangle;
/* 126 */     this.lfleg.rotateAngleX = -newangle;
/* 127 */     this.rrleg.rotateAngleX = -newangle;
/* 128 */     this.lrleg.rotateAngleX = newangle;
/*     */     
/* 130 */     if (r.getAttacking() != 0) {
/* 131 */       newangle = MathHelper.cos(f2 * 1.5F * this.wingspeed) * 3.1415927F * 0.25F;
/*     */     } else {
/* 133 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.05F;
/*     */     } 
/* 135 */     this.tail1.rotateAngleY = newangle * 0.5F;
/* 136 */     this.tail2.rotateAngleY = newangle * 1.25F;
/* 137 */     this.tail1.rotationPointZ += (float)Math.cos(this.tail1.rotateAngleY) * 9.0F;
/* 138 */     this.tail1.rotationPointX += (float)Math.sin(this.tail1.rotateAngleY) * 9.0F;
/*     */ 
/*     */     
/* 141 */     this.body.render(f5);
/* 142 */     this.tail1.render(f5);
/* 143 */     this.tail2.render(f5);
/* 144 */     this.lfleg.render(f5);
/* 145 */     this.rfleg.render(f5);
/* 146 */     this.lrleg.render(f5);
/* 147 */     this.rrleg.render(f5);
/* 148 */     this.body2.render(f5);
/* 149 */     this.head.render(f5);
/* 150 */     this.nose.render(f5);
/* 151 */     this.lear.render(f5);
/* 152 */     this.rear.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 158 */     model.rotateAngleX = x;
/* 159 */     model.rotateAngleY = y;
/* 160 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 165 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelRat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */