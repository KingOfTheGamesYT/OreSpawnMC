/*     */ package danger.orespawn.blocks;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class OreBasicStone
/*     */   extends Block
/*     */ {
/*     */   public OreBasicStone(int par1, float f1, float f2) {
/*  16 */     super(Material.ROCK);
/*  17 */     setHardness(f1);
/*  18 */     setResistance(f2);
/*  19 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*  20 */     setTickRandomly(false);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
/*  99 */     Entity var8 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     if (name == null) {
/* 106 */       var8 = EntityList.createEntityByID(par1, par0World);
/*     */     } else {
/* 108 */       var8 = EntityList.createEntityByIDFromName(new ResourceLocation(name), par0World);
/*     */     } 
/*     */ 
/*     */     
/* 112 */     if (var8 != null) {
/*     */       
/* 114 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */       
/* 116 */       par0World.spawnEntity(var8);
/*     */       
/* 118 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 121 */     return var8;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\blocks\OreBasicStone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */