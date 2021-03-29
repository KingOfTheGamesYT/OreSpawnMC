/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelCow;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.passive.EntityCow;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderEnchantedCow
/*    */   extends RenderLiving<EntityCow>
/*    */ {
/*    */   protected ModelCow model;
/* 18 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn:textures/entity/red_cow.png");
/* 19 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "gold_cow.png");
/* 20 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "crystal_cow.png");
/*    */   
/*    */   public RenderEnchantedCow(RenderManager manager) {
/* 23 */     super(manager, (ModelBase)new ModelCow(), 0.0F);
/* 24 */     this.model = (ModelCow)this.mainModel;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(EntityCow entity) {
/* 68 */     if (entity instanceof danger.orespawn.entity.RedCow) return texture1; 
/* 69 */     return texture1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderEnchantedCow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */