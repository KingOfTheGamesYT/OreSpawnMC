/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelLeafMonster
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer body;
/*     */   ModelRenderer larm;
/*     */   ModelRenderer rarm;
/*     */   ModelRenderer lleg;
/*     */   ModelRenderer rleg;
/*     */   
/*     */   public ModelLeafMonster() {
/*  19 */     this.textureWidth = 128;
/*  20 */     this.textureHeight = 128;
/*     */     
/*  22 */     this.body = new ModelRenderer(this, 32, 32);
/*  23 */     this.body.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16);
/*  24 */     this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  25 */     this.body.setTextureSize(64, 32);
/*  26 */     this.body.mirror = true;
/*  27 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  28 */     this.larm = new ModelRenderer(this, 64, 0);
/*  29 */     this.larm.addBox(0.0F, -16.0F, -8.0F, 16, 16, 16);
/*  30 */     this.larm.setRotationPoint(8.0F, -8.0F, 0.0F);
/*  31 */     this.larm.setTextureSize(64, 32);
/*  32 */     this.larm.mirror = true;
/*  33 */     setRotation(this.larm, 0.0F, 0.0F, 0.0F);
/*  34 */     this.rarm = new ModelRenderer(this, 0, 0);
/*  35 */     this.rarm.addBox(-16.0F, -16.0F, -8.0F, 16, 16, 16);
/*  36 */     this.rarm.setRotationPoint(-8.0F, -8.0F, 0.0F);
/*  37 */     this.rarm.setTextureSize(64, 32);
/*  38 */     this.rarm.mirror = true;
/*  39 */     setRotation(this.rarm, 0.0F, 0.0F, 0.0F);
/*  40 */     this.lleg = new ModelRenderer(this, 64, 64);
/*  41 */     this.lleg.addBox(0.0F, 0.0F, -8.0F, 16, 16, 16);
/*  42 */     this.lleg.setRotationPoint(8.0F, 8.0F, 0.0F);
/*  43 */     this.lleg.setTextureSize(64, 32);
/*  44 */     this.lleg.mirror = true;
/*  45 */     setRotation(this.lleg, 0.0F, 0.0F, 0.0F);
/*  46 */     this.rleg = new ModelRenderer(this, 0, 64);
/*  47 */     this.rleg.addBox(-16.0F, 0.0F, -8.0F, 16, 16, 16);
/*  48 */     this.rleg.setRotationPoint(-8.0F, 8.0F, 0.0F);
/*  49 */     this.rleg.setTextureSize(64, 32);
/*  50 */     this.rleg.mirror = true;
/*  51 */     setRotation(this.rleg, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  57 */     LeafMonster lm = (LeafMonster)entity;
/*  58 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  59 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  61 */     if (lm.getAttacking() == 0) {
/*  62 */       this.body.rotationPointY = 16.0F;
/*  63 */       this.rarm.rotationPointY = 8.0F;
/*  64 */       this.larm.rotationPointY = 8.0F;
/*  65 */       this.rarm.rotateAngleY = 0.0F;
/*  66 */       this.larm.rotateAngleY = 0.0F;
/*  67 */       this.rarm.rotateAngleX = 0.0F;
/*  68 */       this.larm.rotateAngleX = 0.0F;
/*  69 */       this.lleg.rotateAngleX = 0.0F;
/*  70 */       this.rleg.rotateAngleX = 0.0F;
/*     */     } else {
/*  72 */       this.body.rotationPointY = 0.0F;
/*  73 */       this.rarm.rotationPointY = -8.0F;
/*  74 */       this.larm.rotationPointY = -8.0F;
/*  75 */       if (f1 > 0.1D) {
/*  76 */         newangle = MathHelper.cos(f2 * 0.95F) * 3.1415927F * 0.25F * f1;
/*     */       } else {
/*  78 */         newangle = 0.0F;
/*     */       } 
/*  80 */       this.lleg.rotateAngleX = newangle;
/*  81 */       this.rleg.rotateAngleX = -newangle;
/*     */       
/*  83 */       float newangle = MathHelper.cos(f2 * 0.7F) * 3.1415927F * 0.55F;
/*  84 */       this.rarm.rotateAngleY = -Math.abs(newangle);
/*  85 */       this.larm.rotateAngleY = Math.abs(newangle);
/*  86 */       this.rarm.rotateAngleX = -Math.abs(newangle);
/*  87 */       this.larm.rotateAngleX = -Math.abs(newangle);
/*     */     } 
/*     */     
/*  90 */     this.body.render(f5);
/*  91 */     this.larm.render(f5);
/*  92 */     this.rarm.render(f5);
/*  93 */     this.lleg.render(f5);
/*  94 */     this.rleg.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 100 */     model.rotateAngleX = x;
/* 101 */     model.rotateAngleY = y;
/* 102 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 107 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelLeafMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */