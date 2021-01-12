/*      */ package danger.orespawn;
/*      */ 
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityAgeable;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.ai.EntityAITempt;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemFood;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.EnumDifficulty;
/*      */ import net.minecraft.world.World;
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
/*      */ public class ThePrincess
/*      */   extends EntityTameable
/*      */ {
/*      */   private ChunkCoordinates currentFlightTarget;
/*   59 */   private GenericTargetSorter TargetSorter = null;
/*   60 */   public int activity = 1;
/*   61 */   private int owner_flying = 0;
/*   62 */   private float moveSpeed = 0.3F;
/*   63 */   private int syncit = 0;
/*   64 */   private int head1ext = 0;
/*   65 */   private int head2ext = 0;
/*   66 */   private int head3ext = 0;
/*   67 */   private int head1dir = 1;
/*   68 */   private int head2dir = 1;
/*   69 */   private int head3dir = 1;
/*   70 */   private int ok_to_grow = 0;
/*   71 */   private int kill_count = 0;
/*   72 */   private int fed_count = 0;
/*   73 */   private int day_count = 0;
/*   74 */   private int is_day = 0;
/*   75 */   private int attack_level = 1;
/*   76 */   private int ticker = 0;
/*      */ 
/*      */   
/*      */   public ThePrincess(World par1World) {
/*   80 */     super(par1World);
/*      */     
/*   82 */     setSize(0.75F, 1.25F);
/*   83 */     this.moveSpeed = 0.32F;
/*   84 */     this.fireResistance = 1000;
/*   85 */     this.isImmuneToFire = true;
/*   86 */     getNavigator().setAvoidsWater(true);
/*   87 */     setSitting(false);
/*   88 */     this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*   89 */     this.tasks.addTask(2, new MyEntityAIFollowOwner(this, 1.15F, 12.0F, 2.0F));
/*   90 */     this.tasks.addTask(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.beef, false));
/*   91 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 6.0F));
/*   92 */     this.tasks.addTask(5, new MyEntityAIWander((EntityCreature)this, 0.75F));
/*   93 */     this.tasks.addTask(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*   94 */     this.tasks.addTask(7, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*   95 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*   96 */     this.experienceValue = 50;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  101 */     super.applyEntityAttributes();
/*  102 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  103 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  104 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  105 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  110 */     super.entityInit();
/*  111 */     this.activity = 1;
/*  112 */     this.dataWatcher.addObject(22, Integer.valueOf(0));
/*  113 */     this.dataWatcher.addObject(21, Integer.valueOf(this.activity));
/*  114 */     this.dataWatcher.addObject(20, Integer.valueOf(1));
/*  115 */     this.dataWatcher.addObject(23, Integer.valueOf(this.attack_level));
/*  116 */     setSitting(false);
/*  117 */     setTamed(false);
/*  118 */     this.noClip = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPower() {
/*  123 */     return this.dataWatcher.getWatchableObjectInt(23);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPower(int par1) {
/*  128 */     this.dataWatcher.updateObject(23, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/*  136 */     super.writeEntityToNBT(par1NBTTagCompound);
/*  137 */     par1NBTTagCompound.setInteger("SpyroActivity", this.dataWatcher.getWatchableObjectInt(21));
/*  138 */     par1NBTTagCompound.setInteger("SpyroFire", this.dataWatcher.getWatchableObjectInt(20));
/*  139 */     par1NBTTagCompound.setInteger("SpyroGrow", this.ok_to_grow);
/*  140 */     par1NBTTagCompound.setInteger("SpyroKill", this.kill_count);
/*  141 */     par1NBTTagCompound.setInteger("SpyroFed", this.fed_count);
/*  142 */     par1NBTTagCompound.setInteger("SpyroDay", this.day_count);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/*  150 */     super.readEntityFromNBT(par1NBTTagCompound);
/*  151 */     this.activity = par1NBTTagCompound.getInteger("SpyroActivity");
/*  152 */     this.dataWatcher.updateObject(21, Integer.valueOf(this.activity));
/*  153 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1NBTTagCompound.getInteger("SpyroFire")));
/*  154 */     this.ok_to_grow = par1NBTTagCompound.getInteger("SpyroGrow");
/*  155 */     this.kill_count = par1NBTTagCompound.getInteger("SpyroKill");
/*  156 */     this.fed_count = par1NBTTagCompound.getInteger("SpyroFed");
/*  157 */     this.day_count = par1NBTTagCompound.getInteger("SpyroDay");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getActivity() {
/*  166 */     int i = this.dataWatcher.getWatchableObjectInt(21);
/*  167 */     this.activity = i;
/*  168 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivity(int par1) {
/*  174 */     this.activity = par1;
/*  175 */     this.dataWatcher.updateObject(21, Integer.valueOf(0));
/*  176 */     this.dataWatcher.updateObject(21, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSpyroFire() {
/*  182 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSpyroFire(int par1) {
/*  188 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/*  194 */     return this.dataWatcher.getWatchableObjectInt(22);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/*  200 */     this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */   
/*      */   public int getHead1Ext() {
/*  205 */     return this.head1ext;
/*      */   }
/*      */   
/*      */   public int getHead2Ext() {
/*  209 */     return this.head2ext;
/*      */   }
/*      */   
/*      */   public int getHead3Ext() {
/*  213 */     return this.head3ext;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/*  223 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBreatheUnderwater() {
/*  229 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  234 */     return 400;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  243 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */ 
/*      */     
/*  246 */     if (var2 != null)
/*      */     {
/*  248 */       if (var2.stackSize <= 0) {
/*      */         
/*  250 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  251 */         var2 = null;
/*      */       } 
/*      */     }
/*      */     
/*  255 */     if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*  256 */       if (!this.worldObj.isRemote) {
/*      */         
/*  258 */         setTamed(true);
/*  259 */         func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*  260 */         playTameEffect(true);
/*  261 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*  262 */         heal(mygetMaxHealth() - getHealth());
/*  263 */         this.ok_to_grow = 1;
/*  264 */         this.kill_count = 1000;
/*  265 */         this.fed_count = 1000;
/*  266 */         this.day_count = 1000;
/*      */       } 
/*      */ 
/*      */       
/*  270 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*  271 */         var2.stackSize--;
/*  272 */         if (var2.stackSize <= 0) {
/*  273 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  276 */       return true;
/*      */     } 
/*      */     
/*  279 */     if (isTamed() && var2 != null && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && var2.getItem() instanceof ItemFood) {
/*      */ 
/*      */ 
/*      */       
/*  283 */       if (!this.worldObj.isRemote) {
/*      */         
/*  285 */         ItemFood var3 = (ItemFood)var2.getItem();
/*      */         
/*  287 */         if (mygetMaxHealth() > getHealth())
/*      */         {
/*  289 */           heal((var3.getHealAmount(var2) * 10));
/*      */         }
/*      */         
/*  292 */         playTameEffect(true);
/*  293 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  299 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  301 */         var2.stackSize--;
/*  302 */         if (var2.stackSize <= 0)
/*      */         {
/*  304 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  307 */       return true;
/*  308 */     }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.ice) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  311 */       if (!this.worldObj.isRemote) {
/*      */         
/*  313 */         playTameEffect(true);
/*  314 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*  315 */         setSpyroFire(0);
/*  316 */         String healthMessage = new String();
/*  317 */         healthMessage = String.format("Princess fireballs extinguished.", new Object[0]);
/*  318 */         par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */       } 
/*      */       
/*  321 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  323 */         var2.stackSize--;
/*  324 */         if (var2.stackSize <= 0)
/*      */         {
/*  326 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  329 */       return true;
/*  330 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.flint_and_steel && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  333 */       if (!this.worldObj.isRemote) {
/*      */         
/*  335 */         playTameEffect(true);
/*  336 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*  337 */         setSpyroFire(1);
/*  338 */         String healthMessage = new String();
/*  339 */         healthMessage = String.format("Princess fireballs lit!", new Object[0]);
/*  340 */         par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */       } 
/*  342 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  344 */         var2.stackSize--;
/*  345 */         if (var2.stackSize <= 0)
/*      */         {
/*  347 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  350 */       return true;
/*      */     } 
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
/*  378 */     if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */       
/*  380 */       setCustomNameTag(var2.getDisplayName());
/*  381 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  383 */         var2.stackSize--;
/*  384 */         if (var2.stackSize <= 0)
/*      */         {
/*  386 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  389 */       return true;
/*      */     } 
/*      */     
/*  392 */     if (isTamed() && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */       
/*  394 */       if (!isSitting()) {
/*  395 */         setSitting(true);
/*  396 */         setActivity(1);
/*      */       } else {
/*  398 */         setSitting(false);
/*      */       } 
/*  400 */       return true;
/*      */     } 
/*      */     
/*  403 */     return super.interact(par1EntityPlayer);
/*      */   }
/*      */ 
/*      */   
/*      */   public void set_ok_to_grow() {
/*  408 */     this.ok_to_grow = 1;
/*  409 */     this.kill_count = 0;
/*  410 */     this.fed_count = 0;
/*  411 */     this.day_count = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/*  419 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.beef);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/*  427 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getLivingSound() {
/*  435 */     if (isSitting())
/*      */     {
/*  437 */       return null;
/*      */     }
/*  439 */     if (getAttacking() == 0) {
/*  440 */       return null;
/*      */     }
/*  442 */     return "orespawn:roar";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  450 */     return "orespawn:duck_hurt";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  458 */     return "orespawn:cryo_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  466 */     return 0.6F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  474 */     return 14;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  482 */     return Items.beef;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  490 */     int var3 = 0;
/*      */     
/*  492 */     var3 = this.worldObj.rand.nextInt(4);
/*  493 */     var3++;
/*  494 */     for (int var4 = 0; var4 < var3; var4++)
/*      */     {
/*  496 */       dropItem(Items.beef, 1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundPitch() {
/*  506 */     return (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F + 1.5F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canTriggerWalking() {
/*  514 */     return true;
/*      */   }
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
/*      */   protected void updateFallState(double par1, boolean par3) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean doesEntityNotTriggerPressurePlate() {
/*  532 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  540 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable var1) {
/*  546 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getAttackStrength(Entity par1Entity) {
/*  551 */     return 9.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  558 */     float var2 = getAttackStrength(par1Entity);
/*  559 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
/*  560 */     if (par1Entity instanceof EntityLivingBase) {
/*  561 */       EntityLivingBase el = (EntityLivingBase)par1Entity;
/*  562 */       if (el.getHealth() <= 0.0F) {
/*  563 */         this.kill_count++;
/*      */       }
/*      */     } 
/*  566 */     return var4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  574 */     boolean ret = false;
/*      */     
/*  576 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  577 */       return false;
/*      */     }
/*  579 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*  580 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*  581 */       setSitting(false);
/*  582 */       setActivity(2);
/*      */     } 
/*  584 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  592 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  602 */     super.onUpdate();
/*  603 */     if (getActivity() == 2) {
/*  604 */       this.noClip = true;
/*      */     } else {
/*  606 */       this.noClip = false;
/*      */     } 
/*      */     
/*  609 */     if (this.worldObj.rand.nextInt(10) == 1) {
/*  610 */       int i = this.worldObj.rand.nextInt(3);
/*  611 */       if (i == 0) this.head1dir = 2; 
/*  612 */       if (i == 1) this.head1dir = -2; 
/*  613 */       if (i == 2) this.head1dir = 0; 
/*      */     } 
/*  615 */     if (this.worldObj.rand.nextInt(10) == 1) {
/*  616 */       int i = this.worldObj.rand.nextInt(3);
/*  617 */       if (i == 0) this.head2dir = 2; 
/*  618 */       if (i == 1) this.head2dir = -2; 
/*  619 */       if (i == 2) this.head2dir = 0; 
/*      */     } 
/*  621 */     if (this.worldObj.rand.nextInt(10) == 1) {
/*  622 */       int i = this.worldObj.rand.nextInt(3);
/*  623 */       if (i == 0) this.head3dir = 2; 
/*  624 */       if (i == 1) this.head3dir = -2; 
/*  625 */       if (i == 2) this.head3dir = 0; 
/*      */     } 
/*  627 */     this.head1ext += this.head1dir;
/*  628 */     if (this.head1ext < 0) this.head1ext = 0; 
/*  629 */     if (this.head1ext > 60) this.head1ext = 60; 
/*  630 */     this.head2ext += this.head2dir;
/*  631 */     if (this.head2ext < 0) this.head2ext = 0; 
/*  632 */     if (this.head2ext > 60) this.head2ext = 60; 
/*  633 */     this.head3ext += this.head3dir;
/*  634 */     if (this.head3ext < 0) this.head3ext = 0; 
/*  635 */     if (this.head3ext > 60) this.head3ext = 60;
/*      */     
/*  637 */     if (this.worldObj.isRemote && getPower() > 400) {
/*  638 */       float f = 0.25F;
/*      */       
/*  640 */       if (this.worldObj.rand.nextInt(6) == 1) {
/*  641 */         for (int i = 0; i < 2; i++) {
/*  642 */           this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4D, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0D + this.motionX * 3.0D, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0D, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0D + this.motionZ * 3.0D);
/*      */         }
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
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  661 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  662 */     super.onLivingUpdate();
/*      */     
/*  664 */     if (isInWater()) {
/*  665 */       this.motionY += 0.07D;
/*      */     }
/*      */ 
/*      */     
/*  669 */     if (this.currentFlightTarget == null) {
/*  670 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     }
/*      */ 
/*      */     
/*  674 */     this.syncit++;
/*  675 */     if (this.syncit > 20) {
/*  676 */       this.syncit = 0;
/*  677 */       if (this.worldObj.isRemote) {
/*  678 */         getActivity();
/*      */       } else {
/*  680 */         int j = this.activity;
/*  681 */         setActivity(j);
/*      */       } 
/*      */     } 
/*      */     
/*  685 */     if (this.activity == 2) {
/*  686 */       this.motionY *= 0.6D;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITasks() {
/*  696 */     double xzoff = 1.5D;
/*  697 */     double yoff = 1.0D;
/*  698 */     EntityLiving newent = null;
/*      */     
/*  700 */     if (this.isDead)
/*      */       return; 
/*  702 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null);
/*      */     
/*  704 */     if (this.activity != 2) {
/*  705 */       super.updateAITasks();
/*      */     }
/*  707 */     this.ticker++;
/*  708 */     if (this.ticker % 10 == 0) {
/*  709 */       setPower(this.attack_level);
/*      */     }
/*      */     
/*  712 */     if (this.worldObj.rand.nextInt(200) == 1 && 
/*  713 */       getHealth() < mygetMaxHealth()) {
/*  714 */       heal(1.0F);
/*      */     }
/*      */     
/*  717 */     if (!isTamed()) {
/*  718 */       EntityPlayer p = this.worldObj.getClosestPlayerToEntity((Entity)this, 10.0D);
/*  719 */       if (p != null) {
/*  720 */         setTamed(true);
/*  721 */         func_152115_b(p.getUniqueID().toString());
/*  722 */         playTameEffect(true);
/*  723 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*  724 */         heal(mygetMaxHealth() - getHealth());
/*      */       } 
/*      */     } 
/*      */     
/*  728 */     this.attack_level++;
/*  729 */     if (getAttacking() != 0) {
/*  730 */       this.attack_level += 4;
/*      */     }
/*      */     
/*  733 */     if (getSpyroFire() == 0) this.attack_level = 0;
/*      */     
/*  735 */     if (this.attack_level > 500) {
/*  736 */       if (getAttacking() != 0) {
/*  737 */         int j = 3;
/*  738 */         for (int i = 0; i < j; i++) {
/*  739 */           this; Entity ppwr = spawnCreature(this.worldObj, "PurplePower", this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
/*      */ 
/*      */ 
/*      */           
/*  743 */           if (ppwr != null) {
/*  744 */             PurplePower p = (PurplePower)ppwr;
/*  745 */             p.motionX = this.motionX * 3.0D;
/*  746 */             p.motionZ = this.motionZ * 3.0D;
/*  747 */             p.setPurpleType(1 + this.worldObj.rand.nextInt(3));
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/*  752 */         if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
/*  753 */           for (int i = 0; i < 5; i++) {
/*  754 */             int n = this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5);
/*  755 */             int k = this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5);
/*  756 */             for (int j = -5; j < 5; j++) {
/*  757 */               Block bid = this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k);
/*  758 */               if (bid == Blocks.grass) {
/*  759 */                 if (this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  760 */                   int which = this.worldObj.rand.nextInt(8);
/*  761 */                   if (which == 0) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, (Block)Blocks.red_flower); 
/*  762 */                   if (which == 1) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, (Block)Blocks.yellow_flower); 
/*  763 */                   if (which == 2) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.MyFlowerBlueBlock); 
/*  764 */                   if (which == 3) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.MyFlowerPinkBlock); 
/*  765 */                   if (which == 4) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerRedBlock); 
/*  766 */                   if (which == 5) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerGreenBlock); 
/*  767 */                   if (which == 6) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerBlueBlock); 
/*  768 */                   if (which == 7) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerYellowBlock); 
/*      */                 } 
/*      */                 break;
/*      */               } 
/*  772 */               if (bid == Blocks.dirt && 
/*  773 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  774 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k, (Block)Blocks.grass);
/*      */                 
/*      */                 break;
/*      */               } 
/*  778 */               if (bid == Blocks.stone && 
/*  779 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  780 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, Blocks.dirt);
/*      */                 
/*      */                 break;
/*      */               } 
/*  784 */               if (bid == Blocks.sand && 
/*  785 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  786 */                 if (this.worldObj.rand.nextInt(2) == 0) {
/*  787 */                   this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, Blocks.cactus); break;
/*      */                 } 
/*  789 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k, Blocks.dirt);
/*      */                 
/*      */                 break;
/*      */               } 
/*      */               
/*  794 */               if (bid == Blocks.lava && 
/*  795 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  796 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k, Blocks.water);
/*      */                 
/*      */                 break;
/*      */               } 
/*  800 */               if (bid == Blocks.flowing_lava && 
/*  801 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  802 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k, (Block)Blocks.flowing_water);
/*      */                 
/*      */                 break;
/*      */               } 
/*  806 */               if (bid == Blocks.air && j > 0) {
/*      */                 break;
/*      */               }
/*      */             } 
/*      */           }  
/*  811 */         for (int m = 0; m < 2; m++) {
/*  812 */           int i = this.worldObj.rand.nextInt(4) - this.worldObj.rand.nextInt(4);
/*  813 */           int k = this.worldObj.rand.nextInt(4) - this.worldObj.rand.nextInt(4);
/*  814 */           int j = 1 + this.worldObj.rand.nextInt(4);
/*  815 */           Block bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k);
/*  816 */           if (bid == Blocks.air) {
/*  817 */             if (this.worldObj.rand.nextInt(2) == 0) {
/*  818 */               newent = (EntityLiving)spawnCreature(this.worldObj, "Butterfly", this.posX + i, this.posY + j, this.posZ + k);
/*      */             } else {
/*  820 */               newent = (EntityLiving)spawnCreature(this.worldObj, "Bird", this.posX + i, this.posY + j, this.posZ + k);
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*  825 */       this.attack_level = 1;
/*      */     } 
/*      */     
/*  828 */     if (!isSitting()) {
/*  829 */       if (this.activity == 0) {
/*  830 */         setActivity(1);
/*      */       }
/*      */       
/*  833 */       if (this.worldObj.rand.nextInt(100) == 1) {
/*  834 */         if (this.worldObj.rand.nextInt(20) == 1) {
/*  835 */           setActivity(2);
/*      */         } else {
/*  837 */           setActivity(1);
/*      */         } 
/*      */       }
/*      */       
/*  841 */       this.owner_flying = 0;
/*  842 */       if (isTamed() && getOwner() != null) {
/*  843 */         EntityPlayer e = (EntityPlayer)getOwner();
/*      */         
/*  845 */         if (e.capabilities.isFlying) {
/*  846 */           this.owner_flying = 1;
/*  847 */           setActivity(2);
/*      */         } 
/*      */       } 
/*      */       
/*  851 */       if (this.activity == 1 && isTamed() && getOwner() != null) {
/*  852 */         EntityLivingBase e = getOwner();
/*      */         
/*  854 */         if (getDistanceSqToEntity((Entity)e) > 256.0D)
/*      */         {
/*  856 */           setActivity(2);
/*      */         }
/*      */       } 
/*      */       
/*  860 */       do_movement();
/*      */     }
/*  862 */     else if (isTamed() && getOwner() != null) {
/*  863 */       EntityLivingBase e = getOwner();
/*      */       
/*  865 */       if (getDistanceSqToEntity((Entity)e) > 256.0D) {
/*      */         
/*  867 */         setSitting(false);
/*  868 */         setActivity(2);
/*      */       } 
/*      */     } 
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
/*  890 */     if (this.is_day == 0) {
/*  891 */       this.is_day = 1;
/*  892 */       if (!this.worldObj.isDaytime()) this.is_day = -1; 
/*      */     } else {
/*  894 */       if (this.is_day == -1 && 
/*  895 */         this.worldObj.isDaytime())
/*      */       {
/*  897 */         this.day_count++;
/*      */       }
/*      */       
/*  900 */       this.is_day = 1;
/*  901 */       if (!this.worldObj.isDaytime()) this.is_day = -1;
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   private void do_movement() {
/*  907 */     int xdir = 1;
/*  908 */     int zdir = 1;
/*      */     
/*  910 */     int keep_trying = 10;
/*      */ 
/*      */     
/*  913 */     int do_new = 0;
/*  914 */     double ox = 0.0D, oy = 0.0D, oz = 0.0D;
/*      */     
/*  916 */     int has_owner = 0;
/*  917 */     double rr = 0.0D;
/*  918 */     double rhdir = 0.0D;
/*  919 */     double rdd = 0.0D;
/*  920 */     double pi = 3.1415926545D;
/*  921 */     EntityLivingBase e = null;
/*      */ 
/*      */     
/*  924 */     if (this.currentFlightTarget == null) {
/*  925 */       do_new = 1;
/*  926 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  932 */     if (this.activity == 2 && this.worldObj.rand.nextInt(300) == 0) do_new = 1;
/*      */ 
/*      */     
/*  935 */     if (isTamed() && getOwner() != null) {
/*  936 */       e = getOwner();
/*  937 */       has_owner = 1;
/*  938 */       ox = e.posX;
/*  939 */       oy = e.posY + 1.0D;
/*  940 */       oz = e.posZ;
/*      */       
/*  942 */       if (getDistanceSqToEntity((Entity)e) > 100.0D) {
/*  943 */         do_new = 1;
/*      */       }
/*  945 */       if (this.owner_flying != 0 && 
/*  946 */         getDistanceSqToEntity((Entity)e) > 36.0D) {
/*  947 */         do_new = 1;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  953 */     if (this.worldObj.rand.nextInt(7) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*      */ 
/*      */ 
/*      */       
/*  957 */       e = findSomethingToAttack();
/*  958 */       if (e != null) {
/*      */         
/*  960 */         if (isTamed() && getHealth() / mygetMaxHealth() < 0.25F) {
/*  961 */           setActivity(2);
/*  962 */           setAttacking(0);
/*  963 */           do_new = 0;
/*  964 */           this.currentFlightTarget.set((int)(this.posX + this.posX - e.posX), (int)(this.posY + 1.0D), (int)(this.posZ + this.posZ - e.posZ));
/*      */         } else {
/*      */           
/*  967 */           setActivity(2);
/*  968 */           setAttacking(1);
/*  969 */           this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/*  970 */           do_new = 0;
/*  971 */           if (getDistanceSqToEntity((Entity)e) < ((3.0F + e.width / 2.0F) * (3.0F + e.width / 2.0F))) {
/*  972 */             attackEntityAsMob((Entity)e);
/*  973 */           } else if (getDistanceSqToEntity((Entity)e) > 25.0D && getDistanceSqToEntity((Entity)e) < 144.0D && !isInWater() && getSpyroFire() != 0 && (
/*  974 */             this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(4) == 1)) {
/*  975 */             int which = this.worldObj.rand.nextInt(3);
/*  976 */             if (which == 0) {
/*      */ 
/*      */               
/*  979 */               rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/*  980 */               rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */               
/*  982 */               rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/*  983 */               if (rdd > pi) rdd -= pi * 2.0D; 
/*  984 */               rdd = Math.abs(rdd);
/*      */               
/*  986 */               if (rdd < 0.5D) {
/*  987 */                 firecanon(e);
/*      */               }
/*  989 */             } else if (which == 1) {
/*      */ 
/*      */ 
/*      */               
/*  993 */               rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/*  994 */               rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */               
/*  996 */               rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/*  997 */               if (rdd > pi) rdd -= pi * 2.0D; 
/*  998 */               rdd = Math.abs(rdd);
/*      */               
/* 1000 */               if (rdd < 0.5D) {
/* 1001 */                 firecanonl(e);
/*      */               
/*      */               }
/*      */             }
/*      */             else {
/*      */               
/* 1007 */               rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/* 1008 */               rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */               
/* 1010 */               rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 1011 */               if (rdd > pi) rdd -= pi * 2.0D; 
/* 1012 */               rdd = Math.abs(rdd);
/*      */               
/* 1014 */               if (rdd < 0.5D) {
/* 1015 */                 firecanoni(e);
/*      */               }
/*      */             }
/*      */           
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/* 1023 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */     
/* 1027 */     if (this.activity == 1) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1032 */     if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/* 1033 */       do_new = 1;
/*      */     }
/*      */ 
/*      */     
/* 1037 */     if (do_new != 0) {
/*      */       
/* 1039 */       Block bid = Blocks.stone;
/* 1040 */       while (bid != Blocks.air && keep_trying != 0) {
/* 1041 */         int gox = (int)this.posX;
/* 1042 */         int goy = (int)this.posY;
/* 1043 */         int goz = (int)this.posZ;
/* 1044 */         if (has_owner == 1) {
/* 1045 */           gox = (int)ox;
/* 1046 */           goy = (int)oy;
/* 1047 */           goz = (int)oz;
/* 1048 */           if (this.owner_flying == 0) {
/* 1049 */             zdir = this.worldObj.rand.nextInt(4) + 6;
/* 1050 */             xdir = this.worldObj.rand.nextInt(4) + 6;
/*      */           } else {
/* 1052 */             zdir = this.worldObj.rand.nextInt(8);
/* 1053 */             xdir = this.worldObj.rand.nextInt(8);
/*      */           } 
/*      */         } else {
/* 1056 */           zdir = this.worldObj.rand.nextInt(5) + 6;
/* 1057 */           xdir = this.worldObj.rand.nextInt(5) + 6;
/*      */         } 
/* 1059 */         if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir; 
/* 1060 */         if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir; 
/* 1061 */         this.currentFlightTarget.set(gox + xdir, goy + this.worldObj.rand.nextInt(6 + this.owner_flying * 2) - 2, goz + zdir);
/* 1062 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1068 */         keep_trying--;
/*      */       } 
/*      */     } 
/*      */     
/* 1072 */     double speed_factor = 1.0D;
/* 1073 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 1074 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 1075 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 1076 */     if (this.owner_flying != 0) {
/* 1077 */       speed_factor = 1.75D;
/* 1078 */       if (isTamed() && getOwner() != null) {
/* 1079 */         e = getOwner();
/* 1080 */         if (getDistanceSqToEntity((Entity)e) > 49.0D) {
/* 1081 */           speed_factor = 3.5D;
/*      */         }
/*      */       } 
/*      */     } 
/* 1085 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.15D * speed_factor;
/* 1086 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.21D * speed_factor;
/* 1087 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.15D * speed_factor;
/* 1088 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 1089 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 1090 */     this.moveForward = (float)(0.75D * speed_factor);
/*      */     
/* 1092 */     this.rotationYaw += var8 / 3.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 1100 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*      */     
/* 1102 */     if (par1EntityLiving == null)
/*      */     {
/* 1104 */       return false;
/*      */     }
/* 1106 */     if (par1EntityLiving == this)
/*      */     {
/* 1108 */       return false;
/*      */     }
/* 1110 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/* 1112 */       return false;
/*      */     }
/* 1114 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/* 1117 */       return false;
/*      */     }
/* 1119 */     if (MyUtils.isRoyalty((Entity)par1EntityLiving))
/*      */     {
/* 1121 */       return false;
/*      */     }
/*      */     
/* 1124 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*      */     {
/* 1126 */       return true;
/*      */     }
/* 1128 */     if (par1EntityLiving instanceof Mothra)
/*      */     {
/* 1130 */       return true;
/*      */     }
/* 1132 */     if (par1EntityLiving instanceof Dragonfly)
/*      */     {
/* 1134 */       return true;
/*      */     }
/* 1136 */     if (par1EntityLiving instanceof EntityMosquito)
/*      */     {
/* 1138 */       return true;
/*      */     }
/*      */     
/* 1141 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/* 1146 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 1147 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 6.0D, 12.0D));
/* 1148 */     Collections.sort(var5, this.TargetSorter);
/* 1149 */     Iterator<?> var2 = var5.iterator();
/* 1150 */     Entity var3 = null;
/* 1151 */     EntityLivingBase var4 = null;
/*      */     
/* 1153 */     while (var2.hasNext()) {
/*      */       
/* 1155 */       var3 = (Entity)var2.next();
/* 1156 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1158 */       if (isSuitableTarget(var4, false) && canSeeTarget(var4.posX, var4.posY, var4.posZ))
/*      */       {
/* 1160 */         return var4;
/*      */       }
/*      */     } 
/* 1163 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private void firecanon(EntityLivingBase e) {
/* 1168 */     double yoff = 1.0D;
/* 1169 */     double xzoff = 3.0D;
/*      */ 
/*      */     
/* 1172 */     BetterFireball bf = null;
/*      */     
/* 1174 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1175 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */ 
/*      */     
/* 1178 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1179 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1180 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1181 */     bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx + r1, e.posY + (e.height / 2.0F) - this.posY + yoff + r2, e.posZ - cz + r3);
/* 1182 */     bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 1183 */     bf.setPosition(cx, this.posY + yoff, cz);
/* 1184 */     bf.setBig();
/* 1185 */     if (this.worldObj.rand.nextInt(2) == 1) bf.setSmall(); 
/* 1186 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1187 */     this.worldObj.spawnEntityInWorld((Entity)bf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void firecanonl(EntityLivingBase e) {
/* 1195 */     double yoff = 1.0D;
/* 1196 */     double xzoff = 3.0D;
/*      */ 
/*      */ 
/*      */     
/* 1200 */     double var3 = 0.0D;
/* 1201 */     double var5 = 0.0D;
/* 1202 */     double var7 = 0.0D;
/* 1203 */     float var9 = 0.0F;
/* 1204 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1205 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */     
/* 1207 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*      */     
/* 1209 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1210 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1211 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1212 */     ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
/* 1213 */     lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
/* 1214 */     var3 = e.posX - lb.posX;
/* 1215 */     var5 = e.posY + 0.25D - lb.posY;
/* 1216 */     var7 = e.posZ - lb.posZ;
/* 1217 */     var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1218 */     lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
/* 1219 */     lb.motionX *= 3.0D;
/* 1220 */     lb.motionY *= 3.0D;
/* 1221 */     lb.motionZ *= 3.0D;
/* 1222 */     this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void firecanoni(EntityLivingBase e) {
/* 1229 */     double yoff = 1.0D;
/* 1230 */     double xzoff = 3.0D;
/*      */ 
/*      */ 
/*      */     
/* 1234 */     double var3 = 0.0D;
/* 1235 */     double var5 = 0.0D;
/* 1236 */     double var7 = 0.0D;
/* 1237 */     float var9 = 0.0F;
/* 1238 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1239 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */     
/* 1241 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*      */     
/* 1243 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1244 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1245 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1246 */     IceBall lb = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
/* 1247 */     lb.setIceMaker(1);
/* 1248 */     lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
/* 1249 */     var3 = e.posX - lb.posX;
/* 1250 */     var5 = e.posY + 0.25D - lb.posY;
/* 1251 */     var7 = e.posZ - lb.posZ;
/* 1252 */     var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1253 */     lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
/* 1254 */     lb.motionX *= 3.0D;
/* 1255 */     lb.motionY *= 3.0D;
/* 1256 */     lb.motionZ *= 3.0D;
/* 1257 */     this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 1268 */     Entity var8 = null;
/*      */ 
/*      */     
/* 1271 */     var8 = EntityList.createEntityByName(par1, par0World);
/*      */     
/* 1273 */     if (var8 != null) {
/*      */ 
/*      */       
/* 1276 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/* 1279 */       par0World.spawnEntityInWorld(var8);
/*      */       
/* 1281 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*      */     
/* 1284 */     return var8;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ThePrincess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */