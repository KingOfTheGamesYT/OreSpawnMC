/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemRock
/*     */   extends Item
/*     */ {
/*     */   public ItemRock(int i) {
/*  23 */     this.maxStackSize = 64;
/*  24 */     setCreativeTab(CreativeTabs.tabCombat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  34 */     if (!par3EntityPlayer.capabilities.isCreativeMode)
/*     */     {
/*  36 */       par1ItemStack.stackSize--;
/*     */     }
/*     */     
/*  39 */     par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
/*     */     
/*  41 */     if (!par2World.isRemote) {
/*     */       
/*  43 */       if (this == OreSpawnMain.MySmallRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 1)); 
/*  44 */       if (this == OreSpawnMain.MyRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 2)); 
/*  45 */       if (this == OreSpawnMain.MyRedRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 3)); 
/*  46 */       if (this == OreSpawnMain.MyGreenRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 4)); 
/*  47 */       if (this == OreSpawnMain.MyBlueRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 5)); 
/*  48 */       if (this == OreSpawnMain.MyPurpleRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 6)); 
/*  49 */       if (this == OreSpawnMain.MySpikeyRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 7)); 
/*  50 */       if (this == OreSpawnMain.MyTNTRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 8)); 
/*  51 */       if (this == OreSpawnMain.MyCrystalRedRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 9)); 
/*  52 */       if (this == OreSpawnMain.MyCrystalGreenRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 10)); 
/*  53 */       if (this == OreSpawnMain.MyCrystalBlueRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 11)); 
/*  54 */       if (this == OreSpawnMain.MyCrystalTNTRock) par2World.spawnEntityInWorld((Entity)new EntityThrownRock(par2World, (EntityLivingBase)par3EntityPlayer, 12));
/*     */     
/*     */     } 
/*  57 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
/*  63 */     if (!world.isRemote) {
/*     */       
/*  65 */       if (x < 0) x++; 
/*  66 */       if (z < 0) z++; 
/*  67 */       Entity e = spawnCreature(world, "Rock", x, y + 1.01D, z);
/*     */       
/*  69 */       if (e != null) {
/*  70 */         RockBase r = (RockBase)e;
/*  71 */         if (this == OreSpawnMain.MySmallRock) r.placeRock(1); 
/*  72 */         if (this == OreSpawnMain.MyRock) r.placeRock(2); 
/*  73 */         if (this == OreSpawnMain.MyRedRock) r.placeRock(3); 
/*  74 */         if (this == OreSpawnMain.MyGreenRock) r.placeRock(4); 
/*  75 */         if (this == OreSpawnMain.MyBlueRock) r.placeRock(5); 
/*  76 */         if (this == OreSpawnMain.MyPurpleRock) r.placeRock(6); 
/*  77 */         if (this == OreSpawnMain.MySpikeyRock) r.placeRock(7); 
/*  78 */         if (this == OreSpawnMain.MyTNTRock) r.placeRock(8); 
/*  79 */         if (this == OreSpawnMain.MyCrystalRedRock) r.placeRock(9); 
/*  80 */         if (this == OreSpawnMain.MyCrystalGreenRock) r.placeRock(10); 
/*  81 */         if (this == OreSpawnMain.MyCrystalBlueRock) r.placeRock(11); 
/*  82 */         if (this == OreSpawnMain.MyCrystalTNTRock) r.placeRock(12);
/*     */       
/*     */       } 
/*     */     } 
/*  86 */     if (!par2EntityPlayer.capabilities.isCreativeMode)
/*     */     {
/*  88 */       par1ItemStack.stackSize--;
/*     */     }
/*     */     
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/*  96 */     Entity var8 = null;
/*     */ 
/*     */     
/*  99 */     var8 = EntityList.createEntityByName(par1, par0World);
/*     */     
/* 101 */     if (var8 != null) {
/*     */ 
/*     */       
/* 104 */       if (par2 > 0.0D) par2 += 0.5D; 
/* 105 */       if (par2 < 0.0D) par2 -= 0.5D; 
/* 106 */       if (par6 > 0.0D) par6 += 0.5D; 
/* 107 */       if (par6 < 0.0D) par6 -= 0.5D; 
/* 108 */       var8.setLocationAndAngles(par2, par4 + 0.01D, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 111 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 113 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 116 */     return var8;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 122 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemRock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */