/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExperienceSword
/*     */   extends ItemSword
/*     */ {
/*     */   private int weaponDamage;
/*     */   private final Item.ToolMaterial toolMaterial;
/*  28 */   private World worldObj = null;
/*  29 */   private World worldObjr = null;
/*     */ 
/*     */   
/*     */   public ExperienceSword(int par1, Item.ToolMaterial par2EnumToolMaterial) {
/*  33 */     super(par2EnumToolMaterial);
/*  34 */     this.toolMaterial = par2EnumToolMaterial;
/*  35 */     this.weaponDamage = 15;
/*  36 */     this.maxStackSize = 1;
/*  37 */     setMaxDamage(1400);
/*  38 */     setCreativeTab(CreativeTabs.tabCombat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  43 */     par1ItemStack.addEnchantment(Enchantment.sharpness, 2);
/*  44 */     par1ItemStack.addEnchantment(Enchantment.unbreaking, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/*  55 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);
/*  56 */     if (lvl <= 0) {
/*  57 */       stack.addEnchantment(Enchantment.sharpness, 2);
/*  58 */       stack.addEnchantment(Enchantment.unbreaking, 3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
/*  67 */     EntityLivingBase e = null;
/*  68 */     ItemOreSpawnArmor ia = null;
/*  69 */     EntityPlayer p = null;
/*     */     
/*  71 */     onUsingTick(stack, (EntityPlayer)null, 0);
/*  72 */     if (this.worldObj == null && !par2World.isRemote) this.worldObj = par2World; 
/*  73 */     if (this.worldObjr == null && par2World.isRemote) this.worldObjr = par2World;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     if (par2World.rand.nextInt(60) == 1)
/*     */     {
/*  80 */       if (par3Entity != null && 
/*  81 */         par3Entity instanceof EntityLivingBase) {
/*  82 */         e = (EntityLivingBase)par3Entity;
/*     */         
/*  84 */         if (e instanceof EntityPlayer) {
/*  85 */           p = (EntityPlayer)e;
/*     */         }
/*  87 */         for (int i = 1; i < 5; i++) {
/*  88 */           ItemStack is = p.getEquipmentInSlot(i);
/*  89 */           if (is != null) {
/*  90 */             Item it = is.getItem();
/*  91 */             if (it != null)
/*     */             {
/*  93 */               if (it instanceof ItemOreSpawnArmor) {
/*  94 */                 ia = (ItemOreSpawnArmor)it;
/*  95 */                 if (ia.get_armor_material() == 4)
/*     */                 {
/*  97 */                   switch (ia.get_armor_type()) {
/*     */                     case 0:
/*  99 */                       if (!par2World.isRemote && p != null && par2World.rand.nextInt(10) == 1) {
/* 100 */                         p.addExperience(1);
/*     */                       }
/* 102 */                       par2World.spawnParticle("portal", e.posX, e.posY + 1.5D, e.posZ, par2World.rand.nextGaussian(), par2World.rand.nextGaussian(), par2World.rand.nextGaussian());
/*     */                       break;
/*     */                     
/*     */                     case 1:
/* 106 */                       if (!par2World.isRemote && p != null && par2World.rand.nextInt(20) == 1) {
/* 107 */                         p.addExperience(1);
/*     */                       }
/* 109 */                       par2World.spawnParticle("portal", e.posX, e.posY + 1.25D, e.posZ, par2World.rand.nextGaussian(), par2World.rand.nextGaussian(), par2World.rand.nextGaussian());
/*     */                       break;
/*     */                     
/*     */                     case 2:
/* 113 */                       if (!par2World.isRemote && p != null && par2World.rand.nextInt(30) == 1) {
/* 114 */                         p.addExperience(1);
/*     */                       }
/* 116 */                       par2World.spawnParticle("portal", e.posX, e.posY + 0.75D, e.posZ, par2World.rand.nextGaussian(), par2World.rand.nextGaussian(), par2World.rand.nextGaussian());
/*     */                       break;
/*     */                     
/*     */                     case 3:
/* 120 */                       if (!par2World.isRemote && p != null && par2World.rand.nextInt(40) == 1) {
/* 121 */                         p.addExperience(1);
/*     */                       }
/* 123 */                       par2World.spawnParticle("portal", e.posX, e.posY + 0.25D, e.posZ, par2World.rand.nextGaussian(), par2World.rand.nextGaussian(), par2World.rand.nextGaussian());
/*     */                       break;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
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
/*     */   public int getDamageVsEntity(Entity par1Entity) {
/* 144 */     return this.weaponDamage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMaterialName() {
/* 150 */     return "Emerald";
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
/*     */   public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
/* 176 */     float i = 0.0F;
/*     */     
/* 178 */     EntityPlayer p = null;
/* 179 */     EntityLiving l = null;
/* 180 */     if (par3EntityLiving instanceof EntityPlayer) {
/* 181 */       p = (EntityPlayer)par3EntityLiving;
/*     */     }
/* 183 */     if (par2EntityLiving != null && par2EntityLiving instanceof EntityLiving) {
/* 184 */       i = 10.0F;
/*     */     }
/* 186 */     if (i > 0.0F && 
/* 187 */       p != null) {
/* 188 */       p.addExperience((int)i);
/*     */     }
/*     */     
/* 191 */     if (p != null) {
/*     */       
/* 193 */       i = (p.experienceLevel / 2);
/* 194 */       if (i > 0.0F && par2EntityLiving != null) {
/* 195 */         par2EntityLiving.attackEntityFrom(DamageSource.causePlayerDamage(p), i);
/*     */       }
/*     */     } 
/* 198 */     if (this.worldObjr != null && par2EntityLiving != null) {
/* 199 */       for (int j = 0; j <= i / 2.0F; j++) {
/* 200 */         this.worldObjr.spawnParticle("portal", par2EntityLiving.posX, par2EntityLiving.posY + 1.0D, par2EntityLiving.posZ, this.worldObjr.rand.nextGaussian(), this.worldObjr.rand.nextGaussian(), this.worldObjr.rand.nextGaussian());
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 205 */     par1ItemStack.damageItem(1, par3EntityLiving);
/* 206 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 214 */     return 3000;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 220 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ExperienceSword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */