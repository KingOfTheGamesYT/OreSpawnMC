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
/*      */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*      */ import net.minecraft.entity.ai.EntityAIPanic;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.ai.EntityAITempt;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.monster.EntityMob;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.projectile.EntitySmallFireball;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
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
/*      */ public class Spyro
/*      */   extends EntityTameable
/*      */ {
/*      */   private ChunkCoordinates currentFlightTarget;
/*   60 */   private GenericTargetSorter TargetSorter = null;
/*   61 */   public int activity = 1;
/*   62 */   private int owner_flying = 0;
/*      */   
/*      */   private boolean target_in_sight = false;
/*   65 */   private float moveSpeed = 0.3F;
/*      */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*      */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*      */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*   69 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D); } public Spyro(World par1World) { super(par1World);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  135 */     this.closest = 99999;
/*  136 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.5F, 0.5F); this.moveSpeed = 0.3F; this.fireResistance = 1000; this.isImmuneToFire = true; getNavigator().setAvoidsWater(true); setSitting(false); this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 0.30000001192092896D, 0.4000000059604645D)); this.tasks.addTask(3, new MyEntityAIFollowOwner(this, 1.15F, 12.0F, 2.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.beef, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, new MyEntityAIWander((EntityCreature)this, 0.75F)); this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); this.TargetSorter = new GenericTargetSorter((Entity)this); this.experienceValue = 35; }
/*      */   protected void entityInit() { super.entityInit(); this.activity = 1; this.dataWatcher.addObject(21, Integer.valueOf(this.activity)); this.dataWatcher.addObject(20, Integer.valueOf(1));
/*      */     setSitting(false);
/*  139 */     setTamed(false); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*      */ 
/*      */     
/*      */     int i;
/*      */     
/*  144 */     for (i = -dy; i <= dy; i++) {
/*  145 */       for (int j = -dz; j <= dz; j++) {
/*  146 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/*  147 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  148 */           int d = dx * dx + j * j + i * i;
/*  149 */           if (d < this.closest) {
/*  150 */             this.closest = d;
/*  151 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/*  152 */             found++;
/*      */           } 
/*      */         } 
/*  155 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/*  156 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  157 */           int d = dx * dx + j * j + i * i;
/*  158 */           if (d < this.closest) {
/*  159 */             this.closest = d;
/*  160 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/*  161 */             found++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  167 */     for (i = -dx; i <= dx; i++) {
/*  168 */       for (int j = -dz; j <= dz; j++) {
/*  169 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/*  170 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  171 */           int d = dy * dy + j * j + i * i;
/*  172 */           if (d < this.closest) {
/*  173 */             this.closest = d;
/*  174 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/*  175 */             found++;
/*      */           } 
/*      */         } 
/*  178 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/*  179 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  180 */           int d = dy * dy + j * j + i * i;
/*  181 */           if (d < this.closest) {
/*  182 */             this.closest = d;
/*  183 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/*  184 */             found++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  190 */     for (i = -dx; i <= dx; i++) {
/*  191 */       for (int j = -dy; j <= dy; j++) {
/*  192 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/*  193 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  194 */           int d = dz * dz + j * j + i * i;
/*  195 */           if (d < this.closest) {
/*  196 */             this.closest = d;
/*  197 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/*  198 */             found++;
/*      */           } 
/*      */         } 
/*  201 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/*  202 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  203 */           int d = dz * dz + j * j + i * i;
/*  204 */           if (d < this.closest) {
/*  205 */             this.closest = d;
/*  206 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/*  207 */             found++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  213 */     if (found != 0) return true; 
/*  214 */     return false; } public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) { super.writeEntityToNBT(par1NBTTagCompound);
/*      */     par1NBTTagCompound.setInteger("SpyroActivity", this.dataWatcher.getWatchableObjectInt(21));
/*      */     par1NBTTagCompound.setInteger("SpyroFire", this.dataWatcher.getWatchableObjectInt(20)); }
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) { super.readEntityFromNBT(par1NBTTagCompound);
/*      */     this.activity = par1NBTTagCompound.getInteger("SpyroActivity");
/*      */     this.dataWatcher.updateObject(21, Integer.valueOf(this.activity));
/*      */     this.dataWatcher.updateObject(20, Integer.valueOf(par1NBTTagCompound.getInteger("SpyroFire"))); }
/*  221 */   public int getActivity() { int i = this.dataWatcher.getWatchableObjectInt(21);
/*  222 */     return i; }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivity(int par1) {
/*  228 */     this.activity = par1;
/*  229 */     this.dataWatcher.updateObject(21, Integer.valueOf(this.activity));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSpyroFire() {
/*  235 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSpyroFire(int par1) {
/*  241 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/*  250 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBreatheUnderwater() {
/*  256 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  261 */     return 200;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSpyroHealth() {
/*  268 */     return (int)getHealth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  276 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */ 
/*      */     
/*  279 */     if (var2 != null)
/*      */     {
/*  281 */       if (var2.stackSize <= 0) {
/*      */         
/*  283 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  284 */         var2 = null;
/*      */       } 
/*      */     }
/*      */     
/*  288 */     if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */       
/*  290 */       if (!isTamed()) {
/*      */         
/*  292 */         if (!this.worldObj.isRemote)
/*      */         {
/*  294 */           if (this.worldObj.rand.nextInt(2) == 1) {
/*  295 */             setTamed(true);
/*  296 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*  297 */             playTameEffect(true);
/*  298 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/*  299 */             heal(mygetMaxHealth() - getHealth());
/*      */           } else {
/*      */             
/*  302 */             playTameEffect(false);
/*  303 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */           }
/*      */         
/*      */         }
/*      */       }
/*  308 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */         
/*  310 */         if (this.worldObj.isRemote) {
/*  311 */           playTameEffect(true);
/*  312 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/*  315 */         if (mygetMaxHealth() > getHealth()) {
/*  316 */           heal(mygetMaxHealth() - getHealth());
/*      */         }
/*      */       } 
/*      */ 
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
/*  330 */     }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  333 */       if (!this.worldObj.isRemote) {
/*      */         
/*  335 */         setTamed(false);
/*  336 */         setHealth(mygetMaxHealth());
/*      */         
/*  338 */         func_152115_b("");
/*  339 */         playTameEffect(false);
/*  340 */         this.worldObj.setEntityState((Entity)this, (byte)6);
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
/*  351 */     }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.ice) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  354 */       if (!this.worldObj.isRemote) {
/*      */         
/*  356 */         playTameEffect(true);
/*  357 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*  358 */         setSpyroFire(0);
/*  359 */         par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText("Baby Dragon fireballs extinguished."));
/*      */       } 
/*      */       
/*  362 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  364 */         var2.stackSize--;
/*  365 */         if (var2.stackSize <= 0)
/*      */         {
/*  367 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  370 */       return true;
/*  371 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.diamond && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer) && !this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */       
/*  375 */       Entity ent = null;
/*  376 */       Dragon d = null;
/*  377 */       ent = spawnCreature(this.worldObj, "Dragon", this.posX, this.posY, this.posZ);
/*  378 */       if (ent != null) {
/*  379 */         d = (Dragon)ent;
/*  380 */         if (isTamed()) {
/*  381 */           d.setTamed(true);
/*  382 */           d.func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  388 */         setDead();
/*      */       } 
/*  390 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  392 */         var2.stackSize--;
/*  393 */         if (var2.stackSize <= 0)
/*      */         {
/*  395 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  398 */       return true;
/*  399 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.flint_and_steel && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  402 */       if (!this.worldObj.isRemote) {
/*      */         
/*  404 */         playTameEffect(true);
/*  405 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*  406 */         setSpyroFire(1);
/*  407 */         par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText("Baby Dragon fireballs lit!"));
/*      */       } 
/*      */       
/*  410 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  412 */         var2.stackSize--;
/*  413 */         if (var2.stackSize <= 0)
/*      */         {
/*  415 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  418 */       return true;
/*  419 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */       
/*  421 */       setCustomNameTag(var2.getDisplayName());
/*  422 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  424 */         var2.stackSize--;
/*  425 */         if (var2.stackSize <= 0)
/*      */         {
/*  427 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  430 */       return true;
/*  431 */     }  if (isTamed() && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */       
/*  433 */       if (!isSitting()) {
/*  434 */         setSitting(true);
/*      */       } else {
/*  436 */         setSitting(false);
/*      */       } 
/*  438 */       return true;
/*      */     } 
/*      */     
/*  441 */     return super.interact(par1EntityPlayer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/*  449 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.beef);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/*  457 */     if (isNoDespawnRequired()) return false; 
/*  458 */     if (isTamed()) {
/*  459 */       return false;
/*      */     }
/*  461 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  469 */     return 5;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getLivingSound() {
/*  477 */     if (isSitting())
/*      */     {
/*  479 */       return null;
/*      */     }
/*  481 */     if (getActivity() != 2) {
/*  482 */       return null;
/*      */     }
/*  484 */     return "orespawn:roar";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  492 */     return "orespawn:duck_hurt";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  500 */     return "orespawn:cryo_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  508 */     return 0.4F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  516 */     return Items.beef;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  524 */     int var3 = 0;
/*      */     
/*  526 */     if (isTamed()) {
/*      */       
/*  528 */       var3 = this.worldObj.rand.nextInt(4);
/*  529 */       var3++;
/*  530 */       for (int var4 = 0; var4 < var3; var4++)
/*      */       {
/*  532 */         dropItem(Items.beef, 1);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundPitch() {
/*  543 */     return isChild() ? ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1F + 1.5F) : ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1F + 1.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canTriggerWalking() {
/*  551 */     return true;
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
/*  569 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  577 */     if (!this.worldObj.isDaytime()) return false; 
/*  578 */     if (this.posY < 50.0D) return false; 
/*  579 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable var1) {
/*  585 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getAttackStrength(Entity par1Entity) {
/*  590 */     return 4.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  597 */     float var2 = getAttackStrength(par1Entity);
/*  598 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
/*  599 */     return var4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  607 */     boolean ret = false;
/*  608 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*  609 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*      */     }
/*  611 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  619 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  630 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  631 */     super.onUpdate();
/*      */     
/*  633 */     if (isInWater()) {
/*  634 */       this.motionY += 0.07D;
/*      */     }
/*      */     
/*  637 */     if (this.worldObj.isRemote)
/*      */       return; 
/*  639 */     if (this.currentFlightTarget == null) {
/*  640 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     }
/*      */     
/*  643 */     if (this.worldObj.rand.nextInt(100000) == 1 && !isNoDespawnRequired()) {
/*      */       
/*  645 */       Entity ent = null;
/*  646 */       Dragon d = null;
/*  647 */       ent = spawnCreature(this.worldObj, "Dragon", this.posX, this.posY, this.posZ);
/*  648 */       if (ent != null) {
/*  649 */         d = (Dragon)ent;
/*  650 */         if (isTamed()) {
/*  651 */           d.setTamed(true);
/*  652 */           d.func_152115_b(func_152113_b());
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  658 */         setDead();
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*  663 */     if (this.activity == 2) {
/*  664 */       if (this.posY < this.currentFlightTarget.posY + 2.0D) {
/*  665 */         this.motionY *= 0.7D;
/*  666 */       } else if (this.posY > this.currentFlightTarget.posY - 2.0D) {
/*  667 */         this.motionY *= 0.5D;
/*      */       } else {
/*  669 */         this.motionY *= 0.61D;
/*      */       } 
/*      */     }
/*      */     
/*  673 */     if (this.activity == 1 && isTamed() && getOwner() != null) {
/*  674 */       EntityLivingBase e = getOwner();
/*      */       
/*  676 */       if (getDistanceSqToEntity((Entity)e) > 256.0D)
/*      */       {
/*  678 */         setActivity(2);
/*      */       }
/*      */     } 
/*      */     
/*  682 */     do_movement();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  693 */     super.onLivingUpdate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITick() {
/*  702 */     int fly = 0;
/*  703 */     if (this.activity == 1) {
/*  704 */       super.updateAITick();
/*      */     }
/*  706 */     if (this.isDead)
/*  707 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null);
/*      */     
/*  709 */     if (this.worldObj.isRemote)
/*      */       return; 
/*  711 */     if (!isSitting()) {
/*  712 */       if (this.activity == 0) {
/*  713 */         this.activity = 1;
/*      */       }
/*      */       
/*  716 */       if (this.worldObj.rand.nextInt(20) == 0) {
/*      */ 
/*      */ 
/*      */         
/*  720 */         this.closest = 99999;
/*  721 */         this.tx = this.ty = this.tz = 0;
/*  722 */         for (int i = 1; i < 11; i++) {
/*  723 */           int j = i;
/*  724 */           if (j > 4) j = 4; 
/*  725 */           if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/*  726 */             break;  if (i >= 6) i++;
/*      */         
/*      */         } 
/*  729 */         if (this.closest < 99999) {
/*      */           
/*  731 */           setActivity(1);
/*  732 */           getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.0D);
/*  733 */           if (handleLavaMovement()) {
/*  734 */             heal(1.0F);
/*  735 */             playSound("splash", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  740 */       if (this.worldObj.rand.nextInt(100) == 1 && 
/*  741 */         !this.target_in_sight) {
/*  742 */         this.activity = 1;
/*  743 */         if (this.worldObj.rand.nextInt(8) == 1) this.activity = 2; 
/*  744 */         setActivity(this.activity);
/*      */       } 
/*      */ 
/*      */       
/*  748 */       this.owner_flying = 0;
/*  749 */       if (isTamed() && getOwner() != null) {
/*  750 */         EntityPlayer e = (EntityPlayer)getOwner();
/*      */         
/*  752 */         if (e.capabilities.isFlying) fly = 1; 
/*  753 */         if (fly == 1) {
/*  754 */           this.owner_flying = 1;
/*  755 */           setActivity(2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITasks() {
/*  764 */     if (this.isDead)
/*  765 */       return;  super.updateAITasks();
/*      */ 
/*      */     
/*  768 */     if (this.worldObj.rand.nextInt(100) == 1 && 
/*  769 */       getHealth() < mygetMaxHealth()) {
/*  770 */       heal(1.0F);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void do_movement() {
/*  778 */     int xdir = 1;
/*  779 */     int zdir = 1;
/*      */     
/*  781 */     int keep_trying = 50;
/*      */ 
/*      */     
/*  784 */     int do_new = 0;
/*  785 */     double ox = 0.0D, oy = 0.0D, oz = 0.0D;
/*      */     
/*  787 */     int has_owner = 0;
/*  788 */     EntityLivingBase e = null;
/*      */ 
/*      */     
/*  791 */     if (this.currentFlightTarget == null) {
/*  792 */       do_new = 1;
/*  793 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     } 
/*      */     
/*  796 */     if (isSitting())
/*  797 */       return;  if (this.activity == 1) {
/*      */       return;
/*      */     }
/*  800 */     if (getActivity() == 2 && this.worldObj.rand.nextInt(300) == 0) do_new = 1;
/*      */ 
/*      */     
/*  803 */     if (isTamed() && getOwner() != null) {
/*  804 */       e = getOwner();
/*  805 */       has_owner = 1;
/*  806 */       ox = e.posX;
/*  807 */       oy = e.posY;
/*  808 */       oz = e.posZ;
/*      */       
/*  810 */       if (getDistanceSqToEntity((Entity)e) > 100.0D) {
/*  811 */         do_new = 1;
/*      */       }
/*  813 */       if (this.owner_flying != 0 && 
/*  814 */         getDistanceSqToEntity((Entity)e) > 36.0D) {
/*  815 */         do_new = 1;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  821 */     if (this.worldObj.rand.nextInt(6) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*      */ 
/*      */ 
/*      */       
/*  825 */       e = findSomethingToAttack();
/*  826 */       if (e != null) {
/*      */         
/*  828 */         if (isTamed() && getHealth() / mygetMaxHealth() < 0.25F) {
/*  829 */           setActivity(2);
/*  830 */           this.target_in_sight = false;
/*  831 */           do_new = 0;
/*  832 */           this.currentFlightTarget.set((int)(this.posX + this.posX - e.posX), (int)(this.posY + 1.0D), (int)(this.posZ + this.posZ - e.posZ));
/*      */         } else {
/*      */           
/*  835 */           setActivity(2);
/*  836 */           this.target_in_sight = true;
/*  837 */           this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/*  838 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*  839 */           do_new = 0;
/*  840 */           if (getDistanceSqToEntity((Entity)e) < ((3.0F + e.width / 2.0F) * (3.0F + e.width / 2.0F))) {
/*  841 */             attackEntityAsMob((Entity)e);
/*  842 */           } else if (getDistanceSqToEntity((Entity)e) < 64.0D && !isInWater() && ((
/*  843 */             getSpyroFire() == 1 && this.worldObj.rand.nextInt(10) == 0) || this.worldObj.rand.nextInt(15) == 1)) {
/*      */             
/*  845 */             EntitySmallFireball var2 = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, e.posX - this.posX, e.posY + 0.25D - this.posY + 1.25D, e.posZ - this.posZ);
/*  846 */             var2.setLocationAndAngles(this.posX, this.posY + 1.25D, this.posZ, this.rotationYaw, this.rotationPitch);
/*  847 */             this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*  848 */             this.worldObj.spawnEntityInWorld((Entity)var2);
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/*  853 */         this.target_in_sight = false;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  858 */     if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F && 
/*  859 */       getActivity() != 3) do_new = 1;
/*      */ 
/*      */ 
/*      */     
/*  863 */     if (do_new != 0 && !this.target_in_sight) {
/*      */       
/*  865 */       Block bid = Blocks.stone;
/*  866 */       while (bid != Blocks.air && keep_trying != 0) {
/*  867 */         int gox = (int)this.posX;
/*  868 */         int goy = (int)this.posY;
/*  869 */         int goz = (int)this.posZ;
/*  870 */         if (has_owner == 1) {
/*  871 */           gox = (int)ox;
/*  872 */           goy = (int)oy;
/*  873 */           goz = (int)oz;
/*  874 */           if (this.owner_flying == 0) {
/*  875 */             zdir = this.worldObj.rand.nextInt(4) + 6;
/*  876 */             xdir = this.worldObj.rand.nextInt(4) + 6;
/*      */           } else {
/*  878 */             zdir = this.worldObj.rand.nextInt(6);
/*  879 */             xdir = this.worldObj.rand.nextInt(6);
/*      */           } 
/*      */         } else {
/*  882 */           zdir = this.worldObj.rand.nextInt(5) + 6;
/*  883 */           xdir = this.worldObj.rand.nextInt(5) + 6;
/*      */         } 
/*  885 */         if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir; 
/*  886 */         if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir; 
/*  887 */         this.currentFlightTarget.set(gox + xdir, goy + this.worldObj.rand.nextInt(9 + this.owner_flying * 2) - 4, goz + zdir);
/*  888 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/*  889 */         if (bid == Blocks.air && 
/*  890 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/*  891 */           bid = Blocks.stone;
/*      */         }
/*      */         
/*  894 */         keep_trying--;
/*      */       } 
/*      */     } 
/*      */     
/*  898 */     double speed_factor = 0.5D;
/*  899 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/*  900 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/*  901 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/*  902 */     if (this.owner_flying != 0) {
/*  903 */       speed_factor = 1.75D;
/*  904 */       if (isTamed() && getOwner() != null) {
/*  905 */         e = getOwner();
/*  906 */         if (getDistanceSqToEntity((Entity)e) > 49.0D) {
/*  907 */           speed_factor = 3.5D;
/*      */         }
/*      */       } 
/*      */     } 
/*  911 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.15D * speed_factor;
/*  912 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.21D * speed_factor;
/*  913 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.15D * speed_factor;
/*  914 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/*  915 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/*  916 */     this.moveForward = (float)(0.75D * speed_factor);
/*      */     
/*  918 */     this.rotationYaw += var8 / 3.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  926 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*      */     
/*  928 */     if (par1EntityLiving == null)
/*      */     {
/*  930 */       return false;
/*      */     }
/*  932 */     if (par1EntityLiving == this)
/*      */     {
/*  934 */       return false;
/*      */     }
/*  936 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*  938 */       return false;
/*      */     }
/*  940 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/*  943 */       return false;
/*      */     }
/*  945 */     if (par1EntityLiving instanceof Spyro)
/*      */     {
/*  947 */       return false;
/*      */     }
/*      */     
/*  950 */     if (par1EntityLiving instanceof Mothra)
/*      */     {
/*  952 */       return true;
/*      */     }
/*      */     
/*  955 */     if (par1EntityLiving instanceof EntityMob)
/*      */     {
/*  957 */       return true;
/*      */     }
/*      */     
/*  960 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/*  965 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/*  966 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 6.0D, 12.0D));
/*  967 */     Collections.sort(var5, this.TargetSorter);
/*  968 */     Iterator<?> var2 = var5.iterator();
/*  969 */     Entity var3 = null;
/*  970 */     EntityLivingBase var4 = null;
/*      */     
/*  972 */     while (var2.hasNext()) {
/*      */       
/*  974 */       var3 = (Entity)var2.next();
/*  975 */       var4 = (EntityLivingBase)var3;
/*      */       
/*  977 */       if (isSuitableTarget(var4, false) && canSeeTarget(var4.posX, var4.posY, var4.posZ))
/*      */       {
/*  979 */         return var4;
/*      */       }
/*      */     } 
/*  982 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/*  991 */     Entity var8 = null;
/*      */ 
/*      */     
/*  994 */     var8 = EntityList.createEntityByName(par1, par0World);
/*      */     
/*  996 */     if (var8 != null) {
/*      */ 
/*      */       
/*  999 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/* 1002 */       par0World.spawnEntityInWorld(var8);
/*      */       
/* 1004 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*      */     
/* 1007 */     return var8;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Spyro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */