/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.init.ModItems;
/*     */ import danger.orespawn.items.CritterCage;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
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
/*     */ public class EntityCage
/*     */   extends EntityThrowable
/*     */ {
/*  34 */   public int my_index = 0;
/*     */   public String customName;
/*  36 */   private World throwerWorld = null;
/*  37 */   private EntityPlayer thrower = null;
/*     */ 
/*     */   
/*     */   public EntityCage(World world) {
/*  41 */     super(world);
/*  42 */     this.throwerWorld = world;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityCage(World par1World, EntityPlayer par2EntityLiving, int index, @Nullable String customName) {
/*  47 */     super(par1World, (EntityLivingBase)par2EntityLiving);
/*  48 */     this.throwerWorld = par1World;
/*  49 */     this.thrower = par2EntityLiving;
/*  50 */     this.my_index = index;
/*  51 */     this.customName = customName;
/*  52 */     if (this.thrower.world != null) this.throwerWorld = this.thrower.world;
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCageIndex() {
/*  58 */     return this.my_index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(RayTraceResult result) {
/*  69 */     if (this.my_index == 0) {
/*     */       
/*  71 */       if (result.entityHit != null && this.rand.nextInt(10) >= 2) {
/*     */         
/*  73 */         if (this.throwerWorld != null) {
/*     */ 
/*     */ 
/*     */           
/*  77 */           for (int var3 = 0; var3 < 4; var3++) {
/*     */             
/*  79 */             this.throwerWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, result.entityHit.posX, result.entityHit.posY + 0.25D, result.entityHit.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*  80 */             this.throwerWorld.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, result.entityHit.posX, result.entityHit.posY + 0.25D, result.entityHit.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*  81 */             this.throwerWorld.spawnParticle(EnumParticleTypes.REDSTONE, result.entityHit.posX, result.entityHit.posY + 0.25D, result.entityHit.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */           } 
/*  83 */           if (this.thrower != null)
/*     */           {
/*  85 */             this.thrower.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.5F);
/*     */           }
/*     */         } 
/*  88 */         Entity hit = result.entityHit;
/*     */         
/*  90 */         if (hit instanceof EntityLiving && !(hit instanceof EntityPlayer))
/*     */         {
/*  92 */           CritterCage cc = CritterCage.getCageFromEntity(hit);
/*  93 */           if (cc == null) {
/*     */             return;
/*     */           }
/*  96 */           if (this.rand.nextFloat() < cc.getChance())
/*     */           {
/*  98 */             if (!this.world.isRemote)
/*     */             {
/* 100 */               dropItem((Item)cc, 1);
/* 101 */               ((EntityLiving)hit).setDropItemsWhenDead(false);
/* 102 */               ((EntityLiving)hit).setDead();
/*     */             }
/*     */           
/*     */           }
/*     */         }
/*     */       
/*     */       } 
/* 109 */     } else if (result.getBlockPos() != null || result.entityHit != null) {
/*     */       
/* 111 */       BlockPos position = this.thrower.getPosition();
/* 112 */       if (result.getBlockPos() != null)
/* 113 */         position = result.getBlockPos(); 
/* 114 */       if (result.entityHit != null)
/* 115 */         position = result.entityHit.getPosition(); 
/* 116 */       for (int i = 0; i < 6; i++) {
/*     */         
/* 118 */         this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 119 */         this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 120 */         this.world.spawnParticle(EnumParticleTypes.REDSTONE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/*     */       } 
/* 122 */       this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.5F, true);
/* 123 */       Entity summon = EntityList.createEntityByID(this.my_index - 10, this.world);
/* 124 */       System.out.println(summon);
/*     */       
/* 126 */       summon.setPosition(position.getX(), (position.getY() + 1), position.getZ());
/* 127 */       this.world.spawnEntity(summon);
/*     */ 
/*     */       
/* 130 */       EntityItem empty = new EntityItem(this.world);
/* 131 */       empty.setItem(new ItemStack(ModItems.CageEmpty));
/* 132 */       empty.setPosition(position.getX(), position.getY(), position.getZ());
/* 133 */       this.world.spawnEntity((Entity)empty);
/*     */       
/* 135 */       if (summon instanceof EntityLiving && this.customName != null) {
/* 136 */         summon.setCustomNameTag(this.customName);
/*     */       }
/*     */     } 
/* 139 */     if (!this.world.isRemote)
/*     */     {
/* 141 */       setDead();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 149 */     super.onUpdate();
/* 150 */     this.throwerWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\entity\EntityCage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */