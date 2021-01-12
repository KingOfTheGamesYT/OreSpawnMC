/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
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
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ public class StinkBug
/*     */   extends EntityAnimal
/*     */ {
/*  52 */   private float moveSpeed = 0.15F;
/*     */ 
/*     */   
/*     */   public StinkBug(World par1World) {
/*  56 */     super(par1World);
/*     */     
/*  58 */     setSize(0.55F, 0.55F);
/*  59 */     this.fireResistance = 10;
/*  60 */     getNavigator().setAvoidsWater(true);
/*  61 */     this.experienceValue = 2;
/*  62 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  63 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  64 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  65 */     this.tasks.addTask(5, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 4.0F, 1.0D, 1.399999976158142D));
/*  66 */     this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  67 */     this.tasks.addTask(8, new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  68 */     this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  69 */     this.tasks.addTask(10, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  74 */     super.applyEntityAttributes();
/*  75 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  76 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  77 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  78 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  83 */     super.entityInit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  92 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  93 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITick() {
/* 103 */     if (this.isDead)
/* 104 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 105 */     super.updateAITick();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 123 */     boolean ret = false;
/*     */     
/* 125 */     if (this.isDead) return false;
/*     */     
/* 127 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */ 
/*     */     
/* 130 */     if (getHealth() <= 0.0F || this.isDead) {
/* 131 */       AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(this.posX - 8.0D, this.posY - 5.0D, this.posZ - 8.0D, this.posX + 8.0D, this.posY + 10.0D, this.posZ + 8.0D);
/*     */       
/* 133 */       List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
/* 134 */       Iterator<EntityLivingBase> var2 = var5.iterator();
/* 135 */       EntityLivingBase var3 = null;
/*     */       
/* 137 */       while (var2.hasNext()) {
/*     */         
/* 139 */         var3 = var2.next();
/* 140 */         if (var3 != null)
/*     */         {
/* 142 */           var3.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 0));
/*     */         }
/*     */       } 
/*     */     } 
/* 146 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 157 */     return 5;
/*     */   }
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
/* 173 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 181 */     return "orespawn:fart";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 189 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 197 */     return OreSpawnMain.MyDeadStinkBug;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 207 */     for (int k = -3; k < 3; k++) {
/*     */       
/* 209 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 211 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 213 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 214 */           if (bid == Blocks.mob_spawner) {
/* 215 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 216 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 217 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 218 */             if (s != null && 
/* 219 */               s.equals("Stink Bug")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 225 */     if (this.posY < 50.0D) return false; 
/* 226 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 234 */     if (isChild()) {
/* 235 */       enablePersistence();
/* 236 */       return false;
/*     */     } 
/* 238 */     if (isNoDespawnRequired()) return false; 
/* 239 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 244 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StinkBug spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 250 */     return new StinkBug(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 258 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.fish);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 267 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\StinkBug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */