/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelPurplePower
/*     */   extends ModelBase
/*     */ {
/*  14 */   float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape3;
/*     */   
/*     */   public ModelPurplePower(float f1) {
/*  21 */     this.wingspeed = f1;
/*     */     
/*  23 */     this.textureWidth = 64;
/*  24 */     this.textureHeight = 32;
/*     */     
/*  26 */     this.Shape1 = new ModelRenderer(this, 0, 12);
/*  27 */     this.Shape1.addBox(-2.0F, -0.5F, -0.5F, 4, 1, 1);
/*  28 */     this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  29 */     this.Shape1.setTextureSize(64, 32);
/*  30 */     this.Shape1.mirror = true;
/*  31 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  32 */     this.Shape2 = new ModelRenderer(this, 0, 7);
/*  33 */     this.Shape2.addBox(-4.0F, -0.5F, -0.5F, 8, 1, 1);
/*  34 */     this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  35 */     this.Shape2.setTextureSize(64, 32);
/*  36 */     this.Shape2.mirror = true;
/*  37 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*  38 */     this.Shape3 = new ModelRenderer(this, 0, 0);
/*  39 */     this.Shape3.addBox(-7.0F, -0.5F, -0.5F, 14, 1, 1);
/*  40 */     this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  41 */     this.Shape3.setTextureSize(64, 32);
/*  42 */     this.Shape3.mirror = true;
/*  43 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  48 */     PurplePower p = (PurplePower)entity;
/*  49 */     float rf1 = 1.0F;
/*  50 */     float newangle = 0.0F;
/*     */ 
/*     */     
/*  53 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  54 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  56 */     GL11.glPushMatrix();
/*  57 */     GL11.glEnable(2977);
/*  58 */     GL11.glEnable(3042);
/*  59 */     GL11.glBlendFunc(770, 771);
/*  60 */     GL11.glColor4f(0.75F, 0.75F, 0.75F, 0.55F);
/*  61 */     OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
/*     */     
/*  63 */     rf1 = p.worldObj.rand.nextFloat() * 360.0F;
/*  64 */     GL11.glRotatef(rf1, 1.0F, 0.0F, 0.0F); int i;
/*  65 */     for (i = 0; i < 6; i++) {
/*  66 */       this.Shape1.rotateAngleZ = newangle;
/*  67 */       this.Shape1.render(f5);
/*  68 */       newangle += 1.0471976F;
/*     */     } 
/*  70 */     GL11.glRotatef(rf1, 1.0F, 0.0F, 0.0F);
/*     */     
/*  72 */     newangle = 0.0F;
/*  73 */     rf1 = p.worldObj.rand.nextFloat() * 360.0F;
/*  74 */     GL11.glRotatef(rf1, 0.0F, 1.0F, 0.0F);
/*  75 */     for (i = 0; i < 6; i++) {
/*  76 */       this.Shape2.rotateAngleZ = newangle;
/*  77 */       this.Shape2.render(f5);
/*  78 */       newangle += 1.0471976F;
/*     */     } 
/*  80 */     GL11.glRotatef(rf1, 0.0F, 1.0F, 0.0F);
/*     */     
/*  82 */     newangle = 0.0F;
/*  83 */     rf1 = p.worldObj.rand.nextFloat() * 360.0F;
/*  84 */     GL11.glRotatef(rf1, 0.0F, 0.0F, 1.0F);
/*  85 */     for (i = 0; i < 6; i++) {
/*  86 */       this.Shape3.rotateAngleZ = newangle;
/*  87 */       this.Shape3.render(f5);
/*  88 */       newangle += 1.0471976F;
/*     */     } 
/*  90 */     GL11.glRotatef(rf1, 0.0F, 0.0F, 1.0F);
/*     */     
/*  92 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  93 */     GL11.glDisable(3042);
/*  94 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 101 */     model.rotateAngleX = x;
/* 102 */     model.rotateAngleY = y;
/* 103 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 108 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelPurplePower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */