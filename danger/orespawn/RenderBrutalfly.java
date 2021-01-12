/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.renderer.entity.RenderLiving;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class RenderBrutalfly
/*     */   extends RenderLiving
/*     */ {
/*     */   protected ModelBrutalfly model;
/*  15 */   private float scale = 1.0F;
/*  16 */   private static final ResourceLocation overlay = new ResourceLocation("orespawn", "Brutalfly_overlay2.png");
/*  17 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "Brutalflytexture.png");
/*     */   
/*     */   public RenderBrutalfly(ModelBrutalfly par1ModelBase, float par2, float par3) {
/*  20 */     super(par1ModelBase, par2 * par3);
/*  21 */     this.model = (ModelBrutalfly)this.mainModel;
/*  22 */     this.scale = par3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBrutalfly(Brutalfly par1Brutalfly, double par2, double par4, double par6, float par8, float par9) {
/*  28 */     super.doRender((EntityLiving)par1Brutalfly, par2, par4, par6, par8, par9);
/*     */   }
/*     */ 
/*     */   
/*     */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/*  33 */     renderBrutalfly((Brutalfly)par1EntityLiving, par2, par4, par6, par8, par9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/*  44 */     renderBrutalfly((Brutalfly)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preRenderScale(Brutalfly par1Entity, float par2) {
/*  53 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
/*  64 */     preRenderScale((Brutalfly)par1EntityLiving, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
/*  74 */     int doit = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     GL11.glDepthMask(true);
/*  82 */     if (par2 == 1) {
/*     */       
/*  84 */       float var4 = par1EntityLiving.ticksExisted + par3;
/*     */       
/*  86 */       bindTexture(overlay);
/*  87 */       GL11.glMatrixMode(5890);
/*  88 */       GL11.glLoadIdentity();
/*  89 */       float var5 = var4 * 0.01F;
/*  90 */       float var6 = var4 * 0.01F;
/*  91 */       GL11.glTranslatef(var5, var6, 0.0F);
/*  92 */       setRenderPassModel(this.model);
/*  93 */       GL11.glMatrixMode(5888);
/*  94 */       GL11.glEnable(3042);
/*  95 */       float var7 = 0.5F;
/*  96 */       GL11.glColor4f(var7, var7, var7, 1.0F);
/*  97 */       GL11.glDisable(2896);
/*  98 */       GL11.glBlendFunc(1, 1);
/*  99 */       return 1;
/*     */     } 
/* 101 */     if (par2 == 2) {
/*     */       
/* 103 */       GL11.glMatrixMode(5890);
/* 104 */       GL11.glLoadIdentity();
/* 105 */       GL11.glMatrixMode(5888);
/* 106 */       GL11.glEnable(2896);
/* 107 */       GL11.glDisable(3042);
/*     */     } 
/*     */     
/* 110 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 115 */     return texture;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderBrutalfly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */