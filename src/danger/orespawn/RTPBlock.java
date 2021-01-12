/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RTPBlock
/*    */   extends Block
/*    */ {
/*    */   public RTPBlock(int i) {
/* 26 */     super(Material.rock);
/* 27 */     setCreativeTab(CreativeTabs.tabBlock);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEntityWalking(World world, int par2, int par3, int par4, Entity par5Entity) {
/* 36 */     if (par5Entity instanceof EntityPlayer) {
/* 37 */       EntityPlayer p = (EntityPlayer)par5Entity;
/* 38 */       EntityPlayerMP mp = null;
/* 39 */       if (par5Entity instanceof EntityPlayerMP) {
/* 40 */         mp = (EntityPlayerMP)par5Entity;
/*    */       }
/* 42 */       int x = par2, y = par3, z = par4, found = 0;
/*    */       
/* 44 */       for (int tries = 0; tries < 1000 && found == 0; tries++) {
/* 45 */         if (world.rand.nextInt(2) == 0) {
/* 46 */           x = par2 + 16 + world.rand.nextInt(8) - world.rand.nextInt(8);
/*    */         } else {
/* 48 */           x = par2 - 16 + world.rand.nextInt(8) - world.rand.nextInt(8);
/*    */         } 
/* 50 */         if (world.rand.nextInt(2) == 0) {
/* 51 */           z = par4 + 16 + world.rand.nextInt(8) - world.rand.nextInt(8);
/*    */         } else {
/* 53 */           z = par4 - 16 + world.rand.nextInt(8) - world.rand.nextInt(8);
/*    */         } 
/* 55 */         for (y = par3 - 4; y <= par3 + 4; y++) {
/* 56 */           if (world.getBlock(x, y - 1, z).getMaterial().isSolid() && 
/* 57 */             world.getBlock(x, y, z) == Blocks.air && 
/* 58 */             world.getBlock(x, y + 1, z) == Blocks.air) {
/* 59 */             found = 1;
/*    */ 
/*    */             
/*    */             break;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */       
/* 67 */       if (found != 0) {
/*    */         
/* 69 */         if (mp != null) {
/* 70 */           mp.playerNetServerHandler.setPlayerLocation((x + 0.5F), y, (z + 0.5F), p.rotationYaw, 0.0F);
/*    */         } else {
/* 72 */           p.setLocationAndAngles((x + 0.5F), y, (z + 0.5F), p.rotationYaw, 0.0F);
/*    */         } 
/*    */         
/* 75 */         for (int var3 = 0; var3 < 6; var3++) {
/*    */           
/* 77 */           world.spawnParticle("smoke", (x + 0.5F), (y + 2.25F), (z + 0.5F), 0.0D, 0.0D, 0.0D);
/* 78 */           world.spawnParticle("explode", (x + 0.5F), (y + 2.25F), (z + 0.5F), 0.0D, 0.0D, 0.0D);
/* 79 */           world.spawnParticle("reddust", (x + 0.5F), (y + 2.25F), (z + 0.5F), 0.0D, 0.0D, 0.0D);
/*    */         } 
/* 81 */         p.worldObj.playSoundAtEntity((Entity)p, "random.explode", 1.0F, 1.5F);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 89 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RTPBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */