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
/*     */ public class ModelFlounder
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer body;
/*     */   ModelRenderer head;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer rfin;
/*     */   ModelRenderer lfin;
/*     */   
/*     */   public ModelFlounder() {
/*  23 */     this.textureWidth = 64;
/*  24 */     this.textureHeight = 32;
/*     */     
/*  26 */     this.body = new ModelRenderer(this, 0, 16);
/*  27 */     this.body.addBox(-4.0F, 0.0F, -5.0F, 8, 1, 12);
/*  28 */     this.body.setRotationPoint(0.0F, 22.0F, 0.0F);
/*  29 */     this.body.setTextureSize(64, 32);
/*  30 */     this.body.mirror = true;
/*  31 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  32 */     this.head = new ModelRenderer(this, 0, 5);
/*  33 */     this.head.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 2);
/*  34 */     this.head.setRotationPoint(0.0F, 22.0F, -7.0F);
/*  35 */     this.head.setTextureSize(64, 32);
/*  36 */     this.head.mirror = true;
/*  37 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  38 */     this.tail1 = new ModelRenderer(this, 30, 0);
/*  39 */     this.tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 2);
/*  40 */     this.tail1.setRotationPoint(0.0F, 22.0F, 7.0F);
/*  41 */     this.tail1.setTextureSize(64, 32);
/*  42 */     this.tail1.mirror = true;
/*  43 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/*  44 */     this.tail2 = new ModelRenderer(this, 30, 4);
/*  45 */     this.tail2.addBox(-3.0F, 0.0F, 2.0F, 6, 1, 3);
/*  46 */     this.tail2.setRotationPoint(0.0F, 22.0F, 7.0F);
/*  47 */     this.tail2.setTextureSize(64, 32);
/*  48 */     this.tail2.mirror = true;
/*  49 */     setRotation(this.tail2, 0.0F, 0.0F, 0.0F);
/*  50 */     this.rfin = new ModelRenderer(this, 12, 0);
/*  51 */     this.rfin.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 2);
/*  52 */     this.rfin.setRotationPoint(-4.0F, 22.0F, -2.0F);
/*  53 */     this.rfin.setTextureSize(64, 32);
/*  54 */     this.rfin.mirror = true;
/*  55 */     setRotation(this.rfin, 0.0F, 0.0F, 0.0F);
/*  56 */     this.lfin = new ModelRenderer(this, 0, 0);
/*  57 */     this.lfin.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2);
/*  58 */     this.lfin.setRotationPoint(4.0F, 22.0F, -2.0F);
/*  59 */     this.lfin.setTextureSize(64, 32);
/*  60 */     this.lfin.mirror = true;
/*  61 */     setRotation(this.lfin, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*     */     float newangle, newangle2;
/*  67 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  68 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  70 */     if (f1 > 0.1D) {
/*  71 */       newangle = MathHelper.cos(f2 * 1.3F) * 3.1415927F * 0.25F * f1;
/*  72 */       newangle2 = MathHelper.cos(f2 * 1.7F) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/*  74 */       newangle = 0.0F;
/*  75 */       newangle2 = 0.0F;
/*     */     } 
/*  77 */     this.lfin.rotateAngleZ = newangle;
/*  78 */     this.rfin.rotateAngleZ = newangle2;
/*     */     
/*  80 */     if (f1 > 0.1D) {
/*  81 */       newangle = MathHelper.cos(f2 * 1.2F) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/*  83 */       newangle = MathHelper.cos(f2 * 0.7F) * 3.1415927F * 0.05F;
/*     */     } 
/*  85 */     this.tail2.rotateAngleX = newangle;
/*     */     
/*  87 */     this.body.render(f5);
/*  88 */     this.head.render(f5);
/*  89 */     this.tail1.render(f5);
/*  90 */     this.tail2.render(f5);
/*  91 */     this.rfin.render(f5);
/*  92 */     this.lfin.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  97 */     model.rotateAngleX = x;
/*  98 */     model.rotateAngleY = y;
/*  99 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 104 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelFlounder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */