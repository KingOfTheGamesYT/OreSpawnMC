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
/*     */ public class RenderStinky
/*     */   extends RenderLiving
/*     */ {
/*     */   protected ModelStinky model;
/*  15 */   private float scale = 1.0F;
/*  16 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "Stinkytexture1.png");
/*  17 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "Stinkytexture2.png");
/*  18 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "Stinkytexture3.png");
/*  19 */   private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "Stinkytexture4.png");
/*  20 */   private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "Stinkytexture5.png");
/*  21 */   private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "Stinkytexture6.png");
/*  22 */   private static final ResourceLocation texture7 = new ResourceLocation("orespawn", "Stinkytexture7.png");
/*  23 */   private static final ResourceLocation texture8 = new ResourceLocation("orespawn", "Stinkytexture8.png");
/*  24 */   private static final ResourceLocation texture9 = new ResourceLocation("orespawn", "Stinkytexture9.png");
/*  25 */   private static final ResourceLocation texture10 = new ResourceLocation("orespawn", "Stinkytexture10.png");
/*  26 */   private static final ResourceLocation texture11 = new ResourceLocation("orespawn", "Stinkytexture11.png");
/*  27 */   private static final ResourceLocation texture12 = new ResourceLocation("orespawn", "Stinkytexture12.png");
/*  28 */   private static final ResourceLocation texture13 = new ResourceLocation("orespawn", "Stinkytexture13.png");
/*  29 */   private static final ResourceLocation texture14 = new ResourceLocation("orespawn", "Stinkytexture14.png");
/*  30 */   private static final ResourceLocation texture15 = new ResourceLocation("orespawn", "Stinkytexture15.png");
/*  31 */   private static final ResourceLocation texture16 = new ResourceLocation("orespawn", "Stinkytexture16.png");
/*  32 */   private static final ResourceLocation texture17 = new ResourceLocation("orespawn", "Stinkytexture17.png");
/*  33 */   private static final ResourceLocation texture18 = new ResourceLocation("orespawn", "Stinkytexture18.png");
/*  34 */   private static final ResourceLocation texture19 = new ResourceLocation("orespawn", "Stinkytexture19.png");
/*     */   
/*     */   public RenderStinky(ModelStinky par1ModelBase, float par2, float par3) {
/*  37 */     super(par1ModelBase, par2 * par3);
/*  38 */     this.model = (ModelStinky)this.mainModel;
/*  39 */     this.scale = par3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderStinky(Stinky par1EntityStinky, double par2, double par4, double par6, float par8, float par9) {
/*  45 */     super.doRender((EntityLiving)par1EntityStinky, par2, par4, par6, par8, par9);
/*     */   }
/*     */ 
/*     */   
/*     */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/*  50 */     renderStinky((Stinky)par1EntityLiving, par2, par4, par6, par8, par9);
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
/*  61 */     renderStinky((Stinky)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preRenderScale(Stinky par1Entity, float par2) {
/*  69 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
/*  78 */     preRenderScale((Stinky)par1EntityLiving, par2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation getEntityTexture(Entity entity) {
/*  83 */     Stinky s = (Stinky)entity;
/*  84 */     int i = s.getSkin();
/*  85 */     if (i == 1) return texture2; 
/*  86 */     if (i == 2) return texture3; 
/*  87 */     if (i == 3) return texture4; 
/*  88 */     if (i == 4) return texture5; 
/*  89 */     if (i == 5) return texture6; 
/*  90 */     if (i == 6) return texture7; 
/*  91 */     if (i == 7) return texture8; 
/*  92 */     if (i == 8) return texture9; 
/*  93 */     if (i == 9) return texture10; 
/*  94 */     if (i == 10) return texture11; 
/*  95 */     if (i == 11) return texture12; 
/*  96 */     if (i == 12) return texture13; 
/*  97 */     if (i == 13) return texture14; 
/*  98 */     if (i == 14) return texture15; 
/*  99 */     if (i == 15) return texture16; 
/* 100 */     if (i == 16) return texture17; 
/* 101 */     if (i == 17) return texture18; 
/* 102 */     if (i == 18) return texture19; 
/* 103 */     return texture1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderStinky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */