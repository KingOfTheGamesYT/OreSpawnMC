/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class Chipmunk
/*     */   extends EntityCannonFodder
/*     */ {
/*  45 */   private float moveSpeed = 0.38F;
/*     */ 
/*     */   
/*     */   public Chipmunk(World par1World) {
/*  49 */     super(par1World);
/*     */     
/*  51 */     setSize(0.35F, 0.35F);
/*  52 */     this.moveSpeed = 0.38F;
/*  53 */     this.fireResistance = 100;
/*  54 */     getNavigator().setAvoidsWater(true);
/*  55 */     setSitting(false);
/*  56 */     this.experienceValue = 5;
/*  57 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  58 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D));
/*  59 */     this.tasks.addTask(2, new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F));
/*  60 */     this.tasks.addTask(3, new MyEntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.600000023841858D));
/*  61 */     this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.apple, false));
/*  62 */     this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  63 */     this.tasks.addTask(6, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 8.0F, 1.0D, 1.399999976158142D));
/*  64 */     this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  65 */     this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 5.0F));
/*  66 */     this.tasks.addTask(9, new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  67 */     this.tasks.addTask(10, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  68 */     this.tasks.addTask(11, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  73 */     super.applyEntityAttributes();
/*  74 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  75 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  76 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  77 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  82 */     super.entityInit();
/*  83 */     setSitting(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  91 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  92 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {
/*  99 */     float i = MathHelper.ceiling_float_int(par1 - 3.0F);
/*     */     
/* 101 */     if (i > 0.0F) {
/*     */       
/* 103 */       if (i > 3.0F) {
/*     */         
/* 105 */         playSound("damage.fallbig", 1.0F, 1.0F);
/*     */       }
/*     */       else {
/*     */         
/* 109 */         playSound("damage.fallsmall", 1.0F, 1.0F);
/*     */       } 
/* 111 */       if (i > 2.0F)
/*     */       {
/* 113 */         i = 2.0F;
/*     */       }
/* 115 */       attackEntityFrom(DamageSource.fall, i);
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
/*     */   protected void updateAITick() {
/* 128 */     if (this.isDead)
/* 129 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 130 */     if (this.worldObj.rand.nextInt(250) == 0)
/*     */     {
/* 132 */       heal(1.0F);
/*     */     }
/* 134 */     if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(600) == 1) {
/* 135 */       Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ);
/* 136 */       if ((bid == Blocks.dirt || bid == Blocks.farmland) && 
/* 137 */         this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ, Blocks.air, 0, 2);
/*     */     
/*     */     } 
/* 140 */     super.updateAITick();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/* 149 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 155 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 160 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getChipmunkHealth() {
/* 167 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 175 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */ 
/*     */     
/* 178 */     if (var2 != null)
/*     */     {
/* 180 */       if (var2.stackSize <= 0) {
/*     */         
/* 182 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 183 */         var2 = null;
/*     */       } 
/*     */     }
/*     */     
/* 187 */     if (super.interact(par1EntityPlayer)) {
/* 188 */       return true;
/*     */     }
/*     */     
/* 191 */     if (var2 != null && var2.getItem() == Items.apple && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 193 */       if (!isTamed()) {
/*     */         
/* 195 */         if (!this.worldObj.isRemote)
/*     */         {
/* 197 */           if (this.rand.nextInt(2) == 0)
/*     */           {
/* 199 */             setTamed(true);
/* 200 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 201 */             playTameEffect(true);
/* 202 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/* 203 */             heal(mygetMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 208 */             playTameEffect(false);
/* 209 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 214 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */         
/* 216 */         if (this.worldObj.isRemote) {
/* 217 */           playTameEffect(true);
/* 218 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*     */         } 
/*     */         
/* 221 */         if (mygetMaxHealth() > getHealth()) {
/* 222 */           heal(mygetMaxHealth() - getHealth());
/*     */         }
/*     */       } 
/*     */       
/* 226 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 228 */         var2.stackSize--;
/* 229 */         if (var2.stackSize <= 0)
/*     */         {
/* 231 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 234 */       return true;
/* 235 */     }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */ 
/*     */       
/* 238 */       if (!this.worldObj.isRemote) {
/*     */         
/* 240 */         setTamed(false);
/* 241 */         func_152115_b("");
/* 242 */         playTameEffect(false);
/* 243 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */       } 
/* 245 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 247 */         var2.stackSize--;
/* 248 */         if (var2.stackSize <= 0)
/*     */         {
/* 250 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 253 */       return true;
/*     */     } 
/*     */     
/* 256 */     if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */       
/* 258 */       setCustomNameTag(var2.getDisplayName());
/* 259 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 261 */         var2.stackSize--;
/* 262 */         if (var2.stackSize <= 0)
/*     */         {
/* 264 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 267 */       return true;
/* 268 */     }  if (isTamed() && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 270 */       if (!isSitting()) {
/* 271 */         setSitting(true);
/*     */       } else {
/* 273 */         setSitting(false);
/*     */       } 
/* 275 */       return true;
/*     */     } 
/*     */     
/* 278 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 287 */     if (isSitting())
/*     */     {
/* 289 */       return null;
/*     */     }
/* 291 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 299 */     return "orespawn:scorpion_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 307 */     return "orespawn:cryo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 315 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 323 */     return Items.wheat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 331 */     int var3 = 0;
/*     */     
/* 333 */     if (isTamed()) {
/*     */       
/* 335 */       var3 = this.rand.nextInt(5);
/* 336 */       var3 += 2;
/* 337 */       for (int var4 = 0; var4 < var3; var4++)
/*     */       {
/* 339 */         dropItem(Item.getItemFromBlock((Block)Blocks.red_flower), 1);
/*     */       }
/*     */     } else {
/* 342 */       super.dropFewItems(par1, par2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 353 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 360 */     if (this.posY < 50.0D) return false; 
/* 361 */     if (findBuddies() > 2) return false; 
/* 362 */     return true;
/*     */   }
/*     */   
/*     */   private int findBuddies() {
/* 366 */     List var5 = this.worldObj.getEntitiesWithinAABB(Chipmunk.class, this.boundingBox.expand(20.0D, 10.0D, 20.0D));
/* 367 */     return var5.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 375 */     if (isChild()) {
/* 376 */       enablePersistence();
/* 377 */       return false;
/*     */     } 
/* 379 */     if (isNoDespawnRequired()) return false; 
/* 380 */     if (isTamed()) return false; 
/* 381 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 386 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chipmunk spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 392 */     return new Chipmunk(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 400 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 409 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Chipmunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */