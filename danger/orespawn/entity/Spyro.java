/*      */ package danger.orespawn.entity;
/*      */ 
/*      */ import danger.orespawn.OreSpawnMain;
/*      */ import danger.orespawn.util.ai.MyEntityAIFollowOwner;
/*      */ import danger.orespawn.util.ai.MyEntityAIWander;
/*      */ import danger.orespawn.util.handlers.SoundsHandler;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import javax.annotation.Nullable;
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
/*      */ import net.minecraft.init.SoundEvents;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.network.datasync.DataParameter;
/*      */ import net.minecraft.network.datasync.DataSerializers;
/*      */ import net.minecraft.network.datasync.EntityDataManager;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.EnumHand;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.SoundCategory;
/*      */ import net.minecraft.util.SoundEvent;
/*      */ import net.minecraft.util.math.BlockPos;
/*      */ import net.minecraft.util.math.MathHelper;
/*      */ import net.minecraft.util.math.Vec3d;
/*      */ import net.minecraft.util.text.ITextComponent;
/*      */ import net.minecraft.util.text.TextComponentString;
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
/*      */ public class Spyro
/*      */   extends EntityTameable
/*      */ {
/*   66 */   protected static final DataParameter<Byte> ACTIVITY = EntityDataManager.createKey(Spyro.class, DataSerializers.BYTE);
/*   67 */   protected static final DataParameter<Byte> FIRE = EntityDataManager.createKey(Spyro.class, DataSerializers.BYTE);
/*      */   
/*      */   private BlockPos currentFlightTarget;
/*   70 */   private GenericTargetSorter TargetSorter = null;
/*   71 */   public int activity = 1;
/*   72 */   private int owner_flying = 0;
/*      */   
/*      */   private boolean target_in_sight = false;
/*   75 */   private float moveSpeed = 0.3F;
/*      */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*      */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*   78 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D); } public Spyro(World par1World) { super(par1World);
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
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  148 */     this.closest = 99999;
/*  149 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.5F, 0.5F); this.moveSpeed = 0.3F; this.isImmuneToFire = true; setSitting(false); this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 0.30000001192092896D, 0.4000000059604645D)); this.tasks.addTask(3, (EntityAIBase)new MyEntityAIFollowOwner(this, 1.15F, 12.0F, 2.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.BEEF, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.75F)); this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); this.TargetSorter = new GenericTargetSorter((Entity)this); this.experienceValue = 35; }
/*      */   protected void entityInit() { super.entityInit(); this.activity = 1; this.dataManager.register(ACTIVITY, Byte.valueOf((byte)this.activity)); this.dataManager.register(FIRE, Byte.valueOf((byte)1));
/*      */     setSitting(false);
/*  152 */     setTamed(false); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*      */ 
/*      */     
/*      */     int i;
/*      */     
/*  157 */     for (i = -dy; i <= dy; i++) {
/*  158 */       for (int j = -dz; j <= dz; j++) {
/*  159 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/*  160 */         if (bid == Blocks.LAVA || bid == Blocks.FLOWING_LAVA) {
/*  161 */           int d = dx * dx + j * j + i * i;
/*  162 */           if (d < this.closest) {
/*  163 */             this.closest = d;
/*  164 */             this.tx = x + dx;
/*  165 */             this.ty = y + i;
/*  166 */             this.tz = z + j;
/*  167 */             found++;
/*      */           } 
/*      */         } 
/*  170 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/*  171 */         if (bid == Blocks.LAVA || bid == Blocks.FLOWING_LAVA) {
/*  172 */           int d = dx * dx + j * j + i * i;
/*  173 */           if (d < this.closest) {
/*  174 */             this.closest = d;
/*  175 */             this.tx = x - dx;
/*  176 */             this.ty = y + i;
/*  177 */             this.tz = z + j;
/*  178 */             found++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  184 */     for (i = -dx; i <= dx; i++) {
/*  185 */       for (int j = -dz; j <= dz; j++) {
/*  186 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/*  187 */         if (bid == Blocks.LAVA || bid == Blocks.FLOWING_LAVA) {
/*  188 */           int d = dy * dy + j * j + i * i;
/*  189 */           if (d < this.closest) {
/*  190 */             this.closest = d;
/*  191 */             this.tx = x + i;
/*  192 */             this.ty = y + dy;
/*  193 */             this.tz = z + j;
/*  194 */             found++;
/*      */           } 
/*      */         } 
/*  197 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/*  198 */         if (bid == Blocks.LAVA || bid == Blocks.FLOWING_LAVA) {
/*  199 */           int d = dy * dy + j * j + i * i;
/*  200 */           if (d < this.closest) {
/*  201 */             this.closest = d;
/*  202 */             this.tx = x + i;
/*  203 */             this.ty = y - dy;
/*  204 */             this.tz = z + j;
/*  205 */             found++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  211 */     for (i = -dx; i <= dx; i++) {
/*  212 */       for (int j = -dy; j <= dy; j++) {
/*  213 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/*  214 */         if (bid == Blocks.LAVA || bid == Blocks.FLOWING_LAVA) {
/*  215 */           int d = dz * dz + j * j + i * i;
/*  216 */           if (d < this.closest) {
/*  217 */             this.closest = d;
/*  218 */             this.tx = x + i;
/*  219 */             this.ty = y + j;
/*  220 */             this.tz = z + dz;
/*  221 */             found++;
/*      */           } 
/*      */         } 
/*  224 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/*  225 */         if (bid == Blocks.LAVA || bid == Blocks.FLOWING_LAVA) {
/*  226 */           int d = dz * dz + j * j + i * i;
/*  227 */           if (d < this.closest) {
/*  228 */             this.closest = d;
/*  229 */             this.tx = x + i;
/*  230 */             this.ty = y + j;
/*  231 */             this.tz = z - dz;
/*  232 */             found++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  238 */     if (found != 0) return true; 
/*  239 */     return false; } public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) { super.writeEntityToNBT(par1NBTTagCompound); par1NBTTagCompound.setInteger("SpyroActivity", ((Byte)this.dataManager.get(ACTIVITY)).byteValue());
/*      */     par1NBTTagCompound.setInteger("SpyroFire", ((Byte)this.dataManager.get(FIRE)).byteValue()); }
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) { super.readEntityFromNBT(par1NBTTagCompound);
/*      */     this.activity = par1NBTTagCompound.getInteger("SpyroActivity");
/*      */     this.dataManager.set(ACTIVITY, Byte.valueOf((byte)this.activity));
/*      */     this.dataManager.set(FIRE, Byte.valueOf((byte)par1NBTTagCompound.getInteger("SpyroFire"))); }
/*  245 */   public int getActivity() { int i = ((Byte)this.dataManager.get(ACTIVITY)).byteValue();
/*      */     
/*  247 */     return i; }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivity(int par1) {
/*  252 */     this.activity = par1;
/*  253 */     this.dataManager.set(ACTIVITY, Byte.valueOf((byte)this.activity));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSpyroFire() {
/*  259 */     return ((Byte)this.dataManager.get(FIRE)).byteValue();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSpyroFire(int par1) {
/*  265 */     this.dataManager.set(FIRE, Byte.valueOf((byte)par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIDisabled() {
/*  275 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBreatheUnderwater() {
/*  282 */     return true;
/*      */   }
/*      */   
/*      */   public int mygetMaxHealth() {
/*  286 */     return 200;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSpyroHealth() {
/*  293 */     return (int)getHealth();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean processInteract(EntityPlayer player, EnumHand hand) {
/*  298 */     ItemStack var2 = player.inventory.getCurrentItem();
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
/*  310 */     if (var2 != null && var2.getItem() == Items.BEEF && player.getDistanceSq((Entity)this) < 16.0D) {
/*  311 */       if (!isTamed() && 
/*  312 */         !this.world.isRemote) {
/*  313 */         if (this.world.rand.nextInt(2) == 1) {
/*  314 */           setTamedBy(player);
/*      */           
/*  316 */           playTameEffect(true);
/*  317 */           this.world.setEntityState((Entity)this, (byte)7);
/*  318 */           heal(mygetMaxHealth() - getHealth());
/*      */         } else {
/*      */           
/*  321 */           playTameEffect(false);
/*  322 */           this.world.setEntityState((Entity)this, (byte)6);
/*      */         } 
/*      */       }
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
/*  339 */       if (!player.capabilities.isCreativeMode) {
/*  340 */         var2.setCount(var2.getCount() - 1);
/*  341 */         if (var2.getCount() <= 0) {
/*  342 */           player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  345 */       return true;
/*  346 */     }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.DEADBUSH) && player.getDistanceSq((Entity)this) < 16.0D) {
/*      */       
/*  348 */       if (!this.world.isRemote) {
/*  349 */         setTamed(false);
/*  350 */         setHealth(mygetMaxHealth());
/*  351 */         setOwnerId(null);
/*      */ 
/*      */         
/*  354 */         playTameEffect(false);
/*  355 */         this.world.setEntityState((Entity)this, (byte)6);
/*      */       } 
/*  357 */       if (!player.capabilities.isCreativeMode) {
/*      */         
/*  359 */         var2.setCount(var2.getCount() - 1);
/*  360 */         if (var2.getCount() <= 0) {
/*  361 */           player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  364 */       return true;
/*  365 */     }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.ICE) && player.getDistanceSq((Entity)this) < 16.0D) {
/*      */       
/*  367 */       if (!this.world.isRemote) {
/*  368 */         playTameEffect(true);
/*  369 */         this.world.setEntityState((Entity)this, (byte)6);
/*  370 */         setSpyroFire(0);
/*  371 */         player.sendMessage((ITextComponent)new TextComponentString("Baby Spyro fireballs extinguished."));
/*      */       } 
/*      */ 
/*      */       
/*  375 */       if (!player.capabilities.isCreativeMode) {
/*  376 */         var2.setCount(var2.getCount() - 1);
/*  377 */         if (var2.getCount() <= 0) {
/*  378 */           player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  381 */       return true;
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
/*      */     
/*  410 */     if (isTamed() && var2 != null && var2.getItem() == Items.FLINT_AND_STEEL && player.getDistanceSq((Entity)this) < 16.0D) {
/*      */       
/*  412 */       if (!this.world.isRemote) {
/*  413 */         playTameEffect(true);
/*  414 */         this.world.setEntityState((Entity)this, (byte)6);
/*  415 */         setSpyroFire(1);
/*  416 */         player.sendMessage((ITextComponent)new TextComponentString("Baby Spyro fireballs lit!"));
/*      */       } 
/*      */ 
/*      */       
/*  420 */       if (!player.capabilities.isCreativeMode) {
/*  421 */         var2.setCount(var2.getCount() - 1);
/*  422 */         if (var2.getCount() <= 0) {
/*  423 */           player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  426 */       return true;
/*  427 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.NAME_TAG && player.getDistanceSq((Entity)this) < 16.0D) {
/*      */       
/*  429 */       setCustomNameTag(var2.getDisplayName());
/*  430 */       if (!player.capabilities.isCreativeMode) {
/*  431 */         var2.setCount(var2.getCount() - 1);
/*  432 */         if (var2.getCount() <= 0) {
/*  433 */           player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  436 */       return true;
/*  437 */     }  if (isTamed() && player.getDistanceSq((Entity)this) < 16.0D) {
/*  438 */       setSitting(!isSitting());
/*  439 */       return true;
/*      */     } 
/*      */ 
/*      */     
/*  443 */     return super.processInteract(player, hand);
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
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/*  624 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.BEEF);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/*  631 */     if (isNoDespawnRequired()) return false; 
/*  632 */     return !isTamed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  639 */     return 5;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getLivingSound() {
/*  646 */     if (isSitting()) {
/*  647 */       return null;
/*      */     }
/*  649 */     if (getActivity() != 2) {
/*  650 */       return null;
/*      */     }
/*  652 */     return "orespawn:roar";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/*  661 */     return SoundsHandler.ENTITY_DUCK_HURT;
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
/*      */   
/*      */   protected float getSoundVolume() {
/*  678 */     return 0.4F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  686 */     return Items.BEEF;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  694 */     int var3 = 0;
/*      */     
/*  696 */     if (isTamed()) {
/*      */       
/*  698 */       var3 = this.world.rand.nextInt(4);
/*  699 */       var3++;
/*  700 */       for (int var4 = 0; var4 < var3; var4++) {
/*  701 */         dropItem(Items.BEEF, 1);
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
/*  712 */     return isChild() ? ((this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.1F + 1.5F) : ((this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.1F + 1.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canTriggerWalking() {
/*  721 */     return true;
/*      */   }
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
/*      */   public boolean doesEntityNotTriggerPressurePlate() {
/*  743 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  751 */     if (!this.world.isDaytime()) return false; 
/*  752 */     if (this.posY < 50.0D) return false; 
/*  753 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable var1) {
/*  759 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getAttackStrength(Entity par1Entity) {
/*  764 */     return 4.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  771 */     float var2 = getAttackStrength(par1Entity);
/*  772 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
/*  773 */     return var4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  781 */     boolean ret = false;
/*  782 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*  783 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*      */     }
/*  785 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  793 */     return (this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY + 0.75D, this.posZ), new Vec3d(pX, pY, pZ), false) == null);
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
/*      */   public void onUpdate() {
/*  805 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  806 */     super.onUpdate();
/*      */     
/*  808 */     if (isInWater()) {
/*  809 */       this.motionY += 0.07D;
/*      */     }
/*      */     
/*  812 */     if (this.world.isRemote)
/*      */       return; 
/*  814 */     if (this.currentFlightTarget == null) {
/*  815 */       this.currentFlightTarget = new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     }
/*      */ 
/*      */     
/*  819 */     if (this.world.rand.nextInt(100000) == 1 && !isNoDespawnRequired()) {
/*      */       
/*  821 */       Entity ent = null;
/*  822 */       Spyro d = null;
/*  823 */       ent = spawnCreature(this.world, "Spyro", this.posX, this.posY, this.posZ);
/*  824 */       if (ent != null) {
/*  825 */         d = (Spyro)ent;
/*  826 */         if (isTamed()) {
/*  827 */           d.setTamed(true);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  836 */         setDead();
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*  841 */     if (this.activity == 2) {
/*  842 */       if (this.posY < this.currentFlightTarget.getY() + 2.0D) {
/*  843 */         this.motionY *= 0.7D;
/*  844 */       } else if (this.posY > this.currentFlightTarget.getY() - 2.0D) {
/*  845 */         this.motionY *= 0.5D;
/*      */       } else {
/*  847 */         this.motionY *= 0.61D;
/*      */       } 
/*      */     }
/*      */     
/*  851 */     if (this.activity == 1 && isTamed() && getOwner() != null) {
/*  852 */       EntityLivingBase e = getOwner();
/*      */       
/*  854 */       if (getDistanceSq((Entity)e) > 256.0D)
/*      */       {
/*  856 */         setActivity(2);
/*      */       }
/*      */     } 
/*      */     
/*  860 */     do_movement();
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
/*  871 */     super.onLivingUpdate();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEntityUpdate() {
/*  877 */     int fly = 0;
/*  878 */     if (this.activity == 1) {
/*  879 */       super.onEntityUpdate();
/*      */     }
/*  881 */     if (this.isDead)
/*  882 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null);
/*      */     
/*  884 */     if (this.world.isRemote)
/*      */       return; 
/*  886 */     if (!isSitting()) {
/*  887 */       if (this.activity == 0) {
/*  888 */         this.activity = 1;
/*      */       }
/*      */       
/*  891 */       if (this.world.rand.nextInt(20) == 0) {
/*      */ 
/*      */ 
/*      */         
/*  895 */         this.closest = 99999;
/*  896 */         this.tx = this.ty = this.tz = 0;
/*  897 */         for (int i = 1; i < 11; i++) {
/*  898 */           int j = i;
/*  899 */           if (j > 4) j = 4; 
/*  900 */           if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i))
/*  901 */             break;  if (i >= 6) i++;
/*      */         
/*      */         } 
/*  904 */         if (this.closest < 99999) {
/*      */           
/*  906 */           setActivity(1);
/*  907 */           getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.0D);
/*  908 */           if (handleWaterMovement()) {
/*  909 */             heal(1.0F);
/*  910 */             playSound(SoundEvents.ENTITY_GENERIC_SPLASH, 1.0F, this.world.rand.nextFloat() * 0.2F + 0.9F);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  916 */       if (this.world.rand.nextInt(100) == 1 && 
/*  917 */         !this.target_in_sight) {
/*  918 */         this.activity = 1;
/*  919 */         if (this.world.rand.nextInt(8) == 1) this.activity = 2; 
/*  920 */         setActivity(this.activity);
/*      */       } 
/*      */ 
/*      */       
/*  924 */       this.owner_flying = 0;
/*  925 */       if (isTamed() && getOwner() != null) {
/*  926 */         EntityPlayer e = (EntityPlayer)getOwner();
/*      */         
/*  928 */         if (e.capabilities.isFlying) fly = 1; 
/*  929 */         if (fly == 1) {
/*  930 */           this.owner_flying = 1;
/*  931 */           setActivity(2);
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
/*      */   protected void updateAITasks() {
/* 1006 */     if (this.isDead)
/* 1007 */       return;  super.updateAITasks();
/*      */ 
/*      */     
/* 1010 */     if (this.world.rand.nextInt(100) == 1 && 
/* 1011 */       getHealth() < mygetMaxHealth()) {
/* 1012 */       heal(1.0F);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void do_movement() {
/* 1019 */     int xdir = 1;
/* 1020 */     int zdir = 1;
/*      */     
/* 1022 */     int keep_trying = 50;
/*      */ 
/*      */     
/* 1025 */     int do_new = 0;
/* 1026 */     double ox = 0.0D, oy = 0.0D, oz = 0.0D;
/*      */     
/* 1028 */     int has_owner = 0;
/* 1029 */     EntityLivingBase e = null;
/*      */ 
/*      */     
/* 1032 */     if (this.currentFlightTarget == null) {
/* 1033 */       do_new = 1;
/* 1034 */       this.currentFlightTarget = new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     } 
/*      */     
/* 1037 */     if (isSitting())
/* 1038 */       return;  if (this.activity == 1) {
/*      */       return;
/*      */     }
/* 1041 */     if (getActivity() == 2 && this.world.rand.nextInt(300) == 0) do_new = 1;
/*      */ 
/*      */     
/* 1044 */     if (isTamed() && getOwner() != null) {
/* 1045 */       e = getOwner();
/* 1046 */       has_owner = 1;
/* 1047 */       ox = e.posX;
/* 1048 */       oy = e.posY;
/* 1049 */       oz = e.posZ;
/*      */       
/* 1051 */       if (getDistanceSq((Entity)e) > 100.0D) {
/* 1052 */         do_new = 1;
/*      */       }
/* 1054 */       if (this.owner_flying != 0 && 
/* 1055 */         getDistanceSq((Entity)e) > 36.0D) {
/* 1056 */         do_new = 1;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1062 */     if (this.world.rand.nextInt(6) == 1 && this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {
/*      */ 
/*      */       
/* 1065 */       e = findSomethingToAttack();
/* 1066 */       if (e != null) {
/* 1067 */         if (isTamed() && getHealth() / mygetMaxHealth() < 0.25F) {
/* 1068 */           setActivity(2);
/* 1069 */           this.target_in_sight = false;
/* 1070 */           do_new = 0;
/* 1071 */           this.currentFlightTarget = new BlockPos((int)(this.posX + this.posX - e.posX), (int)(this.posY + 1.0D), (int)(this.posZ + this.posZ - e.posZ));
/*      */         }
/*      */         else {
/*      */           
/* 1075 */           setActivity(2);
/* 1076 */           this.target_in_sight = true;
/* 1077 */           this.currentFlightTarget = new BlockPos((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/*      */           
/* 1079 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 1080 */           do_new = 0;
/* 1081 */           if (getDistanceSq((Entity)e) < ((3.0F + e.width / 2.0F) * (3.0F + e.width / 2.0F))) {
/* 1082 */             attackEntityAsMob((Entity)e);
/* 1083 */           } else if (getDistanceSq((Entity)e) < 64.0D && !isInWater() && ((
/* 1084 */             getSpyroFire() == 1 && this.world.rand.nextInt(10) == 0) || this.world.rand.nextInt(15) == 1)) {
/*      */             
/* 1086 */             EntitySmallFireball var2 = new EntitySmallFireball(this.world, (EntityLivingBase)this, e.posX - this.posX, e.posY + 0.25D - this.posY + 1.25D, e.posZ - this.posZ);
/* 1087 */             var2.setLocationAndAngles(this.posX, this.posY + 1.25D, this.posZ, this.rotationYaw, this.rotationPitch);
/* 1088 */             this.world.playSound(null, getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*      */             
/* 1090 */             this.world.spawnEntity((Entity)var2);
/*      */           }
/*      */         
/*      */         } 
/*      */       } else {
/*      */         
/* 1096 */         this.target_in_sight = false;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1102 */     if (this.currentFlightTarget.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 2.0999999046325684D && 
/* 1103 */       getActivity() != 3) do_new = 1;
/*      */ 
/*      */ 
/*      */     
/* 1107 */     if (do_new != 0 && !this.target_in_sight) {
/* 1108 */       Block bid = Blocks.STONE;
/* 1109 */       while (bid != Blocks.AIR && keep_trying != 0) {
/* 1110 */         int gox = (int)this.posX;
/* 1111 */         int goy = (int)this.posY;
/* 1112 */         int goz = (int)this.posZ;
/* 1113 */         if (has_owner == 1) {
/* 1114 */           gox = (int)ox;
/* 1115 */           goy = (int)oy;
/* 1116 */           goz = (int)oz;
/* 1117 */           if (this.owner_flying == 0) {
/* 1118 */             zdir = this.world.rand.nextInt(4) + 6;
/* 1119 */             xdir = this.world.rand.nextInt(4) + 6;
/*      */           } else {
/* 1121 */             zdir = this.world.rand.nextInt(6);
/* 1122 */             xdir = this.world.rand.nextInt(6);
/*      */           } 
/*      */         } else {
/* 1125 */           zdir = this.world.rand.nextInt(5) + 6;
/* 1126 */           xdir = this.world.rand.nextInt(5) + 6;
/*      */         } 
/* 1128 */         if (this.world.rand.nextInt(2) == 0) zdir = -zdir; 
/* 1129 */         if (this.world.rand.nextInt(2) == 0) xdir = -xdir; 
/* 1130 */         this.currentFlightTarget = new BlockPos(gox + xdir, goy + this.world.rand.nextInt(9 + this.owner_flying * 2) - 4, goz + zdir);
/*      */         
/* 1132 */         bid = this.world.getBlockState(new BlockPos(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())).getBlock();
/*      */         
/* 1134 */         if (bid == Blocks.AIR && 
/* 1135 */           !canSeeTarget(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())) {
/* 1136 */           bid = Blocks.STONE;
/*      */         }
/*      */         
/* 1139 */         keep_trying--;
/*      */       } 
/*      */     } 
/*      */     
/* 1143 */     double speed_factor = 0.5D;
/* 1144 */     double var1 = this.currentFlightTarget.getX() + 0.5D - this.posX;
/* 1145 */     double var3 = this.currentFlightTarget.getY() + 0.1D - this.posY;
/* 1146 */     double var5 = this.currentFlightTarget.getZ() + 0.5D - this.posZ;
/* 1147 */     if (this.owner_flying != 0) {
/* 1148 */       speed_factor = 1.75D;
/* 1149 */       if (isTamed() && getOwner() != null) {
/* 1150 */         e = getOwner();
/* 1151 */         if (getDistanceSq((Entity)e) > 49.0D) {
/* 1152 */           speed_factor = 3.5D;
/*      */         }
/*      */       } 
/*      */     } 
/* 1156 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.15D * speed_factor;
/* 1157 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.21D * speed_factor;
/* 1158 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.15D * speed_factor;
/* 1159 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 1160 */     float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
/*      */     
/* 1162 */     this.moveForward = (float)(0.75D * speed_factor);
/*      */     
/* 1164 */     this.rotationYaw += var8 / 3.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 1171 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) return false;
/*      */     
/* 1173 */     if (par1EntityLiving == null) {
/* 1174 */       return false;
/*      */     }
/* 1176 */     if (par1EntityLiving == this) {
/* 1177 */       return false;
/*      */     }
/* 1179 */     if (!par1EntityLiving.isEntityAlive()) {
/* 1180 */       return false;
/*      */     }
/* 1182 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/* 1184 */       return false;
/*      */     }
/* 1186 */     if (par1EntityLiving instanceof Spyro) {
/* 1187 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1195 */     if (par1EntityLiving instanceof EntityMob) {
/* 1196 */       return true;
/*      */     }
/*      */     
/* 1199 */     return false;
/*      */   }
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/* 1203 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 1204 */     List<?> var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(12.0D, 6.0D, 12.0D));
/* 1205 */     Collections.sort(var5, this.TargetSorter);
/* 1206 */     Iterator<?> var2 = var5.iterator();
/* 1207 */     Entity var3 = null;
/* 1208 */     EntityLivingBase var4 = null;
/*      */     
/* 1210 */     while (var2.hasNext()) {
/* 1211 */       var3 = (Entity)var2.next();
/* 1212 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1214 */       if (isSuitableTarget(var4, false) && canSeeTarget(var4.posX, var4.posY, var4.posZ)) {
/* 1215 */         return var4;
/*      */       }
/*      */     } 
/* 1218 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 1226 */     Entity var8 = null;
/*      */ 
/*      */ 
/*      */     
/* 1230 */     var8 = EntityList.createEntityByIDFromName(new ResourceLocation(par1), par0World);
/*      */     
/* 1232 */     if (var8 != null) {
/*      */       
/* 1234 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/* 1237 */       par0World.spawnEntity(var8);
/*      */ 
/*      */       
/* 1240 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*      */     
/* 1243 */     return var8;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\Spyro.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */