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
/*      */ public class ThePrince
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
/*      */ 
/*      */ 
/*      */   
/*      */   public ThePrince(World par1World) {
/*   79 */     super(par1World);
/*      */     
/*   81 */     setSize(0.75F, 1.25F);
/*   82 */     this.moveSpeed = 0.32F;
/*   83 */     this.fireResistance = 1000;
/*   84 */     this.isImmuneToFire = true;
/*   85 */     getNavigator().setAvoidsWater(true);
/*   86 */     setSitting(false);
/*   87 */     this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*   88 */     this.tasks.addTask(2, new MyEntityAIFollowOwner(this, 1.15F, 12.0F, 2.0F));
/*   89 */     this.tasks.addTask(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.beef, false));
/*   90 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 6.0F));
/*   91 */     this.tasks.addTask(5, new MyEntityAIWander((EntityCreature)this, 0.75F));
/*   92 */     this.tasks.addTask(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*   93 */     this.tasks.addTask(7, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*   94 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*   95 */     this.experienceValue = 50;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  100 */     super.applyEntityAttributes();
/*  101 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  102 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  103 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  104 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  109 */     super.entityInit();
/*  110 */     this.activity = 1;
/*  111 */     this.dataWatcher.addObject(22, Integer.valueOf(0));
/*  112 */     this.dataWatcher.addObject(21, Integer.valueOf(this.activity));
/*  113 */     this.dataWatcher.addObject(20, Integer.valueOf(1));
/*  114 */     setSitting(false);
/*  115 */     setTamed(false);
/*  116 */     this.noClip = false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/*  124 */     super.writeEntityToNBT(par1NBTTagCompound);
/*  125 */     par1NBTTagCompound.setInteger("SpyroActivity", this.dataWatcher.getWatchableObjectInt(21));
/*  126 */     par1NBTTagCompound.setInteger("SpyroFire", this.dataWatcher.getWatchableObjectInt(20));
/*  127 */     par1NBTTagCompound.setInteger("SpyroGrow", this.ok_to_grow);
/*  128 */     par1NBTTagCompound.setInteger("SpyroKill", this.kill_count);
/*  129 */     par1NBTTagCompound.setInteger("SpyroFed", this.fed_count);
/*  130 */     par1NBTTagCompound.setInteger("SpyroDay", this.day_count);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/*  138 */     super.readEntityFromNBT(par1NBTTagCompound);
/*  139 */     this.activity = par1NBTTagCompound.getInteger("SpyroActivity");
/*  140 */     this.dataWatcher.updateObject(21, Integer.valueOf(this.activity));
/*  141 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1NBTTagCompound.getInteger("SpyroFire")));
/*  142 */     this.ok_to_grow = par1NBTTagCompound.getInteger("SpyroGrow");
/*  143 */     this.kill_count = par1NBTTagCompound.getInteger("SpyroKill");
/*  144 */     this.fed_count = par1NBTTagCompound.getInteger("SpyroFed");
/*  145 */     this.day_count = par1NBTTagCompound.getInteger("SpyroDay");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getActivity() {
/*  154 */     int i = this.dataWatcher.getWatchableObjectInt(21);
/*  155 */     this.activity = i;
/*  156 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivity(int par1) {
/*  162 */     this.activity = par1;
/*  163 */     this.dataWatcher.updateObject(21, Integer.valueOf(0));
/*  164 */     this.dataWatcher.updateObject(21, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSpyroFire() {
/*  170 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSpyroFire(int par1) {
/*  176 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/*  182 */     return this.dataWatcher.getWatchableObjectInt(22);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/*  188 */     this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */   
/*      */   public int getHead1Ext() {
/*  193 */     return this.head1ext;
/*      */   }
/*      */   
/*      */   public int getHead2Ext() {
/*  197 */     return this.head2ext;
/*      */   }
/*      */   
/*      */   public int getHead3Ext() {
/*  201 */     return this.head3ext;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/*  211 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBreatheUnderwater() {
/*  217 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  222 */     return 500;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  231 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */ 
/*      */     
/*  234 */     if (var2 != null)
/*      */     {
/*  236 */       if (var2.stackSize <= 0) {
/*      */         
/*  238 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  239 */         var2 = null;
/*      */       } 
/*      */     }
/*      */     
/*  243 */     if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*  244 */       if (!this.worldObj.isRemote) {
/*      */         
/*  246 */         setTamed(true);
/*  247 */         func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*  248 */         playTameEffect(true);
/*  249 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*  250 */         heal(mygetMaxHealth() - getHealth());
/*  251 */         this.ok_to_grow = 1;
/*  252 */         this.kill_count = 1000;
/*  253 */         this.fed_count = 1000;
/*  254 */         this.day_count = 1000;
/*      */       } 
/*      */ 
/*      */       
/*  258 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*  259 */         var2.stackSize--;
/*  260 */         if (var2.stackSize <= 0) {
/*  261 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  264 */       return true;
/*      */     } 
/*      */     
/*  267 */     if (isTamed() && var2 != null && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && var2.getItem() instanceof ItemFood) {
/*      */ 
/*      */ 
/*      */       
/*  271 */       if (!this.worldObj.isRemote) {
/*      */         
/*  273 */         ItemFood var3 = (ItemFood)var2.getItem();
/*      */         
/*  275 */         if (mygetMaxHealth() > getHealth())
/*      */         {
/*  277 */           heal((var3.getHealAmount(var2) * 10));
/*      */         }
/*      */         
/*  280 */         playTameEffect(true);
/*  281 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*  282 */         this.fed_count++;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  287 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  289 */         var2.stackSize--;
/*  290 */         if (var2.stackSize <= 0)
/*      */         {
/*  292 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  295 */       return true;
/*  296 */     }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.ice) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  299 */       if (!this.worldObj.isRemote) {
/*      */         
/*  301 */         playTameEffect(true);
/*  302 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*  303 */         setSpyroFire(0);
/*  304 */         String healthMessage = new String();
/*  305 */         healthMessage = String.format("Prince fireballs extinguished.", new Object[0]);
/*  306 */         par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */       } 
/*  308 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  310 */         var2.stackSize--;
/*  311 */         if (var2.stackSize <= 0)
/*      */         {
/*  313 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  316 */       return true;
/*  317 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.flint_and_steel && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  320 */       if (!this.worldObj.isRemote) {
/*      */         
/*  322 */         playTameEffect(true);
/*  323 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*  324 */         setSpyroFire(1);
/*  325 */         String healthMessage = new String();
/*  326 */         healthMessage = String.format("Prince fireballs lit!", new Object[0]);
/*  327 */         par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */       } 
/*  329 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  331 */         var2.stackSize--;
/*  332 */         if (var2.stackSize <= 0)
/*      */         {
/*  334 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  337 */       return true;
/*      */     } 
/*      */     
/*  340 */     if (var2 != null && var2.getItem() == Items.diamond && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer) && !this.worldObj.isRemote && this.ok_to_grow != 0) {
/*      */ 
/*      */ 
/*      */       
/*  344 */       Entity ent = null;
/*  345 */       ThePrinceTeen d = null;
/*  346 */       ent = spawnCreature(this.worldObj, "The Young Prince", this.posX, this.posY, this.posZ);
/*  347 */       if (ent != null) {
/*  348 */         d = (ThePrinceTeen)ent;
/*  349 */         if (isTamed()) {
/*  350 */           d.setTamed(true);
/*  351 */           d.func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*      */         } 
/*  353 */         setDead();
/*      */       } 
/*  355 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  357 */         var2.stackSize--;
/*  358 */         if (var2.stackSize <= 0)
/*      */         {
/*  360 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  363 */       return true;
/*  364 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */       
/*  366 */       setCustomNameTag(var2.getDisplayName());
/*  367 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  369 */         var2.stackSize--;
/*  370 */         if (var2.stackSize <= 0)
/*      */         {
/*  372 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  375 */       return true;
/*      */     } 
/*      */     
/*  378 */     if (isTamed() && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */       
/*  380 */       if (!isSitting()) {
/*  381 */         setSitting(true);
/*  382 */         setActivity(1);
/*      */       } else {
/*  384 */         setSitting(false);
/*      */       } 
/*  386 */       return true;
/*      */     } 
/*      */     
/*  389 */     return super.interact(par1EntityPlayer);
/*      */   }
/*      */ 
/*      */   
/*      */   public void set_ok_to_grow() {
/*  394 */     this.ok_to_grow = 1;
/*  395 */     this.kill_count = 0;
/*  396 */     this.fed_count = 0;
/*  397 */     this.day_count = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/*  405 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.beef);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/*  413 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getLivingSound() {
/*  421 */     if (isSitting())
/*      */     {
/*  423 */       return null;
/*      */     }
/*  425 */     if (getAttacking() == 0) {
/*  426 */       return null;
/*      */     }
/*  428 */     return "orespawn:roar";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  436 */     return "orespawn:duck_hurt";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  444 */     return "orespawn:cryo_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  452 */     return 0.6F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  460 */     return 16;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  468 */     return Items.beef;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  476 */     int var3 = 0;
/*      */     
/*  478 */     var3 = this.worldObj.rand.nextInt(4);
/*  479 */     var3++;
/*  480 */     for (int var4 = 0; var4 < var3; var4++)
/*      */     {
/*  482 */       dropItem(Items.beef, 1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundPitch() {
/*  492 */     return (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F + 1.3F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canTriggerWalking() {
/*  500 */     return true;
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
/*  518 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  526 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable var1) {
/*  532 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getAttackStrength(Entity par1Entity) {
/*  537 */     return 10.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  544 */     float var2 = getAttackStrength(par1Entity);
/*  545 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
/*  546 */     if (par1Entity instanceof EntityLivingBase) {
/*  547 */       EntityLivingBase el = (EntityLivingBase)par1Entity;
/*  548 */       if (el.getHealth() <= 0.0F) {
/*  549 */         this.kill_count++;
/*      */       }
/*      */     } 
/*  552 */     return var4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  560 */     boolean ret = false;
/*      */     
/*  562 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  563 */       return false;
/*      */     }
/*  565 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*  566 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*  567 */       setSitting(false);
/*  568 */       setActivity(2);
/*      */     } 
/*  570 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  578 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  588 */     super.onUpdate();
/*  589 */     if (getActivity() == 2) {
/*  590 */       this.noClip = true;
/*      */     } else {
/*  592 */       this.noClip = false;
/*      */     } 
/*      */     
/*  595 */     if (this.worldObj.rand.nextInt(10) == 1) {
/*  596 */       int i = this.worldObj.rand.nextInt(3);
/*  597 */       if (i == 0) this.head1dir = 2; 
/*  598 */       if (i == 1) this.head1dir = -2; 
/*  599 */       if (i == 2) this.head1dir = 0; 
/*      */     } 
/*  601 */     if (this.worldObj.rand.nextInt(10) == 1) {
/*  602 */       int i = this.worldObj.rand.nextInt(3);
/*  603 */       if (i == 0) this.head2dir = 2; 
/*  604 */       if (i == 1) this.head2dir = -2; 
/*  605 */       if (i == 2) this.head2dir = 0; 
/*      */     } 
/*  607 */     if (this.worldObj.rand.nextInt(10) == 1) {
/*  608 */       int i = this.worldObj.rand.nextInt(3);
/*  609 */       if (i == 0) this.head3dir = 2; 
/*  610 */       if (i == 1) this.head3dir = -2; 
/*  611 */       if (i == 2) this.head3dir = 0; 
/*      */     } 
/*  613 */     this.head1ext += this.head1dir;
/*  614 */     if (this.head1ext < 0) this.head1ext = 0; 
/*  615 */     if (this.head1ext > 60) this.head1ext = 60; 
/*  616 */     this.head2ext += this.head2dir;
/*  617 */     if (this.head2ext < 0) this.head2ext = 0; 
/*  618 */     if (this.head2ext > 60) this.head2ext = 60; 
/*  619 */     this.head3ext += this.head3dir;
/*  620 */     if (this.head3ext < 0) this.head3ext = 0; 
/*  621 */     if (this.head3ext > 60) this.head3ext = 60;
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  631 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  632 */     super.onLivingUpdate();
/*      */     
/*  634 */     if (isInWater()) {
/*  635 */       this.motionY += 0.07D;
/*      */     }
/*      */ 
/*      */     
/*  639 */     if (this.currentFlightTarget == null) {
/*  640 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     }
/*      */ 
/*      */     
/*  644 */     this.syncit++;
/*  645 */     if (this.syncit > 20) {
/*  646 */       this.syncit = 0;
/*  647 */       if (this.worldObj.isRemote) {
/*  648 */         getActivity();
/*      */       } else {
/*  650 */         int j = this.activity;
/*  651 */         setActivity(j);
/*      */       } 
/*      */     } 
/*      */     
/*  655 */     if (this.activity == 2) {
/*  656 */       this.motionY *= 0.6D;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITasks() {
/*  666 */     if (this.isDead)
/*      */       return; 
/*  668 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null);
/*      */     
/*  670 */     if (this.activity != 2) {
/*  671 */       super.updateAITasks();
/*      */     }
/*      */ 
/*      */     
/*  675 */     if (this.worldObj.rand.nextInt(200) == 1 && 
/*  676 */       getHealth() < mygetMaxHealth()) {
/*  677 */       heal(1.0F);
/*      */     }
/*      */     
/*  680 */     if (!isTamed()) {
/*  681 */       EntityPlayer p = this.worldObj.getClosestPlayerToEntity((Entity)this, 10.0D);
/*  682 */       if (p != null) {
/*  683 */         setTamed(true);
/*  684 */         func_152115_b(p.getUniqueID().toString());
/*  685 */         playTameEffect(true);
/*  686 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*  687 */         heal(mygetMaxHealth() - getHealth());
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  692 */     if (!isSitting()) {
/*  693 */       if (this.activity == 0) {
/*  694 */         setActivity(1);
/*      */       }
/*      */       
/*  697 */       if (this.worldObj.rand.nextInt(100) == 1) {
/*  698 */         if (this.worldObj.rand.nextInt(20) == 1) {
/*  699 */           setActivity(2);
/*      */         } else {
/*  701 */           setActivity(1);
/*      */         } 
/*      */       }
/*      */       
/*  705 */       this.owner_flying = 0;
/*  706 */       if (isTamed() && getOwner() != null) {
/*  707 */         EntityPlayer e = (EntityPlayer)getOwner();
/*      */         
/*  709 */         if (e.capabilities.isFlying) {
/*  710 */           this.owner_flying = 1;
/*  711 */           setActivity(2);
/*      */         } 
/*      */       } 
/*      */       
/*  715 */       if (this.activity == 1 && isTamed() && getOwner() != null) {
/*  716 */         EntityLivingBase e = getOwner();
/*      */         
/*  718 */         if (getDistanceSqToEntity((Entity)e) > 256.0D)
/*      */         {
/*  720 */           setActivity(2);
/*      */         }
/*      */       } 
/*      */       
/*  724 */       do_movement();
/*      */     }
/*  726 */     else if (isTamed() && getOwner() != null) {
/*  727 */       EntityLivingBase e = getOwner();
/*      */       
/*  729 */       if (getDistanceSqToEntity((Entity)e) > 256.0D) {
/*      */         
/*  731 */         setSitting(false);
/*  732 */         setActivity(2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  738 */     if (this.kill_count > 25 && this.fed_count > 10 && this.day_count > 10) {
/*  739 */       Entity ent = null;
/*  740 */       ThePrinceTeen d = null;
/*  741 */       ent = spawnCreature(this.worldObj, "The Young Prince", this.posX, this.posY, this.posZ);
/*  742 */       if (ent != null) {
/*  743 */         d = (ThePrinceTeen)ent;
/*  744 */         if (isTamed()) {
/*  745 */           d.setTamed(true);
/*      */           
/*  747 */           d.func_152115_b(func_152113_b());
/*      */         } 
/*  749 */         setDead();
/*      */       } 
/*      */     } 
/*      */     
/*  753 */     if (this.is_day == 0) {
/*  754 */       this.is_day = 1;
/*  755 */       if (!this.worldObj.isDaytime()) this.is_day = -1; 
/*      */     } else {
/*  757 */       if (this.is_day == -1 && 
/*  758 */         this.worldObj.isDaytime())
/*      */       {
/*  760 */         this.day_count++;
/*      */       }
/*      */       
/*  763 */       this.is_day = 1;
/*  764 */       if (!this.worldObj.isDaytime()) this.is_day = -1;
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   private void do_movement() {
/*  770 */     int xdir = 1;
/*  771 */     int zdir = 1;
/*      */     
/*  773 */     int keep_trying = 10;
/*      */ 
/*      */     
/*  776 */     int do_new = 0;
/*  777 */     double ox = 0.0D, oy = 0.0D, oz = 0.0D;
/*      */     
/*  779 */     int has_owner = 0;
/*  780 */     double rr = 0.0D;
/*  781 */     double rhdir = 0.0D;
/*  782 */     double rdd = 0.0D;
/*  783 */     double pi = 3.1415926545D;
/*  784 */     EntityLivingBase e = null;
/*      */ 
/*      */     
/*  787 */     if (this.currentFlightTarget == null) {
/*  788 */       do_new = 1;
/*  789 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  795 */     if (this.activity == 2 && this.worldObj.rand.nextInt(300) == 0) do_new = 1;
/*      */ 
/*      */     
/*  798 */     if (isTamed() && getOwner() != null) {
/*  799 */       e = getOwner();
/*  800 */       has_owner = 1;
/*  801 */       ox = e.posX;
/*  802 */       oy = e.posY + 1.0D;
/*  803 */       oz = e.posZ;
/*      */       
/*  805 */       if (getDistanceSqToEntity((Entity)e) > 100.0D) {
/*  806 */         do_new = 1;
/*      */       }
/*  808 */       if (this.owner_flying != 0 && 
/*  809 */         getDistanceSqToEntity((Entity)e) > 36.0D) {
/*  810 */         do_new = 1;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  816 */     if (this.worldObj.rand.nextInt(7) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*      */ 
/*      */ 
/*      */       
/*  820 */       e = findSomethingToAttack();
/*  821 */       if (e != null) {
/*      */         
/*  823 */         if (isTamed() && getHealth() / mygetMaxHealth() < 0.25F) {
/*  824 */           setActivity(2);
/*  825 */           setAttacking(0);
/*  826 */           do_new = 0;
/*  827 */           this.currentFlightTarget.set((int)(this.posX + this.posX - e.posX), (int)(this.posY + 1.0D), (int)(this.posZ + this.posZ - e.posZ));
/*      */         } else {
/*      */           
/*  830 */           setActivity(2);
/*  831 */           setAttacking(1);
/*  832 */           this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/*  833 */           do_new = 0;
/*  834 */           if (getDistanceSqToEntity((Entity)e) < ((3.0F + e.width / 2.0F) * (3.0F + e.width / 2.0F))) {
/*  835 */             attackEntityAsMob((Entity)e);
/*  836 */           } else if (getDistanceSqToEntity((Entity)e) > 25.0D && getDistanceSqToEntity((Entity)e) < 144.0D && !isInWater() && getSpyroFire() != 0 && (
/*  837 */             this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(4) == 1)) {
/*  838 */             int which = this.worldObj.rand.nextInt(3);
/*  839 */             if (which == 0) {
/*      */ 
/*      */               
/*  842 */               rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/*  843 */               rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */               
/*  845 */               rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/*  846 */               if (rdd > pi) rdd -= pi * 2.0D; 
/*  847 */               rdd = Math.abs(rdd);
/*      */               
/*  849 */               if (rdd < 0.5D) {
/*  850 */                 firecanon(e);
/*      */               }
/*  852 */             } else if (which == 1) {
/*      */ 
/*      */ 
/*      */               
/*  856 */               rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/*  857 */               rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */               
/*  859 */               rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/*  860 */               if (rdd > pi) rdd -= pi * 2.0D; 
/*  861 */               rdd = Math.abs(rdd);
/*      */               
/*  863 */               if (rdd < 0.5D) {
/*  864 */                 firecanonl(e);
/*      */               
/*      */               }
/*      */             }
/*      */             else {
/*      */               
/*  870 */               rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/*  871 */               rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */               
/*  873 */               rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/*  874 */               if (rdd > pi) rdd -= pi * 2.0D; 
/*  875 */               rdd = Math.abs(rdd);
/*      */               
/*  877 */               if (rdd < 0.5D) {
/*  878 */                 firecanoni(e);
/*      */               }
/*      */             }
/*      */           
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/*  886 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */     
/*  890 */     if (this.activity == 1) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  895 */     if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*  896 */       do_new = 1;
/*      */     }
/*      */ 
/*      */     
/*  900 */     if (do_new != 0) {
/*      */       
/*  902 */       Block bid = Blocks.stone;
/*  903 */       while (bid != Blocks.air && keep_trying != 0) {
/*  904 */         int gox = (int)this.posX;
/*  905 */         int goy = (int)this.posY;
/*  906 */         int goz = (int)this.posZ;
/*  907 */         if (has_owner == 1) {
/*  908 */           gox = (int)ox;
/*  909 */           goy = (int)oy;
/*  910 */           goz = (int)oz;
/*  911 */           if (this.owner_flying == 0) {
/*  912 */             zdir = this.worldObj.rand.nextInt(4) + 6;
/*  913 */             xdir = this.worldObj.rand.nextInt(4) + 6;
/*      */           } else {
/*  915 */             zdir = this.worldObj.rand.nextInt(8);
/*  916 */             xdir = this.worldObj.rand.nextInt(8);
/*      */           } 
/*      */         } else {
/*  919 */           zdir = this.worldObj.rand.nextInt(5) + 6;
/*  920 */           xdir = this.worldObj.rand.nextInt(5) + 6;
/*      */         } 
/*  922 */         if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir; 
/*  923 */         if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir; 
/*  924 */         this.currentFlightTarget.set(gox + xdir, goy + this.worldObj.rand.nextInt(6 + this.owner_flying * 2) - 2, goz + zdir);
/*  925 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  931 */         keep_trying--;
/*      */       } 
/*      */     } 
/*      */     
/*  935 */     double speed_factor = 1.0D;
/*  936 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/*  937 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/*  938 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/*  939 */     if (this.owner_flying != 0) {
/*  940 */       speed_factor = 1.75D;
/*  941 */       if (isTamed() && getOwner() != null) {
/*  942 */         e = getOwner();
/*  943 */         if (getDistanceSqToEntity((Entity)e) > 49.0D) {
/*  944 */           speed_factor = 3.5D;
/*      */         }
/*      */       } 
/*      */     } 
/*  948 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.15D * speed_factor;
/*  949 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.21D * speed_factor;
/*  950 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.15D * speed_factor;
/*  951 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/*  952 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/*  953 */     this.moveForward = (float)(0.75D * speed_factor);
/*      */     
/*  955 */     this.rotationYaw += var8 / 3.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  963 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*      */     
/*  965 */     if (par1EntityLiving == null)
/*      */     {
/*  967 */       return false;
/*      */     }
/*  969 */     if (par1EntityLiving == this)
/*      */     {
/*  971 */       return false;
/*      */     }
/*  973 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*  975 */       return false;
/*      */     }
/*  977 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/*  980 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  984 */     if (MyUtils.isRoyalty((Entity)par1EntityLiving))
/*      */     {
/*  986 */       return false;
/*      */     }
/*      */     
/*  989 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*      */     {
/*  991 */       return true;
/*      */     }
/*  993 */     if (par1EntityLiving instanceof Mothra)
/*      */     {
/*  995 */       return true;
/*      */     }
/*  997 */     if (par1EntityLiving instanceof EntityButterfly)
/*      */     {
/*  999 */       return true;
/*      */     }
/* 1001 */     if (par1EntityLiving instanceof Cockateil)
/*      */     {
/* 1003 */       return true;
/*      */     }
/* 1005 */     if (par1EntityLiving instanceof Dragonfly)
/*      */     {
/* 1007 */       return true;
/*      */     }
/* 1009 */     if (par1EntityLiving instanceof EntityMosquito)
/*      */     {
/* 1011 */       return true;
/*      */     }
/*      */     
/* 1014 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/* 1019 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 1020 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 6.0D, 12.0D));
/* 1021 */     Collections.sort(var5, this.TargetSorter);
/* 1022 */     Iterator<?> var2 = var5.iterator();
/* 1023 */     Entity var3 = null;
/* 1024 */     EntityLivingBase var4 = null;
/*      */     
/* 1026 */     while (var2.hasNext()) {
/*      */       
/* 1028 */       var3 = (Entity)var2.next();
/* 1029 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1031 */       if (isSuitableTarget(var4, false) && canSeeTarget(var4.posX, var4.posY, var4.posZ))
/*      */       {
/* 1033 */         return var4;
/*      */       }
/*      */     } 
/* 1036 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private void firecanon(EntityLivingBase e) {
/* 1041 */     double yoff = 1.0D;
/* 1042 */     double xzoff = 3.0D;
/*      */ 
/*      */     
/* 1045 */     BetterFireball bf = null;
/*      */     
/* 1047 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1048 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */ 
/*      */     
/* 1051 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1052 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1053 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1054 */     bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx + r1, e.posY + (e.height / 2.0F) - this.posY + yoff + r2, e.posZ - cz + r3);
/* 1055 */     bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 1056 */     bf.setPosition(cx, this.posY + yoff, cz);
/* 1057 */     bf.setBig();
/* 1058 */     if (this.worldObj.rand.nextInt(2) == 1) bf.setSmall(); 
/* 1059 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1060 */     this.worldObj.spawnEntityInWorld((Entity)bf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void firecanonl(EntityLivingBase e) {
/* 1068 */     double yoff = 1.0D;
/* 1069 */     double xzoff = 3.0D;
/*      */ 
/*      */ 
/*      */     
/* 1073 */     double var3 = 0.0D;
/* 1074 */     double var5 = 0.0D;
/* 1075 */     double var7 = 0.0D;
/* 1076 */     float var9 = 0.0F;
/* 1077 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1078 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */     
/* 1080 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*      */     
/* 1082 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1083 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1084 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1085 */     ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
/* 1086 */     lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
/* 1087 */     var3 = e.posX - lb.posX;
/* 1088 */     var5 = e.posY + 0.25D - lb.posY;
/* 1089 */     var7 = e.posZ - lb.posZ;
/* 1090 */     var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1091 */     lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
/* 1092 */     lb.motionX *= 3.0D;
/* 1093 */     lb.motionY *= 3.0D;
/* 1094 */     lb.motionZ *= 3.0D;
/* 1095 */     this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void firecanoni(EntityLivingBase e) {
/* 1102 */     double yoff = 1.0D;
/* 1103 */     double xzoff = 3.0D;
/*      */ 
/*      */ 
/*      */     
/* 1107 */     double var3 = 0.0D;
/* 1108 */     double var5 = 0.0D;
/* 1109 */     double var7 = 0.0D;
/* 1110 */     float var9 = 0.0F;
/* 1111 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1112 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */     
/* 1114 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*      */     
/* 1116 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1117 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1118 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1119 */     IceBall lb = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
/* 1120 */     lb.setIceMaker(1);
/* 1121 */     lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
/* 1122 */     var3 = e.posX - lb.posX;
/* 1123 */     var5 = e.posY + 0.25D - lb.posY;
/* 1124 */     var7 = e.posZ - lb.posZ;
/* 1125 */     var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1126 */     lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
/* 1127 */     lb.motionX *= 3.0D;
/* 1128 */     lb.motionY *= 3.0D;
/* 1129 */     lb.motionZ *= 3.0D;
/* 1130 */     this.worldObj.spawnEntityInWorld((Entity)lb);
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
/* 1141 */     Entity var8 = null;
/*      */ 
/*      */     
/* 1144 */     var8 = EntityList.createEntityByName(par1, par0World);
/*      */     
/* 1146 */     if (var8 != null) {
/*      */ 
/*      */       
/* 1149 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/* 1152 */       par0World.spawnEntityInWorld(var8);
/*      */       
/* 1154 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*      */     
/* 1157 */     return var8;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ThePrince.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */