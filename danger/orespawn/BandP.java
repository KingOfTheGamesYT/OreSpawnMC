/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAIOpenDoor;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BandP
/*     */   extends EntityMob
/*     */ {
/*  54 */   private GenericTargetSorter TargetSorter = null;
/*  55 */   private float moveSpeed = 0.32F;
/*  56 */   private int whatset = 0;
/*  57 */   private int whatami = 0;
/*  58 */   public ItemStack[] MymainInventory = new ItemStack[100];
/*  59 */   int got_stuff = 0;
/*     */ 
/*     */   
/*     */   public BandP(World par1World) {
/*  63 */     super(par1World);
/*  64 */     setSize(0.75F, 1.75F);
/*  65 */     getNavigator().setAvoidsWater(true);
/*  66 */     this.experienceValue = 1000;
/*  67 */     this.fireResistance = 2;
/*  68 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */     
/*  70 */     this.tasks.addTask(0, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.5D, false));
/*  71 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 16, 0.5D));
/*  72 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  73 */     this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  74 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
/*  75 */     this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  81 */     super.applyEntityAttributes();
/*  82 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  83 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  84 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.BandP_stats.attack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  90 */     super.entityInit();
/*  91 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  96 */     if (isNoDespawnRequired()) return false; 
/*  97 */     if (this.got_stuff != 0) return false; 
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 106 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 107 */     super.onUpdate();
/* 108 */     if (!this.worldObj.isRemote && 
/* 109 */       this.whatset == 0) {
/* 110 */       this.whatset = 1;
/* 111 */       this.whatami = this.worldObj.rand.nextInt(2);
/* 112 */       setWhat(this.whatami);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 119 */     return OreSpawnMain.BandP_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 127 */     return OreSpawnMain.BandP_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 135 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 144 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 153 */     return "mob.villager.idle";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 161 */     return "mob.villager.hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 169 */     return "mob.villager.death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 176 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 183 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 191 */     return Items.emerald;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 196 */     EntityItem var3 = null;
/* 197 */     if (index == null) return null; 
/* 198 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 200 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*     */     
/* 202 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 203 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 211 */     int var4 = 10 + this.worldObj.rand.nextInt(5); int i;
/* 212 */     for (i = 0; i < var4; i++) {
/* 213 */       dropItemRand(Items.emerald, 1);
/*     */     }
/*     */     
/* 216 */     if (getWhat() == 0) {
/* 217 */       var4 = 2 + this.worldObj.rand.nextInt(3);
/* 218 */       for (i = 0; i < var4; i++) {
/* 219 */         dropItemRand(OreSpawnMain.UraniumNugget, 1);
/* 220 */         dropItemRand(OreSpawnMain.TitaniumNugget, 1);
/*     */       } 
/*     */     } 
/* 223 */     for (i = 0; i < this.MymainInventory.length; i++) {
/* 224 */       if (this.MymainInventory[i] != null && 
/* 225 */         (this.MymainInventory[i]).stackSize != 0) {
/* 226 */         ItemStack is = dropItemRand(this.MymainInventory[i].getItem(), (this.MymainInventory[i]).stackSize);
/* 227 */         if ((this.MymainInventory[i]).stackSize == 1) is.setItemDamage(this.MymainInventory[i].getItemDamage());
/*     */       
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
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 240 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 247 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 253 */     if (this.isDead)
/* 254 */       return;  super.updateAITasks();
/* 255 */     if (this.worldObj.rand.nextInt(12) == 1) {
/* 256 */       EntityLivingBase e = findSomethingToAttack();
/* 257 */       if (e != null) {
/* 258 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 259 */         if (getDistanceSqToEntity((Entity)e) < 9.0D) {
/*     */           
/* 261 */           attackEntityAsMob((Entity)e);
/* 262 */           if (e instanceof EntityPlayer) {
/* 263 */             EntityPlayer p = (EntityPlayer)e;
/*     */ 
/*     */             
/* 266 */             int k = -1;
/* 267 */             int kp = -1; int i;
/* 268 */             for (i = 0; i < this.MymainInventory.length; i++) {
/* 269 */               if (this.MymainInventory[i] == null) {
/* 270 */                 k = i;
/*     */                 break;
/*     */               } 
/*     */             } 
/* 274 */             if (k >= 0) {
/* 275 */               for (i = p.inventory.armorInventory.length - 1; i >= 0; i--) {
/* 276 */                 if (p.inventory.armorInventory[i] != null) {
/* 277 */                   kp = i;
/*     */                   break;
/*     */                 } 
/*     */               } 
/* 281 */               if (kp >= 0) {
/* 282 */                 this.MymainInventory[k] = p.inventory.armorInventory[kp];
/* 283 */                 p.inventory.armorInventory[kp] = null;
/* 284 */                 this.got_stuff++;
/*     */               } 
/* 286 */               if (kp < 0) {
/* 287 */                 for (i = p.inventory.mainInventory.length - 1; i >= 0; i--) {
/* 288 */                   if (p.inventory.mainInventory[i] != null) {
/* 289 */                     kp = i;
/*     */                     break;
/*     */                   } 
/*     */                 } 
/* 293 */                 if (kp >= 0) {
/* 294 */                   this.MymainInventory[k] = p.inventory.mainInventory[kp];
/* 295 */                   p.inventory.mainInventory[kp] = null;
/* 296 */                   this.got_stuff++;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } else {
/* 302 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
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
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 318 */     if (par1EntityLiving == null)
/*     */     {
/* 320 */       return false;
/*     */     }
/* 322 */     if (par1EntityLiving == this)
/*     */     {
/* 324 */       return false;
/*     */     }
/* 326 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 328 */       return false;
/*     */     }
/* 330 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 333 */       return false;
/*     */     }
/*     */     
/* 336 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 338 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 339 */       if (p.capabilities.isCreativeMode == true) {
/* 340 */         return false;
/*     */       }
/* 342 */       return true;
/*     */     } 
/* 344 */     if (par1EntityLiving instanceof EntityVillager)
/*     */     {
/* 346 */       return true;
/*     */     }
/* 348 */     if (par1EntityLiving instanceof Girlfriend)
/*     */     {
/* 350 */       return true;
/*     */     }
/* 352 */     if (par1EntityLiving instanceof Boyfriend)
/*     */     {
/* 354 */       return true;
/*     */     }
/*     */     
/* 357 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 362 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 363 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 6.0D, 20.0D));
/* 364 */     Collections.sort(var5, this.TargetSorter);
/* 365 */     Iterator<?> var2 = var5.iterator();
/* 366 */     Entity var3 = null;
/* 367 */     EntityLivingBase var4 = null;
/*     */     
/* 369 */     while (var2.hasNext()) {
/*     */       
/* 371 */       var3 = (Entity)var2.next();
/* 372 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 374 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 376 */         return var4;
/*     */       }
/*     */     } 
/* 379 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWhat() {
/* 384 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWhat(int par1) {
/* 389 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/*     */   public boolean getCanSpawnHere() {
/* 401 */     for (int k = -3; k < 3; k++) {
/*     */       
/* 403 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 405 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 407 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 408 */           if (bid == Blocks.mob_spawner) {
/* 409 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 410 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 411 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 412 */             if (s != null && 
/* 413 */               s.equals("Criminal")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 419 */     if (!this.worldObj.isDaytime()) return false; 
/* 420 */     if (this.posY < 50.0D) return false; 
/* 421 */     if (this.posY < 100.0D) return false; 
/* 422 */     BandP target = null;
/* 423 */     target = (BandP)this.worldObj.findNearestEntityWithinAABB(BandP.class, this.boundingBox.expand(32.0D, 12.0D, 32.0D), (Entity)this);
/* 424 */     if (target != null)
/*     */     {
/* 426 */       return false;
/*     */     }
/* 428 */     EntityVillager target2 = null;
/* 429 */     target2 = (EntityVillager)this.worldObj.findNearestEntityWithinAABB(EntityVillager.class, this.boundingBox.expand(36.0D, 12.0D, 36.0D), (Entity)this);
/* 430 */     if (target2 == null)
/*     */     {
/* 432 */       return false;
/*     */     }
/* 434 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 442 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 443 */     if (this.got_stuff != 0) {
/* 444 */       par1NBTTagCompound.setTag("Inventory", (NBTBase)writeToNBT(new NBTTagList()));
/*     */     }
/* 446 */     par1NBTTagCompound.setInteger("GotStuff", this.got_stuff);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 454 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 455 */     this.got_stuff = par1NBTTagCompound.getInteger("GotStuff");
/* 456 */     if (this.got_stuff != 0) {
/* 457 */       NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Inventory", 10);
/* 458 */       readFromNBT(nbttaglist);
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
/*     */   public NBTTagList writeToNBT(NBTTagList par1NBTTagList) {
/* 472 */     for (int i = 0; i < this.MymainInventory.length; i++) {
/*     */       
/* 474 */       if (this.MymainInventory[i] != null) {
/*     */         
/* 476 */         NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 477 */         nbttagcompound.setByte("Slot", (byte)i);
/* 478 */         this.MymainInventory[i].writeToNBT(nbttagcompound);
/* 479 */         par1NBTTagList.appendTag((NBTBase)nbttagcompound);
/*     */       } 
/*     */     } 
/*     */     
/* 483 */     return par1NBTTagList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFromNBT(NBTTagList par1NBTTagList) {
/* 491 */     this.MymainInventory = new ItemStack[100];
/*     */     
/* 493 */     for (int i = 0; i < par1NBTTagList.tagCount(); i++) {
/*     */       
/* 495 */       NBTTagCompound nbttagcompound = par1NBTTagList.getCompoundTagAt(i);
/* 496 */       int j = nbttagcompound.getByte("Slot") & 0xFF;
/* 497 */       ItemStack itemstack = ItemStack.loadItemStackFromNBT(nbttagcompound);
/* 498 */       if (itemstack != null)
/*     */       {
/* 500 */         if (j >= 0 && j < this.MymainInventory.length)
/*     */         {
/* 502 */           this.MymainInventory[j] = itemstack;
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BandP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */