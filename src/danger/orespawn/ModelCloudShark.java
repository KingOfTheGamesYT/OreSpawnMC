/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelCloudShark
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer head;
/*     */   ModelRenderer jaw;
/*     */   ModelRenderer topfin;
/*     */   ModelRenderer bbody;
/*     */   ModelRenderer fins;
/*     */   ModelRenderer leftfin;
/*     */   ModelRenderer rightfin;
/*     */   
/*     */   public ModelCloudShark(float f1) {
/*  23 */     this.wingspeed = f1;
/*     */     
/*  25 */     this.textureWidth = 64;
/*  26 */     this.textureHeight = 64;
/*     */     
/*  28 */     this.body = new ModelRenderer(this, 0, 0);
/*  29 */     this.body.addBox(0.0F, 0.0F, 0.0F, 6, 8, 15);
/*  30 */     this.body.setRotationPoint(-4.0F, 11.0F, 0.0F);
/*  31 */     this.body.setTextureSize(64, 64);
/*  32 */     this.body.mirror = true;
/*  33 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  34 */     this.head = new ModelRenderer(this, 0, 51);
/*  35 */     this.head.addBox(-2.5F, 0.0F, -8.0F, 5, 5, 8);
/*  36 */     this.head.setRotationPoint(-1.0F, 11.0F, 0.0F);
/*  37 */     this.head.setTextureSize(64, 64);
/*  38 */     this.head.mirror = true;
/*  39 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  40 */     this.jaw = new ModelRenderer(this, 42, 0);
/*  41 */     this.jaw.addBox(-2.5F, 0.0F, -6.0F, 5, 2, 6);
/*  42 */     this.jaw.setRotationPoint(-1.0F, 15.0F, 0.0F);
/*  43 */     this.jaw.setTextureSize(64, 64);
/*  44 */     this.jaw.mirror = true;
/*  45 */     setRotation(this.jaw, 0.5056291F, 0.0F, 0.0F);
/*  46 */     this.topfin = new ModelRenderer(this, 0, 0);
/*  47 */     this.topfin.addBox(0.0F, 0.0F, 0.0F, 1, 3, 6);
/*  48 */     this.topfin.setRotationPoint(-1.5F, 11.0F, 5.0F);
/*  49 */     this.topfin.setTextureSize(64, 64);
/*  50 */     this.topfin.mirror = true;
/*  51 */     setRotation(this.topfin, 0.935765F, 0.0F, 0.0F);
/*  52 */     this.bbody = new ModelRenderer(this, 0, 9);
/*  53 */     this.bbody.addBox(-2.0F, 0.0F, 0.0F, 4, 8, 6);
/*  54 */     this.bbody.setRotationPoint(-1.0F, 11.0F, 15.0F);
/*  55 */     this.bbody.setTextureSize(64, 64);
/*  56 */     this.bbody.mirror = true;
/*  57 */     setRotation(this.bbody, 0.0F, 0.0F, 0.0F);
/*  58 */     this.fins = new ModelRenderer(this, 0, 24);
/*  59 */     this.fins.addBox(0.0F, 0.0F, 0.0F, 0, 10, 10);
/*  60 */     this.fins.setRotationPoint(-1.0F, 16.0F, 16.0F);
/*  61 */     this.fins.setTextureSize(64, 64);
/*  62 */     this.fins.mirror = true;
/*  63 */     setRotation(this.fins, 0.9220296F, 0.0F, 0.0F);
/*  64 */     this.leftfin = new ModelRenderer(this, 0, 0);
/*  65 */     this.leftfin.addBox(0.0F, 0.0F, 0.0F, 0, 3, 7);
/*  66 */     this.leftfin.setRotationPoint(2.0F, 16.0F, 6.0F);
/*  67 */     this.leftfin.setTextureSize(64, 64);
/*  68 */     this.leftfin.mirror = true;
/*  69 */     setRotation(this.leftfin, -0.6108652F, 1.134464F, -0.6108652F);
/*  70 */     this.rightfin = new ModelRenderer(this, 0, 0);
/*  71 */     this.rightfin.addBox(0.0F, 0.0F, 0.0F, 0, 3, 7);
/*  72 */     this.rightfin.setRotationPoint(-4.0F, 16.0F, 6.0F);
/*  73 */     this.rightfin.setTextureSize(64, 64);
/*  74 */     this.rightfin.mirror = true;
/*  75 */     setRotation(this.rightfin, -0.6283185F, -1.134464F, 0.6108652F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  80 */     float newangle = 0.0F;
/*  81 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  82 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  85 */     newangle = MathHelper.cos(f2 * 0.7F * this.wingspeed) * 3.1415927F * 0.15F;
/*  86 */     this.leftfin.rotateAngleY = 1.15F + newangle;
/*  87 */     newangle = MathHelper.cos(f2 * 1.5F * this.wingspeed) * 3.1415927F * 0.15F;
/*  88 */     this.rightfin.rotateAngleY = -0.9F + newangle;
/*  89 */     newangle = MathHelper.cos(f2 * 1.5F * this.wingspeed) * 3.1415927F * 0.25F;
/*  90 */     this.fins.rotateAngleY = newangle;
/*  91 */     newangle = MathHelper.cos(f2 * 0.5F * this.wingspeed) * 3.1415927F * 0.1F;
/*  92 */     this.jaw.rotateAngleX = 0.5F + newangle;
/*     */ 
/*     */     
/*  95 */     this.body.render(f5);
/*  96 */     this.head.render(f5);
/*  97 */     this.jaw.render(f5);
/*  98 */     this.topfin.render(f5);
/*  99 */     this.bbody.render(f5);
/* 100 */     this.fins.render(f5);
/* 101 */     this.leftfin.render(f5);
/* 102 */     this.rightfin.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 108 */     model.rotateAngleX = x;
/* 109 */     model.rotateAngleY = y;
/* 110 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 115 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelCloudShark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */