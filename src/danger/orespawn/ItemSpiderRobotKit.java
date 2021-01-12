/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
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
/*     */ public class ItemSpiderRobotKit
/*     */   extends Item
/*     */ {
/*     */   public ItemSpiderRobotKit(int i) {
/*  30 */     this.maxStackSize = 1;
/*  31 */     setCreativeTab(CreativeTabs.tabTools);
/*  32 */     if (i == OreSpawnMain.BaseItemID + 471) {
/*  33 */       setMaxDamage(OreSpawnMain.SpiderRobot_stats.health);
/*     */     } else {
/*  35 */       setMaxDamage(OreSpawnMain.AntRobot_stats.health);
/*     */     } 
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
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  51 */     if (par3World.isRemote)
/*     */     {
/*     */       
/*  54 */       return true;
/*     */     }
/*  56 */     String name = null;
/*  57 */     name = "Robot Spider";
/*  58 */     if (par1ItemStack.getItem() == OreSpawnMain.AntRobotKit) {
/*  59 */       name = "Robot Red Ant";
/*     */     }
/*     */     
/*  62 */     Entity ent = spawnCreature(par3World, 0, name, par4 + 0.5D, par5 + 1.01D, par6 + 0.5D);
/*     */     
/*  64 */     if (ent != null) {
/*     */       
/*  66 */       EntityLiving e = (EntityLiving)ent;
/*  67 */       e.setHealth((getMaxDamage() - getDamage(par1ItemStack)));
/*     */       
/*  69 */       if (ent instanceof EntityLiving && par1ItemStack.hasDisplayName())
/*     */       {
/*  71 */         ((EntityLiving)ent).setCustomNameTag(par1ItemStack.getDisplayName());
/*     */       }
/*  73 */       par3World.playSoundAtEntity((Entity)par2EntityPlayer, "random.explode", 1.0F, par3World.rand.nextFloat() * 0.2F + 0.9F);
/*  74 */       if (ent instanceof AntRobot) {
/*  75 */         AntRobot a = (AntRobot)ent;
/*  76 */         a.setOwned();
/*     */       } 
/*     */     } 
/*     */     
/*  80 */     if (!par2EntityPlayer.capabilities.isCreativeMode)
/*     */     {
/*  82 */       par1ItemStack.stackSize--;
/*     */     }
/*     */     
/*  85 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
/*  96 */     Entity var8 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     if (name == null) {
/* 103 */       var8 = EntityList.createEntityByID(par1, par0World);
/*     */     } else {
/* 105 */       var8 = EntityList.createEntityByName(name, par0World);
/*     */     } 
/*     */     
/* 108 */     if (var8 != null) {
/*     */ 
/*     */       
/* 111 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/* 112 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 114 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 117 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 125 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemSpiderRobotKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */