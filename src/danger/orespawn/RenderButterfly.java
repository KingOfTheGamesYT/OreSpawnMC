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
/*     */ public class RenderButterfly
/*     */   extends RenderLiving
/*     */ {
/*     */   protected ModelButterfly model;
/*  15 */   private float scale = 1.0F;
/*  16 */   private static final ResourceLocation texture = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
/*     */   
/*     */   public RenderButterfly(ModelButterfly par1ModelBase, float par2, float par3) {
/*  19 */     super(par1ModelBase, par2 * par3);
/*  20 */     this.model = (ModelButterfly)this.mainModel;
/*  21 */     this.scale = par3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderButterfly(EntityButterfly par1EntityButterfly, double par2, double par4, double par6, float par8, float par9) {
/*  27 */     super.doRender((EntityLiving)par1EntityButterfly, par2, par4, par6, par8, par9);
/*     */   }
/*     */ 
/*     */   
/*     */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/*  32 */     renderButterfly((EntityButterfly)par1EntityLiving, par2, par4, par6, par8, par9);
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
/*  43 */     renderButterfly((EntityButterfly)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preRenderScale(EntityButterfly par1Entity, float par2) {
/*  52 */     GL11.glScalef(this.scale, this.scale, this.scale);
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
/*  63 */     preRenderScale((EntityButterfly)par1EntityLiving, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
/*  73 */     int doit = 0;
/*  74 */     if (par1EntityLiving instanceof Mothra) {
/*  75 */       doit++;
/*  76 */     } else if (par1EntityLiving instanceof EntityLunaMoth) {
/*  77 */       EntityLunaMoth e = (EntityLunaMoth)par1EntityLiving;
/*  78 */       if (e.moth_type == 0) doit++;
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  84 */     if (doit != 0) {
/*  85 */       GL11.glDepthMask(true);
/*  86 */       if (par2 == 1) {
/*     */         
/*  88 */         float var4 = par1EntityLiving.ticksExisted + par3;
/*     */         
/*  90 */         bindTexture(texture);
/*  91 */         GL11.glMatrixMode(5890);
/*  92 */         GL11.glLoadIdentity();
/*  93 */         float var5 = var4 * 0.01F;
/*  94 */         float var6 = var4 * 0.01F;
/*  95 */         GL11.glTranslatef(var5, var6, 0.0F);
/*  96 */         setRenderPassModel(this.model);
/*  97 */         GL11.glMatrixMode(5888);
/*  98 */         GL11.glEnable(3042);
/*  99 */         float var7 = 0.5F;
/* 100 */         GL11.glColor4f(var7, var7, var7, 1.0F);
/* 101 */         GL11.glDisable(2896);
/* 102 */         GL11.glBlendFunc(1, 1);
/* 103 */         return 1;
/*     */       } 
/* 105 */       if (par2 == 2) {
/*     */         
/* 107 */         GL11.glMatrixMode(5890);
/* 108 */         GL11.glLoadIdentity();
/* 109 */         GL11.glMatrixMode(5888);
/* 110 */         GL11.glEnable(2896);
/* 111 */         GL11.glDisable(3042);
/*     */       } 
/*     */     } 
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
/* 128 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 133 */     EntityButterfly a = (EntityButterfly)entity;
/* 134 */     return a.getTexture(a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderButterfly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */