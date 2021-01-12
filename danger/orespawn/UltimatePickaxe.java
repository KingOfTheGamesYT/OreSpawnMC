/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemPickaxe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UltimatePickaxe
/*     */   extends ItemPickaxe
/*     */ {
/*  27 */   private int weaponDamage = 15;
/*     */ 
/*     */   
/*     */   public UltimatePickaxe(int par1, Item.ToolMaterial par2) {
/*  31 */     super(par2);
/*  32 */     this.maxStackSize = 1;
/*  33 */     setMaxDamage(3000);
/*  34 */     setCreativeTab(CreativeTabs.tabTools);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  39 */     par1ItemStack.addEnchantment(Enchantment.efficiency, 5);
/*  40 */     par1ItemStack.addEnchantment(Enchantment.fortune, 5);
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
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/*  52 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack);
/*  53 */     if (lvl <= 0) {
/*  54 */       stack.addEnchantment(Enchantment.efficiency, 5);
/*  55 */       stack.addEnchantment(Enchantment.fortune, 5);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
/*  61 */     onUsingTick(stack, (EntityPlayer)null, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canHarvestBlock(Block par1Block) {
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDamageVsEntity(Entity par1Entity) {
/*  77 */     if (par1Entity instanceof Girlfriend) {
/*  78 */       return 1;
/*     */     }
/*  80 */     if (par1Entity instanceof Boyfriend) {
/*  81 */       return 1;
/*     */     }
/*  83 */     if (par1Entity instanceof EntityPlayer) {
/*  84 */       return 1;
/*     */     }
/*  86 */     return this.weaponDamage;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
/*  91 */     if (entity != null && OreSpawnMain.ultimate_sword_pvp == 0) {
/*  92 */       if (entity instanceof EntityPlayer || entity instanceof Girlfriend || entity instanceof Boyfriend) {
/*  93 */         return true;
/*     */       }
/*  95 */       if (entity instanceof EntityTameable) {
/*  96 */         EntityTameable t = (EntityTameable)entity;
/*  97 */         if (t.isTamed()) {
/*  98 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemAnItem(World world, int x, int y, int z, Item index, int par1) {
/* 107 */     EntityItem var3 = null;
/* 108 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 110 */     var3 = new EntityItem(world, x, y, z, is);
/* 111 */     if (var3 != null) world.spawnEntityInWorld((Entity)var3); 
/* 112 */     return is;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
/* 117 */     if (par3.getBlockHardness(par2World, par4, par5, par6) != 0.0D)
/*     */     {
/* 119 */       par1ItemStack.damageItem(1, par7EntityLivingBase);
/*     */     }
/* 121 */     if (!par2World.isRemote) {
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
/* 133 */       if (par3 == Blocks.iron_ore && 
/* 134 */         par2World.rand.nextInt(2) != 0) dropItemAnItem(par2World, par4, par5, par6, Items.iron_ingot, 1 + par2World.rand.nextInt(2));
/*     */       
/* 136 */       if (par3 == Blocks.gold_ore && 
/* 137 */         par2World.rand.nextInt(2) != 0) dropItemAnItem(par2World, par4, par5, par6, Items.gold_ingot, 1 + par2World.rand.nextInt(2));
/*     */ 
/*     */       
/* 140 */       if (par3 == Blocks.stone && 
/* 141 */         par2World.rand.nextInt(100) == 2) {
/* 142 */         int i = par2World.rand.nextInt(10);
/* 143 */         if (i == 0) dropItemAnItem(par2World, par4, par5, par6, Items.diamond, 1); 
/* 144 */         if (i == 1) dropItemAnItem(par2World, par4, par5, par6, Items.emerald, 1); 
/* 145 */         if (i == 2) dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.MyAmethyst, 1); 
/* 146 */         if (i == 3) dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.MyRuby, 1); 
/* 147 */         if (i == 4) dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.UraniumNugget, 1); 
/* 148 */         if (i == 5) dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.TitaniumNugget, 1);
/*     */       
/*     */       } 
/*     */     } 
/*     */     
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMaterialName() {
/* 159 */     return "Uranium/Titanium";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 164 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\UltimatePickaxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */