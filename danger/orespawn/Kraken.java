/*      */ package danger.orespawn;
/*      */ 
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.enchantment.Enchantment;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.effect.EntityLightningBolt;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.monster.EntityMob;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.storage.WorldInfo;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Kraken
/*      */   extends EntityMob
/*      */ {
/*   64 */   private GenericTargetSorter TargetSorter = null;
/*   65 */   private RenderInfo renderdata = new RenderInfo();
/*   66 */   private ChunkCoordinates currentFlightTarget = null;
/*   67 */   private EntityLivingBase caught = null;
/*   68 */   private int newtarget = 0;
/*   69 */   private int release = 0;
/*   70 */   private int weather_set = 10;
/*   71 */   private int long_enough = 3600;
/*   72 */   private int call_reinforcements = 0;
/*      */   private boolean hit_by_player = false;
/*   74 */   private int straight_down = 1;
/*   75 */   private int hurt_timer = 0;
/*      */ 
/*      */   
/*      */   public Kraken(World par1World) {
/*   79 */     super(par1World);
/*   80 */     if (OreSpawnMain.PlayNicely == 0) {
/*   81 */       setSize(4.0F, 15.0F);
/*      */     } else {
/*   83 */       setSize(1.3333334F, 5.0F);
/*      */     } 
/*   85 */     getNavigator().setAvoidsWater(false);
/*   86 */     this.experienceValue = 500;
/*   87 */     this.fireResistance = 120;
/*   88 */     this.isImmuneToFire = true;
/*   89 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*   90 */     this.renderdata = new RenderInfo();
/*   91 */     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*   92 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*   97 */     super.applyEntityAttributes();
/*   98 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*   99 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3700000047683716D);
/*  100 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Kraken_stats.attack);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  105 */     super.entityInit();
/*  106 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  107 */     this.dataWatcher.addObject(21, Integer.valueOf(OreSpawnMain.PlayNicely));
/*  108 */     if (this.renderdata == null) {
/*  109 */       this.renderdata = new RenderInfo();
/*      */     }
/*  111 */     this.renderdata.rf1 = 0.0F;
/*  112 */     this.renderdata.rf2 = 0.0F;
/*  113 */     this.renderdata.rf3 = 0.0F;
/*  114 */     this.renderdata.rf4 = 0.0F;
/*  115 */     this.renderdata.ri1 = 0;
/*  116 */     this.renderdata.ri2 = 0;
/*  117 */     this.renderdata.ri3 = 0;
/*  118 */     this.renderdata.ri4 = 0;
/*      */   }
/*      */   
/*      */   public int getPlayNicely() {
/*  122 */     return this.dataWatcher.getWatchableObjectInt(21);
/*      */   }
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  127 */     return OreSpawnMain.Kraken_stats.health;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getKrakenHealth() {
/*  134 */     return (int)getHealth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RenderInfo getRenderInfo() {
/*  141 */     return this.renderdata;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRenderInfo(RenderInfo r) {
/*  146 */     this.renderdata.rf1 = r.rf1;
/*  147 */     this.renderdata.rf2 = r.rf2;
/*  148 */     this.renderdata.rf3 = r.rf3;
/*  149 */     this.renderdata.rf4 = r.rf4;
/*  150 */     this.renderdata.ri1 = r.ri1;
/*  151 */     this.renderdata.ri2 = r.ri2;
/*  152 */     this.renderdata.ri3 = r.ri3;
/*  153 */     this.renderdata.ri4 = r.ri4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  161 */     return OreSpawnMain.Kraken_stats.defense;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isAIEnabled() {
/*  169 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  178 */     super.onLivingUpdate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/*  186 */     Entity var8 = null;
/*  187 */     var8 = EntityList.createEntityByName(par1, par0World);
/*  188 */     if (var8 != null) {
/*      */ 
/*      */       
/*  191 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/*  194 */       par0World.spawnEntityInWorld(var8);
/*      */       
/*  196 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*  198 */     return var8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  207 */     super.onUpdate();
/*      */     
/*  209 */     if (this.isDead) {
/*      */       return;
/*      */     }
/*      */     
/*  213 */     if (this.currentFlightTarget == null) {
/*  214 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)(this.posY - 10.0D), (int)this.posZ);
/*      */     }
/*  216 */     else if (this.posY < this.currentFlightTarget.posY) {
/*  217 */       this.motionY *= 0.72D;
/*      */     } else {
/*  219 */       this.motionY *= 0.5D;
/*      */     } 
/*      */ 
/*      */     
/*  223 */     if (this.weather_set > 0 && OreSpawnMain.PlayNicely == 0) {
/*  224 */       this.weather_set--;
/*  225 */       if (this.weather_set == 0 && !this.worldObj.isRemote) {
/*      */         
/*  227 */         WorldInfo worldinfo = this.worldObj.getWorldInfo();
/*  228 */         if (!this.worldObj.isRaining()) {
/*  229 */           worldinfo.setRainTime(300);
/*  230 */           worldinfo.setThunderTime(300);
/*  231 */           worldinfo.setRaining(true);
/*  232 */           worldinfo.setThundering(true);
/*      */         } else {
/*  234 */           worldinfo.setRainTime(300);
/*  235 */           worldinfo.setThunderTime(300);
/*      */         } 
/*  237 */         this.weather_set = 100;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/*  246 */     super.writeEntityToNBT(par1NBTTagCompound);
/*  247 */     par1NBTTagCompound.setInteger("LongEnough", this.long_enough);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/*  256 */     super.readEntityFromNBT(par1NBTTagCompound);
/*  257 */     this.long_enough = par1NBTTagCompound.getInteger("LongEnough");
/*      */   }
/*      */ 
/*      */   
/*      */   protected String getLivingSound() {
/*  262 */     if (this.rand.nextInt(5) == 0) {
/*  263 */       return "orespawn:kraken_living";
/*      */     }
/*  265 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  273 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  281 */     return "orespawn:alo_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  288 */     return 2.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundPitch() {
/*  295 */     return 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  303 */     return Items.quartz;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRand(Item index, int par1) {
/*  309 */     EntityItem var3 = null;
/*  310 */     ItemStack is = new ItemStack(index, par1, 0);
/*      */     
/*  312 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), is);
/*      */     
/*  314 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/*  315 */     return is;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  323 */     ItemStack is = null;
/*      */ 
/*      */     
/*  326 */     dropItemRand(OreSpawnMain.MyKrakenTooth, 1);
/*  327 */     dropItemRand(Items.item_frame, 1);
/*      */     
/*  329 */     int var5 = 120 + this.worldObj.rand.nextInt(160); int var4;
/*  330 */     for (var4 = 0; var4 < var5; var4++) {
/*  331 */       dropItemRand(Items.dye, 1);
/*      */     }
/*      */     
/*  334 */     int i = 5 + this.worldObj.rand.nextInt(10);
/*  335 */     for (var4 = 0; var4 < i; var4++) {
/*  336 */       EntityItem var33; int var3 = this.worldObj.rand.nextInt(53);
/*  337 */       switch (var3) {
/*      */         case 0:
/*  339 */           is = dropItemRand(OreSpawnMain.MyUltimateSword, 1);
/*      */           break;
/*      */         case 1:
/*  342 */           is = dropItemRand(Items.diamond, 1);
/*      */           break;
/*      */         case 2:
/*  345 */           is = dropItemRand(Item.getItemFromBlock(Blocks.diamond_block), 1);
/*      */           break;
/*      */         case 3:
/*  348 */           is = dropItemRand(Items.diamond_sword, 1);
/*  349 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*  350 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/*  351 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/*  352 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/*  353 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  354 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/*  355 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 4:
/*  358 */           is = dropItemRand(Items.diamond_shovel, 1);
/*  359 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  360 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 5:
/*  363 */           is = dropItemRand(Items.diamond_pickaxe, 1);
/*  364 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  365 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*  366 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 6:
/*  369 */           is = dropItemRand(Items.diamond_axe, 1);
/*  370 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  371 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 7:
/*  374 */           is = dropItemRand(Items.diamond_hoe, 1);
/*  375 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  376 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 8:
/*  379 */           is = dropItemRand((Item)Items.diamond_helmet, 1);
/*  380 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  381 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  382 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  383 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  384 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  385 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2)); 
/*  386 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 9:
/*  389 */           is = dropItemRand((Item)Items.diamond_chestplate, 1);
/*  390 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  391 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  392 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  393 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  394 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 10:
/*  397 */           is = dropItemRand((Item)Items.diamond_leggings, 1);
/*  398 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  399 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  400 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  401 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  402 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 11:
/*  405 */           is = dropItemRand((Item)Items.diamond_boots, 1);
/*  406 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/*  407 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 12:
/*  410 */           is = dropItemRand(OreSpawnMain.MyUltimateBow, 1);
/*      */           break;
/*      */         case 13:
/*  413 */           is = dropItemRand(OreSpawnMain.MyUltimateAxe, 1);
/*      */           break;
/*      */         case 14:
/*  416 */           is = dropItemRand(Items.iron_ingot, 1);
/*      */           break;
/*      */         case 15:
/*  419 */           is = dropItemRand(OreSpawnMain.MyUltimatePickaxe, 1);
/*      */           break;
/*      */         case 16:
/*  422 */           is = dropItemRand(Items.iron_sword, 1);
/*  423 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*  424 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/*  425 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/*  426 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/*  427 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  428 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/*  429 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 17:
/*  432 */           is = dropItemRand(Items.iron_shovel, 1);
/*  433 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  434 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 18:
/*  437 */           is = dropItemRand(Items.iron_pickaxe, 1);
/*  438 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  439 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*  440 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 19:
/*  443 */           is = dropItemRand(Items.iron_axe, 1);
/*  444 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  445 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 20:
/*  448 */           is = dropItemRand(Items.iron_hoe, 1);
/*  449 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  450 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 21:
/*  453 */           is = dropItemRand((Item)Items.iron_helmet, 1);
/*  454 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  455 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  456 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  457 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  458 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  459 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5)); 
/*  460 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 22:
/*  463 */           is = dropItemRand((Item)Items.iron_chestplate, 1);
/*  464 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  465 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  466 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  467 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  468 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 23:
/*  471 */           is = dropItemRand((Item)Items.iron_leggings, 1);
/*  472 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  473 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  474 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  475 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  476 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 24:
/*  479 */           is = dropItemRand((Item)Items.iron_boots, 1);
/*  480 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/*  481 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 25:
/*  484 */           is = dropItemRand(OreSpawnMain.MyUltimateShovel, 1);
/*      */           break;
/*      */         case 26:
/*  487 */           dropItemRand(Item.getItemFromBlock(Blocks.iron_block), 1);
/*      */           break;
/*      */         case 27:
/*  490 */           is = dropItemRand(Items.gold_nugget, 1);
/*      */           break;
/*      */         case 28:
/*  493 */           is = dropItemRand(Items.gold_ingot, 1);
/*      */           break;
/*      */         case 29:
/*  496 */           is = dropItemRand(Items.golden_carrot, 1);
/*      */           break;
/*      */         case 30:
/*  499 */           is = dropItemRand(Items.golden_sword, 1);
/*  500 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*  501 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/*  502 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/*  503 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/*  504 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  505 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/*  506 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 31:
/*  509 */           is = dropItemRand(Items.golden_shovel, 1);
/*  510 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  511 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 32:
/*  514 */           is = dropItemRand(Items.golden_pickaxe, 1);
/*  515 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  516 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*  517 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 33:
/*  520 */           is = dropItemRand(Items.golden_axe, 1);
/*  521 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  522 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 34:
/*  525 */           is = dropItemRand(Items.golden_hoe, 1);
/*  526 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  527 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 35:
/*  530 */           is = dropItemRand((Item)Items.golden_helmet, 1);
/*  531 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  532 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  533 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  534 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  535 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  536 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5)); 
/*  537 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 36:
/*  540 */           is = dropItemRand((Item)Items.golden_chestplate, 1);
/*  541 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  542 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  543 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  544 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  545 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 37:
/*  548 */           is = dropItemRand((Item)Items.golden_leggings, 1);
/*  549 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  550 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  551 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  552 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  553 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 38:
/*  556 */           is = dropItemRand((Item)Items.golden_boots, 1);
/*  557 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/*  558 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 39:
/*  561 */           dropItemRand(Items.golden_apple, 1);
/*      */           break;
/*      */         case 40:
/*  564 */           dropItemRand(Item.getItemFromBlock(Blocks.gold_block), 1);
/*      */           break;
/*      */         
/*      */         case 41:
/*  568 */           var33 = null;
/*  569 */           is = new ItemStack(Items.golden_apple, 1, 1);
/*  570 */           var33 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), is);
/*      */           
/*  572 */           if (var33 != null) this.worldObj.spawnEntityInWorld((Entity)var33);
/*      */           
/*      */           break;
/*      */         case 42:
/*  576 */           is = dropItemRand(OreSpawnMain.MyExperienceSword, 1);
/*  577 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*  578 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/*  579 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/*  580 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/*  581 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  582 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/*  583 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 43:
/*  586 */           is = dropItemRand((Item)OreSpawnMain.ExperienceHelmet, 1);
/*  587 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  588 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  589 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  590 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  591 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  592 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5)); 
/*  593 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 44:
/*  596 */           is = dropItemRand((Item)OreSpawnMain.ExperienceBody, 1);
/*  597 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  598 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  599 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  600 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  601 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 45:
/*  604 */           is = dropItemRand((Item)OreSpawnMain.ExperienceLegs, 1);
/*  605 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  606 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  607 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  608 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  609 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 46:
/*  612 */           is = dropItemRand((Item)OreSpawnMain.ExperienceBoots, 1);
/*  613 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/*  614 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 47:
/*  617 */           is = dropItemRand(OreSpawnMain.MyAmethystSword, 1);
/*  618 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*  619 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/*  620 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/*  621 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/*  622 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  623 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/*  624 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 48:
/*  627 */           is = dropItemRand(OreSpawnMain.MyAmethystShovel, 1);
/*  628 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  629 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 49:
/*  632 */           is = dropItemRand(OreSpawnMain.MyAmethystPickaxe, 1);
/*  633 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  634 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*  635 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 50:
/*  638 */           is = dropItemRand(OreSpawnMain.MyAmethystAxe, 1);
/*  639 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  640 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 51:
/*  643 */           is = dropItemRand(OreSpawnMain.MyAmethystHoe, 1);
/*  644 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  645 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 52:
/*  648 */           is = dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyBlockAmethystBlock), 1);
/*      */           break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  664 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/*  672 */     if (isNoDespawnRequired()) return false; 
/*  673 */     if (this.long_enough <= 0) return true; 
/*  674 */     if (this.posY > 150.0D && getHealth() < (mygetMaxHealth() / 2)) return true; 
/*  675 */     if (this.posY > 180.0D && this.long_enough <= 0) {
/*  676 */       setDead();
/*  677 */       return true;
/*      */     } 
/*  679 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  687 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITasks() {
/*  693 */     int xdir = 1;
/*  694 */     int zdir = 1;
/*      */     
/*  696 */     int keep_trying = 50;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  701 */     if (this.isDead)
/*      */       return; 
/*  703 */     super.updateAITasks();
/*      */     
/*  705 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/*  706 */     if (this.long_enough > 0) this.long_enough--;
/*      */     
/*  708 */     this.dataWatcher.updateObject(21, Integer.valueOf(OreSpawnMain.PlayNicely));
/*      */     
/*  710 */     if (this.worldObj.rand.nextInt(400) == 1 && OreSpawnMain.PlayNicely == 0)
/*      */     {
/*  712 */       this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, this.posX, this.posY - 16.0D, this.posZ));
/*      */     }
/*      */ 
/*      */     
/*  716 */     if (this.currentFlightTarget == null) {
/*  717 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     }
/*      */ 
/*      */     
/*  721 */     if (this.newtarget != 0 || this.rand.nextInt(250) == 1 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 9.1F) {
/*      */       
/*  723 */       this.newtarget = 0;
/*      */       int ground_dist;
/*  725 */       for (ground_dist = 0; ground_dist < 31; ground_dist++) {
/*  726 */         Block block = this.worldObj.getBlock((int)this.posX, (int)this.posY - ground_dist, (int)this.posZ);
/*  727 */         if (block != Blocks.air) {
/*  728 */           this.straight_down = 0;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*  733 */       ground_dist = 20 - ground_dist;
/*      */       
/*  735 */       Block bid = Blocks.stone;
/*  736 */       while (bid != Blocks.air && keep_trying != 0) {
/*  737 */         zdir = this.worldObj.rand.nextInt(6) + 12;
/*  738 */         xdir = this.worldObj.rand.nextInt(6) + 12;
/*  739 */         if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir; 
/*  740 */         if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir; 
/*  741 */         if (this.straight_down != 0) {
/*  742 */           zdir = xdir = 0;
/*      */         }
/*  744 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + ground_dist + this.rand.nextInt(9) - 6, (int)this.posZ + zdir);
/*  745 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/*  746 */         if (bid == Blocks.air && 
/*  747 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/*  748 */           bid = Blocks.stone;
/*      */         }
/*      */         
/*  751 */         keep_trying--;
/*      */       } 
/*      */       
/*  754 */       if (this.long_enough <= 0 || (this.posY < 200.0D && getHealth() < (mygetMaxHealth() / 4))) {
/*  755 */         this.currentFlightTarget.set(this.currentFlightTarget.posX, this.currentFlightTarget.posY + 30, this.currentFlightTarget.posZ);
/*  756 */         if (this.hit_by_player == true && this.call_reinforcements == 0 && getHealth() < (mygetMaxHealth() / 8) && this.posY > 130.0D)
/*      */         {
/*  758 */           this.call_reinforcements = 1;
/*      */           
/*  760 */           for (int i = 0; i < 10; i++) {
/*  761 */             EntityCreature newent = (EntityCreature)spawnCreature(this.worldObj, "The Kraken", this.posX + this.worldObj.rand.nextInt(10) - this.worldObj.rand.nextInt(10), 170.0D, this.posZ + this.worldObj.rand.nextInt(10) - this.worldObj.rand.nextInt(10));
/*      */           
/*      */           }
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  769 */     else if (this.caught == null && this.worldObj.rand.nextInt(8) == 1 && OreSpawnMain.PlayNicely == 0) {
/*      */       
/*  771 */       EntityPlayer target = null;
/*      */       
/*  773 */       target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(25.0D, 40.0D, 25.0D), (Entity)this);
/*  774 */       if (target != null)
/*      */       {
/*  776 */         if (!target.capabilities.isCreativeMode) {
/*      */           
/*  778 */           if (getEntitySenses().canSee((Entity)target)) {
/*  779 */             this.currentFlightTarget.set((int)target.posX, (int)target.posY + 15, (int)target.posZ);
/*  780 */             attackWithSomething((EntityLivingBase)target);
/*      */           } 
/*      */         } else {
/*  783 */           target = null;
/*      */         } 
/*      */       }
/*      */       
/*  787 */       if (target == null && this.worldObj.rand.nextInt(2) == 0) {
/*  788 */         EntityLivingBase e = null;
/*  789 */         e = findSomethingToAttack();
/*  790 */         if (e != null) {
/*      */ 
/*      */           
/*  793 */           this.currentFlightTarget.set((int)e.posX, (int)e.posY + 15, (int)e.posZ);
/*  794 */           attackWithSomething(e);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  800 */     if (this.caught != null) {
/*  801 */       if (!this.caught.isDead) {
/*  802 */         this.currentFlightTarget.set((int)this.posX, 200, (int)this.posZ);
/*  803 */         if (this.posY > 190.0D) this.release = 1; 
/*  804 */         this.caught.motionX = this.motionX;
/*  805 */         this.caught.motionZ = this.motionZ;
/*  806 */         this.caught.motionY = this.motionY;
/*  807 */         this.caught.posX = this.posX;
/*  808 */         if (this.posY - this.caught.posY > 16.0D) {
/*  809 */           this.caught.motionY += 0.25D;
/*      */         }
/*  811 */         this.caught.posY = this.posY - 15.0D;
/*  812 */         this.caught.posZ = this.posZ;
/*      */         
/*  814 */         this.caught.rotationYaw = this.rotationYaw;
/*  815 */         if (this.worldObj.rand.nextInt(50) == 1) {
/*  816 */           attackEntityAsMob((Entity)this.caught);
/*      */         }
/*  818 */         if (this.release != 0 || this.worldObj.rand.nextInt(250) == 1) {
/*  819 */           this.caught = null;
/*      */           
/*  821 */           this.newtarget = 1;
/*  822 */           this.release = 0;
/*  823 */           setAttacking(0);
/*      */         } 
/*      */       } else {
/*  826 */         this.caught = null;
/*      */         
/*  828 */         this.newtarget = 1;
/*  829 */         this.release = 0;
/*  830 */         setAttacking(0);
/*      */       } 
/*      */     }
/*      */     
/*  834 */     double var1 = this.currentFlightTarget.posX + 0.3D - this.posX;
/*  835 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/*  836 */     double var5 = this.currentFlightTarget.posZ + 0.3D - this.posZ;
/*  837 */     this.motionX += (Math.signum(var1) * 0.45D - this.motionX) * 0.15D;
/*  838 */     this.motionY += (Math.signum(var3) * 0.70999D - this.motionY) * 0.202D;
/*  839 */     this.motionZ += (Math.signum(var5) * 0.45D - this.motionZ) * 0.15D;
/*  840 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/*  841 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/*  842 */     this.moveForward = 0.4F;
/*  843 */     if (Math.abs(this.motionX) + Math.abs(this.motionZ) < 0.15D) var8 = 0.0F; 
/*  844 */     this.rotationYaw += var8 / 5.0F;
/*      */ 
/*      */     
/*  847 */     double obstruction_factor = 0.0D;
/*  848 */     double dx = 0.0D, dz = 0.0D;
/*  849 */     int dist = 10;
/*      */     
/*  851 */     for (int k = -20; k < 18; k += 2) {
/*  852 */       for (int i = 1; i < dist; i += 2) {
/*  853 */         dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/*  854 */         dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/*  855 */         Block bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY + k, (int)(this.posZ + dz));
/*      */         
/*  857 */         if (bid != Blocks.air) {
/*  858 */           obstruction_factor += 0.1D;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  865 */     this.motionY += obstruction_factor * 0.08D;
/*  866 */     this.posY += obstruction_factor * 0.08D;
/*      */     
/*  868 */     if (this.posY > 256.0D && !isNoDespawnRequired()) setDead();
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void attackWithSomething(EntityLivingBase par1) {
/*  876 */     if (this.caught != null)
/*  877 */       return;  double dist = (this.posX - par1.posX) * (this.posX - par1.posX);
/*  878 */     dist += (this.posZ - par1.posZ) * (this.posZ - par1.posZ);
/*  879 */     dist += (this.posY - par1.posY - 15.0D) * (this.posY - par1.posY - 15.0D);
/*  880 */     if (dist < 30.0D) {
/*      */       
/*  882 */       this.caught = par1;
/*  883 */       this.release = 0;
/*  884 */       setAttacking(1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  896 */     if (par1EntityLiving == null)
/*      */     {
/*  898 */       return false;
/*      */     }
/*  900 */     if (par1EntityLiving == this)
/*      */     {
/*  902 */       return false;
/*      */     }
/*  904 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*  906 */       return false;
/*      */     }
/*      */     
/*  909 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*      */     
/*  911 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/*  914 */       return false;
/*      */     }
/*      */     
/*  917 */     if (par1EntityLiving instanceof EntityPlayer) {
/*      */       
/*  919 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/*  920 */       if (p.capabilities.isCreativeMode == true) {
/*  921 */         return false;
/*      */       }
/*  923 */       if (p.capabilities.isFlying == true) {
/*  924 */         return false;
/*      */       }
/*  926 */       return true;
/*      */     } 
/*  928 */     if (!par1EntityLiving.onGround && !par1EntityLiving.isInWater())
/*      */     {
/*  930 */       return false;
/*      */     }
/*      */     
/*  933 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntitySquid)
/*      */     {
/*  935 */       return false;
/*      */     }
/*  937 */     if (par1EntityLiving instanceof AttackSquid)
/*      */     {
/*  939 */       return false;
/*      */     }
/*  941 */     if (par1EntityLiving instanceof Kraken)
/*      */     {
/*  943 */       return false;
/*      */     }
/*  945 */     if (par1EntityLiving instanceof Spyro)
/*      */     {
/*  947 */       return false;
/*      */     }
/*  949 */     if (par1EntityLiving instanceof Dragon) {
/*      */       
/*  951 */       Dragon c = (Dragon)par1EntityLiving;
/*  952 */       if (c.riddenByEntity != null) return false; 
/*  953 */       return true;
/*      */     } 
/*  955 */     if (par1EntityLiving instanceof Cephadrome) {
/*      */       
/*  957 */       Cephadrome c = (Cephadrome)par1EntityLiving;
/*  958 */       if (c.riddenByEntity != null) return false; 
/*  959 */       return true;
/*      */     } 
/*  961 */     if (par1EntityLiving instanceof Leon) {
/*      */       
/*  963 */       Leon c = (Leon)par1EntityLiving;
/*  964 */       if (c.riddenByEntity != null) return false; 
/*  965 */       return true;
/*      */     } 
/*  967 */     if (par1EntityLiving instanceof ThePrinceTeen) {
/*      */       
/*  969 */       ThePrinceTeen c = (ThePrinceTeen)par1EntityLiving;
/*  970 */       if (c.riddenByEntity != null) return false; 
/*  971 */       return true;
/*      */     } 
/*  973 */     if (par1EntityLiving instanceof ThePrinceAdult) {
/*      */       
/*  975 */       ThePrinceAdult c = (ThePrinceAdult)par1EntityLiving;
/*  976 */       if (c.riddenByEntity != null) return false; 
/*  977 */       return true;
/*      */     } 
/*      */     
/*  980 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntityChicken)
/*      */     {
/*  982 */       return false;
/*      */     }
/*  984 */     if (par1EntityLiving instanceof Chipmunk)
/*      */     {
/*  986 */       return false;
/*      */     }
/*  988 */     if (par1EntityLiving instanceof StinkBug)
/*      */     {
/*  990 */       return false;
/*      */     }
/*  992 */     if (par1EntityLiving instanceof Mothra)
/*      */     {
/*  994 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  998 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/* 1003 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 1004 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 40.0D, 20.0D));
/* 1005 */     Collections.sort(var5, this.TargetSorter);
/* 1006 */     Iterator<?> var2 = var5.iterator();
/* 1007 */     Entity var3 = null;
/* 1008 */     EntityLivingBase var4 = null;
/*      */     
/* 1010 */     while (var2.hasNext()) {
/*      */       
/* 1012 */       var3 = (Entity)var2.next();
/* 1013 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1015 */       if (isSuitableTarget(var4, false))
/*      */       {
/* 1017 */         return var4;
/*      */       }
/*      */     } 
/* 1020 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 1031 */     Entity e = par1DamageSource.getEntity();
/* 1032 */     boolean ret = false;
/* 1033 */     if (this.currentFlightTarget != null && e != null && e instanceof EntityPlayer && getHealth() > (mygetMaxHealth() / 4)) {
/*      */       
/* 1035 */       this.hit_by_player = true;
/*      */       
/* 1037 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY + 15, (int)e.posZ);
/*      */     } 
/*      */     
/* 1040 */     if (this.hurt_timer > 0) return false; 
/* 1041 */     this.hurt_timer = 30;
/* 1042 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 1043 */     if (this.worldObj.rand.nextInt(2) == 1) {
/* 1044 */       this.release = 1;
/*      */     }
/*      */     
/* 1047 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getAttacking() {
/* 1053 */     return this.dataWatcher.getWatchableObjectByte(20);
/*      */   }
/*      */   
/*      */   public final void setAttacking(int par1) {
/* 1057 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void fall(float par1) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateFallState(double par1, boolean par3) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/* 1081 */     if (this.posY < 50.0D) return false;
/*      */ 
/*      */ 
/*      */     
/* 1085 */     for (int k = -1; k < 2; k++) {
/*      */       
/* 1087 */       for (int j = -1; j < 1; j++) {
/*      */         
/* 1089 */         for (int i = 1; i < 6; i++) {
/*      */           
/* 1091 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 1092 */           if (bid != Blocks.air && bid != Blocks.tallgrass) return false; 
/*      */         } 
/*      */       } 
/*      */     } 
/* 1096 */     return true;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Kraken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */