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
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LeafMonster
/*     */   extends EntityMob
/*     */ {
/*  47 */   private GenericTargetSorter TargetSorter = null;
/*  48 */   private float moveSpeed = 0.25F;
/*     */ 
/*     */ 
/*     */   
/*     */   public LeafMonster(World par1World) {
/*  53 */     super(par1World);
/*  54 */     setSize(1.0F, 2.5F);
/*  55 */     getNavigator().setAvoidsWater(true);
/*  56 */     this.experienceValue = 5;
/*  57 */     this.fireResistance = 0;
/*  58 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  59 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858D));
/*  60 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  61 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  66 */     super.applyEntityAttributes();
/*  67 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  68 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  69 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.LeafMonster_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  74 */     super.entityInit();
/*  75 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/*  80 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/*  85 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  90 */     return OreSpawnMain.LeafMonster_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  98 */     return OreSpawnMain.LeafMonster_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {
/* 112 */     float i = MathHelper.ceiling_float_int(par1 - 3.0F);
/*     */     
/* 114 */     if (i > 0.0F) {
/*     */       
/* 116 */       if (i > 2.0F) {
/*     */         
/* 118 */         playSound("damage.fallbig", 1.0F, 1.0F);
/* 119 */         i = 2.0F;
/*     */       }
/*     */       else {
/*     */         
/* 123 */         playSound("damage.fallsmall", 1.0F, 1.0F);
/*     */       } 
/*     */       
/* 126 */       attackEntityFrom(DamageSource.fall, i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 137 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 138 */     super.onUpdate();
/* 139 */     if (getAttacking() == 0) {
/*     */       
/* 141 */       int px = (int)this.posX;
/* 142 */       int py = (int)this.posY;
/* 143 */       int pz = (int)this.posZ;
/* 144 */       this.posX = px;
/* 145 */       this.posY = py;
/* 146 */       this.posZ = pz;
/* 147 */       if (this.posX > 0.0D) this.posX += 0.5D; 
/* 148 */       if (this.posZ > 0.0D) this.posZ += 0.5D; 
/* 149 */       if (this.posX < 0.0D) this.posX -= 0.5D; 
/* 150 */       if (this.posZ < 0.0D) this.posZ -= 0.5D; 
/* 151 */       this.rotationPitch = 0.0F;
/* 152 */       px = (int)this.rotationYawHead;
/* 153 */       px /= 90;
/* 154 */       this.rotationYaw = this.rotationYawHead = (px * 90);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 165 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 173 */     return "orespawn:leaves_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 181 */     return "orespawn:leaves_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 188 */     return 0.65F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 195 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 205 */     int i = this.worldObj.rand.nextInt(3);
/* 206 */     if (i == 0) return Item.getItemFromBlock(Blocks.log); 
/* 207 */     if (i == 1) return Item.getItemFromBlock((Block)Blocks.leaves); 
/* 208 */     return Items.rotten_flesh;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 214 */     super.updateAITasks();
/* 215 */     if (this.isDead)
/* 216 */       return;  if (this.worldObj.rand.nextInt(100) == 1) setRevengeTarget(null); 
/* 217 */     if (this.worldObj.rand.nextInt(4) == 1) {
/* 218 */       EntityLivingBase e = findSomethingToAttack();
/* 219 */       if (e != null) {
/* 220 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 221 */         setAttacking(1);
/* 222 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 223 */         if (getDistanceSqToEntity((Entity)e) < 5.0D)
/*     */         {
/* 225 */           if (this.rand.nextInt(8) == 0 || this.rand.nextInt(10) == 1)
/*     */           {
/* 227 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         }
/*     */       } else {
/* 231 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 242 */     if (par1EntityLiving == null)
/*     */     {
/* 244 */       return false;
/*     */     }
/* 246 */     if (par1EntityLiving == this)
/*     */     {
/* 248 */       return false;
/*     */     }
/* 250 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 252 */       return false;
/*     */     }
/* 254 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 257 */       return false;
/*     */     }
/* 259 */     if (par1EntityLiving instanceof EntityAnt)
/*     */     {
/* 261 */       return true;
/*     */     }
/* 263 */     if (par1EntityLiving instanceof EntityButterfly)
/*     */     {
/* 265 */       return true;
/*     */     }
/* 267 */     if (par1EntityLiving instanceof EntityLunaMoth)
/*     */     {
/* 269 */       return true;
/*     */     }
/* 271 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 273 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 274 */       if (!p.capabilities.isCreativeMode) {
/* 275 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 279 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 284 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 285 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(4.0D, 6.0D, 4.0D));
/* 286 */     Collections.sort(var5, this.TargetSorter);
/* 287 */     Iterator<?> var2 = var5.iterator();
/* 288 */     Entity var3 = null;
/* 289 */     EntityLivingBase var4 = null;
/*     */     
/* 291 */     while (var2.hasNext()) {
/*     */       
/* 293 */       var3 = (Entity)var2.next();
/* 294 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 296 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 298 */         return var4;
/*     */       }
/*     */     } 
/* 301 */     return null;
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
/* 313 */     for (int k = -3; k < 3; k++) {
/*     */       
/* 315 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 317 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 319 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 320 */           if (bid == Blocks.mob_spawner) {
/* 321 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 322 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 323 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 324 */             if (s != null && 
/* 325 */               s.equals("Leaf Monster")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 331 */     if (!isValidLightLevel()) return false; 
/* 332 */     if (this.worldObj.isDaytime()) return false; 
/* 333 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4)
/* 334 */     { if (this.posY > 20.0D) return false;
/*     */        }
/* 336 */     else if (this.posY < 50.0D) { return false; }
/*     */     
/* 338 */     if (findBuddies() > 4) return false; 
/* 339 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 344 */     List var5 = this.worldObj.getEntitiesWithinAABB(LeafMonster.class, this.boundingBox.expand(20.0D, 10.0D, 20.0D));
/* 345 */     return var5.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 352 */     if (isNoDespawnRequired()) return false; 
/* 353 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\LeafMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */